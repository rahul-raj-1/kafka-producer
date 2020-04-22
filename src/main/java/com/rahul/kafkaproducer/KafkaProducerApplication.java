package com.rahul.kafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.rahul.kafkaproducer.producer.FixedRateProducer;
import com.rahul.kafkaproducer.producer.HelloKafkaProducer;

@SpringBootApplication
@EnableScheduling
public class KafkaProducerApplication implements CommandLineRunner{

	@Autowired
	private HelloKafkaProducer helloKafkaProducer;
	
	@Autowired
	private FixedRateProducer fixedRateProducer;
	
	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		

		//helloKafkaProducer.sendHello(" Rahul" + " " + Math.random());
		
		fixedRateProducer.sendMessage();
		
	}

}
