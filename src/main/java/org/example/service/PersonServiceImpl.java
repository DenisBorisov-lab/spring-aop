package org.example.service;

import org.example.domain.Person;
import org.example.repository.PersonDao;
import org.example.repository.PersonDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonServiceImpl(PersonDaoImpl personDao) {
        this.personDao = personDao;
    }

    @Override
    public Person findByName(String name) {
        for (Person person : personDao.findAll()) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    @Override
    public Long getAverageSalary(String name) {
        Person person = findByName(name);
        return person.getSalary();
    }


}
