package com.proinproject.registrationconsumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proinproject.registrationconsumer.model.Person;
import com.proinproject.registrationconsumer.persrepo.repository;

@Service
public class listenerclass {
	@Autowired
	private repository repo;
	
	@Autowired
	private PasswordEncoder encoder;

	@KafkaListener(groupId = "and",topics = "person-data")
	public void kjj(String mes) throws JsonMappingException, JsonProcessingException {
		System.out.println(mes);
		System.out.println("in listener");
		ObjectMapper obj=new ObjectMapper();
		Person perr=obj.readValue(mes,Person.class);
		perr.setPassword(encoder.encode(perr.getPassword()));
		System.out.println(perr.getPassword());
		
		repo.save(perr);
		System.out.println("Consumer done & Dusted");
	}
}
