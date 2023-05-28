package com.example.homework.Service;

import com.example.homework.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class DepartmentServiceTest {
    @Mock
    EmployeeService employeeServiceMock;
    DepartmentService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        service = new DepartmentService(employeeServiceMock);
    }

    @Test
    void maxSalary() {
        List<Employee> employees = List.of(
                new Employee("Andrey", "Gusev", 210252, 3),
                new Employee("Andy", "Guv", 240252, 3));
        when(employeeServiceMock.getEmployees()).thenReturn(employees);
        assertNull(service.maxSalary(5));
        assertEquals(employees.get(1), service.maxSalary(3));
    }

    @Test
    void minSalary() {
        List<Employee> employees = List.of(
                new Employee("Andrey", "Gusev", 210252, 3),
                new Employee("Andy", "Guv", 240252, 3));
        when(employeeServiceMock.getEmployees()).thenReturn(employees);
        assertNull(service.minSalary(5));
        assertEquals(employees.get(0), service.minSalary(3));
    }

    @Test
    void departmentAll() {
        List<Employee> employees = List.of(
                new Employee("Andrey", "Gusev", 210252, 3),
                new Employee("Andy", "Guv", 240252, 3));
        when(employeeServiceMock.getEmployees()).thenReturn(employees);
        var actual = service.departmentAll(3);
        assertEquals(2, actual.size());
        var expected = List.of(
                new Employee("Andrey", "Gusev", 210252, 3),
                new Employee("Andy", "Guv", 240252, 3));
        assertEquals(expected, actual);
    }

    @Test
    void all() {
        List<Employee> employees = List.of(
                new Employee("Andre", "Gus", 213452, 1),
                new Employee("Andrey", "Gusev", 210252, 3),
                new Employee("Andy", "Guv", 240252, 3));
        when(employeeServiceMock.getEmployees()).thenReturn(employees);
        Map<Integer, List<Employee>> actual = service.all();
        assertEquals(2, actual.size());
        assertEquals(1, actual.get(1).size());
        assertEquals(2, actual.get(3).size());
    }
}