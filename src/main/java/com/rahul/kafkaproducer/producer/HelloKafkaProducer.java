package com.rahul.kafkaproducer.producer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.Metric;
import org.apache.kafka.common.MetricName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.kafka.core.KafkaProducerException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.rahul.kafkaproducer.service.Person;



@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS) 
class Sender {

	
	
    private static final Logger LOG = LoggerFactory.getLogger(Sender.class);
    
    @Autowired
    private KafkaTemplate<String, Person> template;
    
    List<ProducerRecord<?, ?>> list = new ArrayList<ProducerRecord<?, ?>>();

    public List<ProducerRecord<?, ?>> sendThem( List<Person> toSend) throws InterruptedException {
        List<ListenableFuture<SendResult<String, Person>>> futures = new ArrayList<>();
        CountDownLatch latch = new CountDownLatch(toSend.size());
        ListenableFutureCallback<SendResult<String, Person>> callback = new ListenableFutureCallback<SendResult<String, Person>>() {

            @Override
            public void onSuccess(SendResult<String, Person> result) {
                LOG.info(result.getRecordMetadata().toString());
                latch.countDown();
            }

            @Override
            public void onFailure(Throwable ex) {
                ProducerRecord<?, ?> producerRecord = ((KafkaProducerException) ex).getProducerRecord();
                LOG.error("Failed; " + producerRecord.value(), ex);
                list.add(producerRecord);
                latch.countDown();
            }
        };
        toSend.forEach(str -> {
             ListenableFuture<SendResult<String, Person>> future = template.send("t_101", str);
             future.addCallback(callback);
        });
        if (latch.await(25, TimeUnit.MINUTES)) {
            LOG.info("All sent ok");
        }
        else {
            for (int i = 0; i < toSend.size(); i++) {
                if (!futures.get(i).isDone()) {
                    LOG.error("No send result for " + toSend.get(i));
                }
            }
      
            
            
        }
		return list;
    }

}
