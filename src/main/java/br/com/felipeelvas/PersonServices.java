package br.com.felipeelvas;

import br.com.felipeelvas.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private  final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll() {
        logger.info("Finding all persons!");
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public Person findById(String id) {
        logger.info("Finding one person!");

        //mocking a person
        Person person = new Person();
        person.setId(counter.incrementAndGet()); //simulate a database ID
        person.setFirstName("Felipe");
        person.setLastName("Elvas");
        person.setAddress("Brasília - DF - Brazil");
        person.setGender("Male");
        return person;
    }

    public Person create(Person person) {

        logger.info("Creating one person!");

        return person;
    }

    public Person update(Person person) {

        logger.info("Updating one Person!");

        return person;
    }

    public void delete(String id) {

        logger.info("Deleting one Person!");

    }
    private Person mockPerson(int i) {
            //mocking a person
            Person person = new Person();
            person.setId(counter.incrementAndGet()); //simulate a database ID
            person.setFirstName("Firstname " + i);
            person.setLastName("Lastname " + i);
            person.setAddress("Some Address in Brazil " + i);
            person.setGender("Male");
            return person;
        }
}
