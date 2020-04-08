package com.stackroute.springbootdynamodbcrud.service;

import com.stackroute.springbootdynamodbcrud.exception.PersonAlreadyExistsException;
import com.stackroute.springbootdynamodbcrud.exception.PersonNotFoundException;
import com.stackroute.springbootdynamodbcrud.exception.PersonsNotFoundException;
import com.stackroute.springbootdynamodbcrud.model.Person;
import com.stackroute.springbootdynamodbcrud.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository= personRepository;
    }

    @Override
    public Person savePerson(Person person) throws PersonAlreadyExistsException {
        if (personRepository.findById(person.getEmail()).isPresent())
            throw new PersonAlreadyExistsException();
        else
            return personRepository.save(person);
    }

    @Override
    public List<Person> getAllPersons() throws PersonsNotFoundException {
        List<Person> result = (List<Person>) personRepository.findAll();
        if (result.size()>0)
            return result;
        else
         throw new PersonsNotFoundException();
    }

    @Override
    public Person deletePerson(String email) throws PersonNotFoundException {
        Optional<Person> person = personRepository.findById(email);

        if (person.isPresent()) {
            personRepository.deleteById(email);
            return person.get();
        }
        else
            throw new PersonNotFoundException();
    }

    @Override
    public Person updatePerson(Person person) throws PersonNotFoundException {
        if (!personRepository.findById(person.getEmail()).isPresent())
            throw new PersonNotFoundException();
        else
            return personRepository.save(person);
    }
}
