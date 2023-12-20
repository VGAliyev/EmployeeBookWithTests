package ru.skypro.course2.aliyev.EmployeeBookWithTests.service;

import ru.skypro.course2.aliyev.EmployeeBookWithTests.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String lastName, float salary, int departmentId);

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);

    Collection<Employee> getEmployees();
}
