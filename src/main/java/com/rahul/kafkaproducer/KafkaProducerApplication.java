package com.rahul.kafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
public class KafkaProducerApplication  {

	
	
	

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerApplication.class, args);
	}

	/*@Override
     public void run(String... args) throws InterruptedException {

		List<Person> personList = null;
		 ObjectMapper mapper = new ObjectMapper();
	      mapper.enable(SerializationFeature.INDENT_OUTPUT);

		try {
			personList = csv.sendHello();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (CollectionUtils.isEmpty(personList)) { // line3
			System.out.println("personList is empty or null "); // line4
		} else {
			personList.forEach(value -> System.out.println(value.toString())); // line5
		}
		
		System.out.println(" before thread");

		
		//Thread.sleep(12000);
		
		System.out.println(" after thread");
		

	}
	*/

}
