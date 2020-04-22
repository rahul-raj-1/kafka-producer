package com.rahul.kafkaproducer.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Csv {

	private static final String COMMA = ",";
	
	//@Autowired
	//private EmailService emailService;

	private  Person mapToPerson (String line)
	{
		String[] p = line.split(COMMA);// a CSV has comma separated lines
		Person person = new Person();
	
		try {
		person.setId( Integer.parseInt(p[0]));
		person.setFirstName(p[1]);
		person.setLastName(p[2]);
		person.setEmail(p[3]);
        person.setProfession(p[4]);
		return person;

		}
		
		catch( Exception e)
		{
			System.out.println(" error here " + person.toString() );
			//emailService.sendMail("t", "g", "person.toString()");

			

			//e.printStackTrace();
			return null;

		}
      		// more initialization goes here
	};

	public List<Person> sendHello() throws IOException {

		String inputFilePath = "C:\\Users\\91895\\Desktop\\sample.csv";

		List<Person> inputList = new ArrayList<Person>();
		try {
			File inputF = new File(inputFilePath);
			InputStream inputFS = new FileInputStream(inputF);
			BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
			inputList = br
					.lines()
					.skip(1)
					.map(this::mapToPerson)
				    .filter( this::checkValidObject  )
					.collect(Collectors.toList());
			br.close();
			

		} catch (IOException e) {

			e.printStackTrace();
		}
		
		System.out.println( " Processing done ");

		return inputList;
	}

	private boolean checkValidObject(Person person) {

		if (person.id == null || person.getFirstName().length() < 6) {
			System.out.println("Object Rejected -- > " + person.getId()); // save object in DB or log
			return false;
		}

		else {
			return true;
		}

	}
	
	
	
	
	
	
	
	
	

	
	
}
