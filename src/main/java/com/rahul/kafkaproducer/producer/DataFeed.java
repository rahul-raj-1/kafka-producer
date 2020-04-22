package com.rahul.kafkaproducer.producer;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.context.WebApplicationContext;

@Service
public class DataFeed {
	
	@Autowired
	private HelloKafkaProducer helloKafkaProducer;
	
	@Autowired
    private WebApplicationContext context;
	
	private String str="Abc";


	
	public void m1( )
	{
		
		
		HelloKafkaProducer obj = (HelloKafkaProducer) context.getBean("helloKafkaProducer");
		List<ListenableFuture<SendResult<String, String>>> myKafkaFutures = obj.sendMessage(str);
		
		System.out.println("------ processing not done ------");

		
		for( ListenableFuture<SendResult<String, String>> m : myKafkaFutures)
		{
			try {
				m.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
			
		
		System.out.println("------ processing done in parent class------");

		
		
		
		

	

		
		
		
		
		

	}

}
