package br.com.chfb.rest_api_aula.services;

import br.com.chfb.rest_api_aula.exceptions.ResourceNotFoundException;
import br.com.chfb.rest_api_aula.models.Person;
import br.com.chfb.rest_api_aula.repositorys.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    PersonRepository repository;

    public List<Person> findAll() {
        logger.info("Find");
        return repository.findAll();
    }

    public Person findById(Long id) {
        logger.info("Find");
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found with this id"));
    }

    public Person create(Person person) {
        logger.info("Create");
        return repository.save(person);
    }

    public Person update(Person person) {
        logger.info("Update");
        Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found with this id"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(entity);
    }

    public void delete(Long id) {
        Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found with this id"));
        repository.delete(entity);
    }
}
