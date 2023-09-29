package com.proinproject.registrationconsumer.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.proinproject.registrationconsumer.model.Person;
import com.proinproject.registrationconsumer.persrepo.repository;

@SpringBootTest
public class controllertest {

	@InjectMocks
	private homecontroller cont;
	
	@Mock
	private repository repo;
	
	@Mock
	private PasswordEncoder encode;
	
	@Test
	public void jkhg() {
		String ss=cont.dsa();
		assertEquals(ss,"hello world!");
	}
	
//	@Test
//	public void kks() {
//		Person dd=new Person();
//		dd.setEmail("dd");
//		dd.setFirstName("dd");
//		dd.setLastName("dd");
//		dd.setRole("dd");
//		dd.setPassword("dd");
//		dd.setUserName("dd");
//		
//		when(repo.save(dd)).thenReturn(dd);
//		Person pp=cont.perrr(dd);
//		assertEquals(pp.getEmail(),"dd");
//	}
//	
	@Test
	public void kjuj() {
		ResponseEntity<String> kjjk=cont.kjk("dd");
		assertEquals(kjjk.getBody(),"Deleted &Dusted");
	}
	
	@Test
	public void kudd() {
		Person dd=new Person();
		dd.setEmail("dd");
		dd.setFirstName("dd");
		dd.setLastName("dd");
		dd.setRole("dd");
		dd.setPassword("dd");
		dd.setUserName("dd");
		Person dd1=new Person("dd","dd1","dd1","dd1","dd1","dd1");
		when(repo.findById("dd")).thenReturn(Optional.of(dd1));
		ResponseEntity<Person> kjhj=cont.wsd(dd1, "dd");
		assertEquals(kjhj.getStatusCode(),HttpStatus.ACCEPTED);
		
	}
	
	@Test
	public void kuddos() {
		List<Person> ns=new ArrayList();
		ns.add(new Person("dd","dd1","dd1","dd1","dd1","dd1"));
		ns.add(new Person("dd1","dd2","dd2","dd2","dd2","dd2"));
		when(repo.findAll()).thenReturn(ns);
		ResponseEntity<List<Person>> dssd=cont.sdds();
		assertEquals(dssd.getBody().size(),2);
	}
	
}
