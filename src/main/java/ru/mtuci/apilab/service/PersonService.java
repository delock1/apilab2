package ru.mtuci.apilab.service;

import ru.mtuci.apilab.model.Person;

import java.util.List;

public interface PersonService {
    Person get(Long id);

    List<Person> getAll();

    Person save(Person person);

    void delete(Long id);
}
