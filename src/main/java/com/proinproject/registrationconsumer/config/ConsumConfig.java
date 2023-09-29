package com.proinproject.registrationconsumer.config;

import java.util.HashMap;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import com.fasterxml.jackson.databind.JsonDeserializer;

import com.proinproject.registrationconsumer.constants.AppConstants;
import com.proinproject.registrationconsumer.model.Person;

@Configuration
public class ConsumConfig {

	@Bean
	public ConsumerFactory<String,Person> cdc() {
		HashMap<String,Object> dsad=new HashMap();
		dsad.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,AppConstants.host);
		dsad.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		dsad.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,JsonDeserializer.class);
		return new DefaultKafkaConsumerFactory<>(dsad);
		
		
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory assa() {
		ConcurrentKafkaListenerContainerFactory eew=new ConcurrentKafkaListenerContainerFactory();
		eew.setConsumerFactory(cdc());
		return eew;
	}
}
