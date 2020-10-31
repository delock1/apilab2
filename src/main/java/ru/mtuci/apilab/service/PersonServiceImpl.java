package ru.mtuci.apilab.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mtuci.apilab.dao.PersonRepository;
import ru.mtuci.apilab.model.Person;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;

    }
    @Override
    public Person get(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void delete(Long id) {
        personRepository.delete(id);
    }
}
