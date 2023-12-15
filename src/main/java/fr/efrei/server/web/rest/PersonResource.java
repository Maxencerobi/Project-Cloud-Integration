package fr.efrei.server.web.rest;

import fr.efrei.server.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import fr.efrei.server.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonResource {

    public final PersonService personService;

    public PersonResource(PersonService personService) {
        this.personService = personService;
    }
    // Read all person
    @GetMapping("/persons")
    public List<Person> test() {
        return personService.findAll();
    }

    // Read person based on ID
    @GetMapping("/persons/{id}")
    public Person getPersonById(@PathVariable String id) {

        Integer parsedId;
        try {
            parsedId = Integer.parseInt(id);

        }catch (NumberFormatException e){
            parsedId = 0;
        }
        Person person = personService.getPersonById(parsedId);

        return person;
    }

    @PostMapping("/persons/create")
    public Person createPerson(@RequestParam   String name, @RequestParam  Integer age) {


        Person person = new Person();

        person.setName(name);
        person.setAge(age);

        Person createdPerson = personService.createPerson(person);

        return createdPerson;
    }
    @PutMapping("/persons/update/{id}")
    public Person updatePerson(@PathVariable Integer id, @RequestParam String name, @RequestParam Integer age) {
        Person person = personService.updatePerson(id, name, age);
        return person;
    }

    @DeleteMapping("persons/delete/{id}")
    public String deletePerson(@PathVariable Integer id){
        Integer deleted = personService.deletePerson(id);
        if(deleted==1){
            return "Person was deleted.";
        }
        return "Person was not found.";
    }



}
