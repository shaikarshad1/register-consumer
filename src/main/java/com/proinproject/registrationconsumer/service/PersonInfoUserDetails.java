package com.proinproject.registrationconsumer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.proinproject.registrationconsumer.Secuconfig.InfoUserDetail;
import com.proinproject.registrationconsumer.model.Person;
import com.proinproject.registrationconsumer.persrepo.repository;

@Component
public class PersonInfoUserDetails implements UserDetailsService {
	
	@Autowired
	private repository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Person> per=repo.findById(username);
		
		return per.map(InfoUserDetail::new).orElseThrow(
				()->new UsernameNotFoundException("User with "+username+" is Not Found!"));
	}

}
