package com.proinproject.registrationconsumer.constants;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class constantstyest {

	@InjectMocks
	private AppConstants cons;
	
	@Test
	public void jkjhj() {
		assertEquals(cons.host,"localhost:9092");
		assertEquals(cons.topic,"person-data");
		
	}
}
