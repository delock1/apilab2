package ru.mtuci.apilab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mtuci.apilab.dao.PersonRepository;

@Component
public class ComandLineAppStartupRunner {

    private final PersonRepository personRepository;

    @Autowired
    public ComandLineAppStartupRunner(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public void run(String...args) throws Exception {
        //System.out.println(personRepository.findAll());
    }
}
