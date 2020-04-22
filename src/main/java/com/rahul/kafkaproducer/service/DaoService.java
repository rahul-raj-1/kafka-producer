package com.rahul.kafkaproducer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.kafkaproducer.dao.DbDao;

@Service
public class DaoService {
	
	@Autowired
	private DbDao dbDao;
	
	
	public void serviceMethod()
	{
		dbDao.m1();
		

	}

}
