package com.stackroute.springbootdynamodbcrud.repository;

import com.stackroute.springbootdynamodbcrud.model.Person;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;


@EnableScan
public interface PersonRepository extends CrudRepository<Person,String> {
}
