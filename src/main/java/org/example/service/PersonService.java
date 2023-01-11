package org.example.service;

import org.example.domain.Person;

public interface PersonService {
    Person findByName(String name);

    Long getAverageSalary(String name);
}
