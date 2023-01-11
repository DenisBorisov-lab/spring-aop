package org.example.repository;

import org.example.domain.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {
    @Override
    public List<Person> findAll() {
        return List.of(
                new Person("John", 22, 240),
                new Person("Andrew", 37, 50),
                new Person("Max", 30, 80),
                new Person("Alex", 24, 70));
    }
}
