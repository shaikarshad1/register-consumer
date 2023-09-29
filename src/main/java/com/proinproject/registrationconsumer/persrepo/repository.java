package com.proinproject.registrationconsumer.persrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proinproject.registrationconsumer.model.Person;



public interface repository extends JpaRepository<Person,String> {

}
