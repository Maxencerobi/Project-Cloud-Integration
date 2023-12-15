package fr.efrei.server.service;

import fr.efrei.server.domain.Person;
import fr.efrei.server.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    public final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    // Read-All Person
    public List<Person> findAll() {
        return personRepository.findAll();
    }
    // Read-One Person
    public Person getPersonById(Integer id) {
        return personRepository.findById(id).orElse(null);
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }
    public Person updatePerson(Integer id, String name, Integer age){

        Person existingPerson = personRepository.findById(id).orElse(null);
        if(existingPerson !=null) {
            existingPerson.setName(name);
            existingPerson.setAge(age);
            return personRepository.save(existingPerson);
        }

        return null;
    }

    public Integer deletePerson(Integer id){
        Person existingPerson = personRepository.findById(id).orElse(null);

        if(existingPerson!=null) {
            personRepository.delete(existingPerson);
            return 1;
        }

        return 0;
    }
}