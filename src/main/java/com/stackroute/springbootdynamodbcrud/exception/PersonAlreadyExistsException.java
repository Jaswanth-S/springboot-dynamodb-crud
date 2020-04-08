package com.stackroute.springbootdynamodbcrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "Person already exists")
public class PersonAlreadyExistsException extends Exception {

}
