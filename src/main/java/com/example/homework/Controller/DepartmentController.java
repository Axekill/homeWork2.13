package com.example.homework.Controller;

import com.example.homework.Employee;
import com.example.homework.Service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee maxSalary(@RequestParam int departmentId) {
        return departmentService.maxSalary(departmentId);

    }

    @GetMapping("/mix-salary")
    public Employee minSalary(@RequestParam int departmentId) {
        return departmentService.minSalary(departmentId);

    }

    @GetMapping("/allEmployeeOfDepartment")
    public Stream<Employee> departmentAll(@RequestParam int departmentId) {
        return departmentService.departmentAll(departmentId);
    }
    @GetMapping("/all")
    public Map<Integer, List<Employee>> all() {
        return  departmentService.all();
    }
}
