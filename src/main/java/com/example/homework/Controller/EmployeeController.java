package com.example.homework.Controller;

import com.example.homework.Employee;
import com.example.homework.Exceptions.EmployeeAlreadyAddedException;
import com.example.homework.Exceptions.EmployeeNotFoundException;
import com.example.homework.Exceptions.EmployeeStorageIsFullException;
import com.example.homework.Service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {


    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName,
                              @RequestParam int salary,
                              @RequestParam int departmentId) {
        Employee employee = new Employee(firstName, lastName, salary, departmentId);
        try {
            employeeService.addEmployee(employee);
            return "Сотрудник добавлен: " + employee;
        } catch (EmployeeStorageIsFullException e) {
            return "Список переполнен";
        } catch (EmployeeAlreadyAddedException e) {
            return "такой сотрудник уже существует: " + employee;
        }

    }


    @GetMapping("/remove")
    public String employeeRemove(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName,
                                 @RequestParam int salary,
                                 @RequestParam int departmentId) {
        Employee employee = new Employee(firstName, lastName, salary, departmentId);

        try {
            employeeService.employeeRemove(employee);
            return "сотрудник удалён: " + employee;
        } catch (EmployeeNotFoundException e) {
            return "данного сотрудника не существует";
        }
    }

    @GetMapping("/find")
    public String employeeFind(@RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName,
                               @RequestParam int salary,
                               @RequestParam int departmentId) {
        Employee employee = new Employee(firstName, lastName, salary, departmentId);
        try {
            return "Сотрудник найден: " + employeeService.employeeFind(employee);

        } catch (EmployeeNotFoundException e) {
            return "такого сотрудника не существует";
        }
    }

    @GetMapping("/list")
    public Collection<Employee> list() {
        return employeeService.getEmployees();

    }


}
