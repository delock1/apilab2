package ru.mtuci.apilab.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.mtuci.apilab.model.Person;
import ru.mtuci.apilab.service.PersonService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = PersonController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonController {
    public static final String REST_URL = "/api/v1/persons";


    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/{id}")
    public Person get(@PathVariable("id") Long id) {
        log.info("get" + id);
        return personService.get(id);
    }


    @GetMapping
    public List<Person> getAll() {
        log.info("getAll");
        return personService.getAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person save(@RequestBody Person person){
        log.info("save" + person);
        return personService.save(person);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        log.info("delete" + id);
        personService.delete(id);
    }
}