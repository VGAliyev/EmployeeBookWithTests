package ru.skypro.course2.aliyev.EmployeeBookWithTests.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.course2.aliyev.EmployeeBookWithTests.model.Employee;
import ru.skypro.course2.aliyev.EmployeeBookWithTests.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @RequestMapping("/{id}/employees")
    public List<Employee> getAllEmployeeByDepartment(@PathVariable int id) {
        return departmentService.getAllEmployeeByDepartment(id);
    }

    @RequestMapping("/{id}/salary/sum")
    public float getSumSalary(@PathVariable int id) {
        return departmentService.getSumSalary(id);
    }

    @RequestMapping("/{id}/salary/max")
    public float getMaxSalary(@PathVariable int id) {
        return departmentService.getMaxSalary(id);
    }

    @RequestMapping("/{id}/salary/min")
    public float getMinSalary(@PathVariable int id) {
        return departmentService.getMinSalary(id);
    }

    @RequestMapping("/employees")
    public Map<Integer, List<Employee>> getAllEmployee() {
        return departmentService.getAllEmployee();
    }
}
