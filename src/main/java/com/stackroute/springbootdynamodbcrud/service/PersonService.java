package com.stackroute.springbootdynamodbcrud.service;

import com.stackroute.springbootdynamodbcrud.exception.PersonAlreadyExistsException;
import com.stackroute.springbootdynamodbcrud.exception.PersonNotFoundException;
import com.stackroute.springbootdynamodbcrud.exception.PersonsNotFoundException;
import com.stackroute.springbootdynamodbcrud.model.Person;

import java.util.List;


public interface PersonService {
     Person savePerson(Person person) throws PersonAlreadyExistsException;
     List<Person> getAllPersons() throws PersonsNotFoundException;
     Person deletePerson(String email) throws PersonNotFoundException;
     Person updatePerson(Person person) throws PersonNotFoundException;
}
