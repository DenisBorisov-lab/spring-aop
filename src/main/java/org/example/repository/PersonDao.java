package org.example.repository;

import org.example.domain.Person;

import java.util.List;

public interface PersonDao {
    List<Person> findAll();
}
