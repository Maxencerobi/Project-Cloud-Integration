package fr.efrei.server.web.rest;

import fr.efrei.server.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import fr.efrei.server.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonResource {

    public final PersonService personService;

    public PersonResource(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    public List<Person> test() {
        return personService.findAll();
    }
}
