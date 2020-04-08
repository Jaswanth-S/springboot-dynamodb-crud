package com.stackroute.springbootdynamodbcrud.controller;

import com.stackroute.springbootdynamodbcrud.exception.PersonAlreadyExistsException;
import com.stackroute.springbootdynamodbcrud.exception.PersonNotFoundException;
import com.stackroute.springbootdynamodbcrud.exception.PersonsNotFoundException;
import com.stackroute.springbootdynamodbcrud.model.Person;
import com.stackroute.springbootdynamodbcrud.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PersonController {
    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService=personService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> savePerson(@RequestBody Person person) throws PersonAlreadyExistsException{
        return new ResponseEntity<>(personService.savePerson(person), HttpStatus.CREATED);
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAllPersons() throws PersonsNotFoundException {
        return new ResponseEntity<>(personService.getAllPersons(),HttpStatus.FOUND);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updatePerson(@RequestBody Person person) throws PersonNotFoundException{
        return new ResponseEntity<>(personService.updatePerson(person),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{email}")
    public ResponseEntity<?> deletePerson(@RequestParam() String email) throws PersonNotFoundException{
        return new ResponseEntity<>(personService.deletePerson(email),HttpStatus.OK);
    }

}
