package com.rahul.kafkaproducer.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.rahul.kafkaproducer.entity.User;

@Service
@Scope("prototype")
public class HelloKafkaProducer2 {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	private boolean sendEmail = true;

	String topicName = "t_hello_world";
	
	int i=0;

	public void  sendMessage(String message) {
		
		
		while ( i < 600)
		{
		
	  ListenableFuture<SendResult<String,String>>   future = kafkaTemplate.send(topicName, message);

		
		i++;
		
		future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

			@Override
			public void onSuccess(SendResult<String, String> result) {

				System.out.println("Sent message=[" + message + "] with offset=[" + result.getRecordMetadata().offset()
						+ "]" + " thread name --" +

						Thread.currentThread().getName());
			}

			@Override
			public void onFailure(Throwable ex) {

				System.out.println("sendEmail----------- " + sendEmail);

				if (ex.getMessage().equals(
						"Failed to send; nested exception is org.apache.kafka.common.errors.TimeoutException: Topic t_hello_world not present in metadata after 60000 ms.")

						&& sendEmail

				) {

					sendEmail = false;
					System.out.println(" send email ");
				}

				System.out.println("Unable to send message=[" + message + "] due to : " + ex.getMessage());
			}
		});

		}


		
		
		 
	}
	
	
}
