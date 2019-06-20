package com.walter.service.impl;

import com.walter.domain.Person;
import com.walter.repository.PersonRepository;
import com.walter.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Flux<Person> listAll() {
        return personRepository.findAll();
    }
}
