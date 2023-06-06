package com.example.homework.Exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus()
public class EmployeeStorageIsFullException extends RuntimeException{
    public EmployeeStorageIsFullException() {
        super();
    }
}
