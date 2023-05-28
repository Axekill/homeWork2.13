package com.example.homework.Controller;

import com.example.homework.Employee;
import com.example.homework.Service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
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

    @GetMapping("{id}/max-salary")
    public Employee maxSalary(@PathVariable int id) {
        return departmentService.maxSalary(id);

    }

    @GetMapping("{id}/mix-salary")
    public Employee minSalary(@PathVariable int id) {
        return departmentService.minSalary(id);

    }

    @GetMapping("{id}/allEmployeeOfDepartment")
    public Collection<Employee> departmentAll(@PathVariable int id) {
        return departmentService.departmentAll(id);
    }
    @GetMapping("/all")
    public Map<Integer, List<Employee>> all() {
        return  departmentService.all();
    }
}
