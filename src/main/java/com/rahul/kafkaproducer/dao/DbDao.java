package com.rahul.kafkaproducer.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class DbDao {

	List<String> list = new ArrayList<String>();

	

	public void m1() {

		list = new ArrayList<String>();


		list.add("one");

		for (String l : list)
			System.out.println(l);
		
		System.out.println(" end");

	}

}
