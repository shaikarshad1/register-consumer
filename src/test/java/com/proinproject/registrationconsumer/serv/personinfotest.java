package com.proinproject.registrationconsumer.serv;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.proinproject.registrationconsumer.model.Person;
import com.proinproject.registrationconsumer.persrepo.repository;
import com.proinproject.registrationconsumer.service.PersonInfoUserDetails;

@SpringBootTest
public class personinfotest {

	@InjectMocks
	private PersonInfoUserDetails peerrr;
	
	@Mock
	private repository repo;
	
	@Test
	public void jkkj() {
		Person dd1=new Person("dd","dd1","dd1","dd1","dd1","dd1");
		when(repo.findById("dd")).thenReturn(Optional.of(dd1));
		UserDetails ss=peerrr.loadUserByUsername("dd");
		assertNotNull(ss);

	}
	
//	@Test
//	public void jkkjEcept() {
//		Person dd1=new Person("dd1","dd1","dd1","dd1","dd1","dd1");
//		when(repo.findById("dd")).thenThrow(new UsernameNotFoundException("User with "+dd1.getUserName()+" is Not Found!"));
//		UserDetails ss=peerrr.loadUserByUsername("dd");
//		assertEquals("User with "+dd1.getUserName()+" is Not Found!",ss.ge);
//
//	}
}
