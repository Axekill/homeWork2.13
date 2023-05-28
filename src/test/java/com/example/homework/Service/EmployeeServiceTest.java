package com.example.homework.Service;

import com.example.homework.Employee;
import com.example.homework.Exceptions.EmployeeAlreadyAddedException;
import com.example.homework.Exceptions.EmployeeNotFoundException;
import com.example.homework.Exceptions.EmployeeStorageIsFullException;
import com.example.homework.Exceptions.InvalidInputException;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {
    EmployeeService service = new EmployeeService();

    @Test
    void add() {
        var expected = new Employee("Andrey", "Gusev", 103266, 1);
        var actual = service.addEmployee(new Employee("Andrey", "Gusev", 103266, 1));
        assertEquals(expected, actual);
    }

    @Test
    void testAdded() {
        service.addEmployee(new Employee("Andrey", "Gusev", 103266, 1));
        assertThrows(EmployeeAlreadyAddedException.class,
                () -> service.addEmployee(new Employee("Andrey", "Gusev", 103266, 1)));
    }

    @Test
    void testStorageIsFull() {
        for (char i = 'A'; i < 'K'; i++) {
            service.addEmployee(new Employee("A" + i, "L" + i, i * 1000, i % 5));
        }
        assertThrows(EmployeeStorageIsFullException.class,
                () -> service.addEmployee(new Employee("Andrey", "Gusev", 103266, 1)));
    }

    @Test
    void testNotValid() {
        assertThrows(InvalidInputException.class,
                () -> service.addEmployee(new Employee("Andrey5", "Gusev", 103266, 1)));
        assertThrows(InvalidInputException.class,
                () -> service.addEmployee(new Employee("Andrey", "Gusev3", 103266, 1)));
    }

    @Test
    void testGetAll() {
        service.addEmployee(new Employee("Andrey", "Gusev", 103266, 1));
        service.addEmployee(new Employee("Andre", "Gev", 123266, 2));
        Collection<Employee> employees = service.getEmployees();
        assertEquals(2, employees.size());
    }

    @Test
    void testGetAllIsEmpty() {
        assertEquals(0, service.getEmployees().size());
    }

    @Test
    void testFoundEmployee() {
        var expected = new Employee("Andrey", "Gusev", 103266, 1);
        service.addEmployee(new Employee("andrey", "gusev", 103266, 1));
        assertEquals(expected, service.employeeFind(new Employee("Andrey", "gusev", 103266, 1)));
        assertEquals(expected, service.employeeFind(new Employee("andrey", "Gusev", 103266, 1)));
        assertThrows(EmployeeNotFoundException.class, () -> service.employeeFind(new Employee("And", "Gev", 10346, 2)));
    }

    @Test
    void testRemoveEmployee() {
        var expected = new Employee("Andrey", "Gusev", 103266, 1);
        service.addEmployee(new Employee("andrey", "gusev", 103266, 1));
        assertEquals(1, service.getEmployees().size());
        assertEquals(expected, service.getEmployees().iterator().next());
        service.employeeRemove(new Employee("Andrey", "Gusev", 103266, 1));
        assertEquals(0, service.getEmployees().size());
        assertThrows(EmployeeNotFoundException.class, () -> service.employeeRemove(new Employee("And", "Gev", 10346, 2)));
    }

}