package com.example.homework.Exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus()
public class EmployeeAlreadyAddedException extends RuntimeException{
    public EmployeeAlreadyAddedException() {
        super();
    }
}
