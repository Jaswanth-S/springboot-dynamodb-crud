package com.stackroute.springbootdynamodbcrud.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Person Not Found")
public class PersonNotFoundException extends Exception {
}
