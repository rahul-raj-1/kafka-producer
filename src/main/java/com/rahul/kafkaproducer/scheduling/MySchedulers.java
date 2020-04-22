package com.rahul.kafkaproducer.scheduling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.rahul.kafkaproducer.dao.DbDao;
import com.rahul.kafkaproducer.producer.DataFeed;

//@Scheduled(cron = "[Seconds] [Minutes] [Hours] [Day of month] [Month] [Day of week] [Year]")

@Component
@EnableScheduling
public class MySchedulers {

	@Autowired
	private DataFeed dataFeed;
	@Autowired
	private DbDao dbDao;
	


	//@Scheduled(cron = "*/20 * * * * ?")
	@Scheduled(fixedDelay = 20000000)
     public void process() {
		
		dataFeed.m1();
		
		

	}

}