package com.walter.service;

import com.walter.domain.Person;
import reactor.core.publisher.Flux;

public interface PersonService {

    Flux<Person> listAll();
}
