package com.proinproject.registrationconsumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proinproject.registrationconsumer.model.Person;
import com.proinproject.registrationconsumer.model.usercredentials;
import com.proinproject.registrationconsumer.persrepo.repository;
import com.proinproject.registrationconsumer.service.PersonInfoUserDetails;

@RestController
@CrossOrigin("*")
public class homecontroller {
	
	@Autowired
	private repository repo;
	
	@Autowired
	private PasswordEncoder encode;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@GetMapping("/hell")
	public String dsa() {
		return "hello world!";
		
		
	}
	
	
	
	@PostMapping("/login")
	public ResponseEntity<String> edf(@RequestBody usercredentials usee) throws Exception{
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usee.getUserName(), usee.getPassword()));
        if (!authentication.isAuthenticated()) {
            throw new UsernameNotFoundException("invalid user request !");
        }
		
		return ResponseEntity.status(HttpStatus.OK).body(null);
		
	}
//	
	
	
	
//	@PostMapping("/add")
//	public Person perrr(@RequestBody Person per) {
//		per.setPassword(encode.encode(per.getPassword()));
//		return repo.save(per);
//	}
	
	@DeleteMapping("/del/{name}")
	//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<String> kjk(@PathVariable String name){
		repo.deleteById(name);
		return ResponseEntity.status(HttpStatus.OK).body("Deleted &Dusted");
	}
	
	@PatchMapping("/edi/{name}")
	//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<Person> wsd(@RequestBody Person perr,@PathVariable String name){
		Person dd=repo.findById(name).get();
		dd.setEmail(perr.getEmail());
		dd.setFirstName(perr.getFirstName());
		dd.setLastName(perr.getLastName());
		dd.setRole(perr.getRole());
		dd.setPassword(perr.getPassword());
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(repo.save(dd));
	}
	@GetMapping("/get/{name}")
	public ResponseEntity<Person> edds(@PathVariable String name){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(repo.findById(name).orElse(null));
	}
	@GetMapping("/all")
//	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<List<Person>> sdds(){
		return ResponseEntity.status(HttpStatus.OK).body(repo.findAll());
	}
}
