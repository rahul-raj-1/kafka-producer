package com.rahul.kafkaproducer.producer;

import java.util.ArrayList;
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

	int counter ;
	ListenableFuture<SendResult<String, String>> future = null;
	

	public List<ListenableFuture<SendResult<String, String>>> sendMessage(String message) {
		
		List<ListenableFuture<SendResult<String, String>>> cf = new ArrayList<ListenableFuture<SendResult<String, String>>>();
		


		while (i < 70000) {

			future = kafkaTemplate.send(topicName, message);
			cf.add(future);

			i++;

			future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

				@Override
				public void onSuccess(SendResult<String, String> result) {

					System.out.println(" thread name  " +  counter++ + Thread.currentThread().getName());

				}

				@Override
				public void onFailure(Throwable ex) {

					System.out.println(" sending failed");

				}
			});

		}

		System.out.println("------ processing done here------");

		return cf;

	}

}
