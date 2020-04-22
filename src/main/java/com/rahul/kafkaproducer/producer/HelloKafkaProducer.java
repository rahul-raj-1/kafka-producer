package com.rahul.kafkaproducer.producer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@Scope("prototype")
public class HelloKafkaProducer {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;


	String topicName = "t_hello_world";

	int i = 0;
	
	List<ListenableFuture<SendResult<String, String>>>  future =null;

	public List<ListenableFuture<SendResult<String, String>>> sendMessage(String message) {

		while (i < 600) {

			ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicName, message);

			i++;

			future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

				@Override
				public void onSuccess(SendResult<String, String> result) {

					System.out.println(" thread name --" + Thread.currentThread().getName());
				}

				@Override
				public void onFailure(Throwable ex) {

					System.out.println(" sending failed");

				}
			});

		}
		return future;

	}

}
