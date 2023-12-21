package ru.skypro.course2.aliyev.EmployeeBookWithTests.service;

import ru.skypro.course2.aliyev.EmployeeBookWithTests.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    List<Employee> getAllEmployeeByDepartment(int departmentId);
    float getSumSalary(int departmentId);
    float getMaxSalary(int departmentId);
    float getMinSalary(int departmentId);
    Map<Integer, List<Employee>> getAllEmployee();
}
