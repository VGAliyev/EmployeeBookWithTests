package ru.skypro.course2.aliyev.EmployeeBookWithTests.service.Impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import ru.skypro.course2.aliyev.EmployeeBookWithTests.exception.EmployeeAlreadyAddedException;
import ru.skypro.course2.aliyev.EmployeeBookWithTests.exception.EmployeeNotFoundException;
import ru.skypro.course2.aliyev.EmployeeBookWithTests.exception.EmployeeNotValidateException;
import ru.skypro.course2.aliyev.EmployeeBookWithTests.model.Employee;
import ru.skypro.course2.aliyev.EmployeeBookWithTests.service.EmployeeService;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees = new HashMap<>();

    @Override
    public Employee add(String firstName, String lastName, float salary, int departmentId) {
        validate(firstName, lastName);
        String fullName = getFullName(firstName, lastName);
        if (employees.containsKey(fullName)) {
            throw new EmployeeAlreadyAddedException("Employee " + fullName + " already exists!");
        }
        Employee employee = new Employee(firstName, lastName, salary, departmentId);
        employees.put(fullName, employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        validate(firstName, lastName);
        String fullName = getFullName(firstName, lastName);
        if (!employees.containsKey(fullName)) {
            throw new EmployeeNotFoundException("Employee " + fullName + " not found!");
        }
        Employee employee = employees.get(fullName);
        employees.remove(fullName);
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        validate(firstName, lastName);
        String fullName = getFullName(firstName, lastName);
        if (!employees.containsKey(fullName)) {
            throw new EmployeeNotFoundException("Employee " + fullName + " not found!");
        }
        return employees.get(fullName);
    }

    @Override
    public Collection<Employee> getEmployees() {
        return Collections.unmodifiableCollection(employees.values()); // Unmodifiable client copy
    }

    private static String getFullName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

    private void validate(String firstName, String lastName) {
        if (!(StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastName))) {
            throw new EmployeeNotValidateException("Not valid employee firstname or lastname!");
        }
    }
}
