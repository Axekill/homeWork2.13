package com.example.homework.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus()
public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(){
        super();
    }


}
