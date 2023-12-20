package ru.skypro.course2.aliyev.EmployeeBookWithTests.service.Impl;

import org.springframework.stereotype.Service;
import ru.skypro.course2.aliyev.EmployeeBookWithTests.exception.EmployeeNotFoundException;
import ru.skypro.course2.aliyev.EmployeeBookWithTests.model.Employee;
import ru.skypro.course2.aliyev.EmployeeBookWithTests.service.DepartmentService;
import ru.skypro.course2.aliyev.EmployeeBookWithTests.service.EmployeeService;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public List<Employee> getAllEmployeeByDepartment(int departmentId) {
        return employeeService.getEmployees()
                .stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public float getSumSalary(int departmentId) {
        return (float) employeeService.getEmployees()
                .stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    @Override
    public float getMaxSalary(int departmentId) {
        return employeeService.getEmployees()
                .stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with max salary not found!"))
                .getSalary();
    }

    @Override
    public float getMinSalary(int departmentId) {
        return employeeService.getEmployees()
                .stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with min salary not found!"))
                .getSalary();
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployee() {
        return employeeService.getEmployees()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
