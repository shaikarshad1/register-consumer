package com.proinproject.registrationconsumer.serv;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.proinproject.registrationconsumer.persrepo.repository;
import com.proinproject.registrationconsumer.service.listenerclass;

@SpringBootTest
public class lisrenertest {

	@InjectMocks
	private listenerclass listen;
	
	@Mock
	private repository repo;
	
	@Mock
	private PasswordEncoder encoder;
	
	@Test
	public void kjhgf() throws JsonMappingException, JsonProcessingException {
		listen.kjj("{\r\n"
				+ "   \r\n"
				+ "	\"userName\":\"HrithikRa0\",\r\n"
				+ "	\"firstName\":\"Chandu Reddy\",\r\n"
				+ "	\"lastName\":\"A B\",\r\n"
				+ "	\"role\":\"Admin\",    \r\n"
				+ "    \"email\":\"chandu@gmail.com\",\r\n"
				+ "	\"password\":\"123456\"\r\n"
				+ "}");
	}

}
