package br.com.felipeelvas.services;

import br.com.felipeelvas.data.dto.v1.PersonDTO;
import br.com.felipeelvas.data.dto.v2.PersonDTOV2;
import br.com.felipeelvas.exception.ResourceNotFoundException;
import static br.com.felipeelvas.mapper.ObjectMapper.parseListObject;
import static br.com.felipeelvas.mapper.ObjectMapper.parseObject;

import br.com.felipeelvas.mapper.custom.PersonMapper;
import br.com.felipeelvas.model.Person;
import br.com.felipeelvas.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonServices {
    private  final AtomicLong counter = new AtomicLong();
    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    @Autowired
    PersonMapper converter;

    public List<PersonDTO> findAll() {
        logger.info("Finding all People!");
        return parseListObject(repository.findAll(), PersonDTO.class);
    }

    public PersonDTO findById(Long id) {
        logger.info("Finding one person!");
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        return parseObject(entity, PersonDTO.class);
    }

    public PersonDTO create(PersonDTO person) {
        logger.info("Creating one person!");
        var entity = parseObject(person, Person.class);
        return parseObject(repository.save(entity), PersonDTO.class);
    }

    public PersonDTOV2 createV2(PersonDTOV2 person) {
        logger.info("Creating one person V2!");
        var entity = converter.convertDTOToEntity(person);
        return converter.convertEntityToDTO(repository.save(entity));
    }

    public PersonDTO update(PersonDTO person) {
        logger.info("Updating one Person!");
        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return parseObject(repository.save(entity), PersonDTO.class);
    }

    public void delete(Long id) {
        logger.info("Deleting one Person!");
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }
}
