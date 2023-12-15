package fr.efrei.server.web.rest;

import fr.efrei.server.domain.Person;
import fr.efrei.server.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource(
        locations = "classpath:application-test.properties")
public class PersonResourceIT {
    @Autowired
    private PersonRepository personRepository;


    @Test
    @Transactional
    void readOneStudent() throws Exception {
        Person personFound = personRepository.findById(1).orElse(null);

        assertThat(personFound.getId()).isEqualTo(1);
        assertThat(personFound.getName()).isEqualTo("Joe");
        assertThat(personFound.getAge()).isEqualTo(6);

    }

    @Test
    @Transactional
    void updateStudent() throws Exception {

        Person studentFound = personRepository.findById(1).orElse(null);


        studentFound.setName("David");
        studentFound.setAge(23);
        personRepository.save(studentFound);


        Person studentUpdated = personRepository.findById(1).orElse(null);
        assertThat(studentUpdated.getName()).isEqualTo("David");
        assertThat(studentUpdated.getAge()).isEqualTo(23);

    }


    @Test
    @Transactional
    void createItem() throws Exception {
        int databaseSizeBeforeCreate = personRepository.findAll().size();
        assertThat(databaseSizeBeforeCreate).isEqualTo(1);

        Person person = new Person();
        person.setName("Pierre");
        person.setAge(10);
        personRepository.save(person);

        List<Person> itemList = personRepository.findAll();
        assertThat(itemList).hasSize(databaseSizeBeforeCreate + 1);
    }

    @Test
    @Transactional
    void deleteStudent() throws Exception {
        int databaseSizeBeforeDelete = personRepository.findAll().size();

        Person personFound = personRepository.findById(1).orElse(null);

        personRepository.delete(personFound);

        assertThat(personRepository.findAll().size()).isEqualTo(databaseSizeBeforeDelete - 1);

    }


}
