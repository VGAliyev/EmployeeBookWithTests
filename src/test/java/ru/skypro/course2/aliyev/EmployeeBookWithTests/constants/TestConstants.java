package ru.skypro.course2.aliyev.EmployeeBookWithTests.constants;

import ru.skypro.course2.aliyev.EmployeeBookWithTests.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class TestConstants {
    public static final Employee EMPLOYEE1 = new Employee("Alexandr", "Kirshman", 90_000.0f, 2);
    public static final Employee EMPLOYEE2 = new Employee("Mary", "Ivanovich", 120_350.0f, 4);
    public static final Employee EMPLOYEE3 = new Employee("Ivan", "Fedorov", 100_000.0f, 1);
    public static final Map<String, Employee> EMPLOYEES = new HashMap<>(){{
       put("Ivan Fedorov", new Employee("Ivan", "Fedorov", 100_000.0f, 1));
       put("Petr Ivanov", new Employee("Petr", "Ivanov", 120_000.0f, 1));
       put("Maria Petrova", new Employee("Maria", "Petrova", 110_000.0f, 3));
    }};
    public static final int DEPARTMENT_ID = 1;
    public static final List<Employee> EMPLOYEES_BY_DEPARTMENT_ID_1 = EMPLOYEES.values()
            .stream()
            .filter(employee -> employee.getDepartment() == DEPARTMENT_ID)
            .collect(Collectors.toList());
    public static final float SUM_BY_DEPARTMENT_ID_1 = (float) EMPLOYEES.values()
            .stream()
            .filter(employee -> employee.getDepartment() == DEPARTMENT_ID)
            .mapToDouble(Employee::getSalary)
            .sum();
    public static final float MAX_BY_DEPARTMENT_ID_1 = EMPLOYEES.values()
            .stream()
            .filter(employee -> employee.getDepartment() == DEPARTMENT_ID)
            .max(Comparator.comparingDouble(Employee::getSalary))
            .orElseThrow()
            .getSalary();
    public static final float MIN_BY_DEPARTMENT_ID_1 = EMPLOYEES.values()
            .stream()
            .filter(employee -> employee.getDepartment() == DEPARTMENT_ID)
            .min(Comparator.comparingDouble(Employee::getSalary))
            .orElseThrow()
            .getSalary();
    public static final Map<Integer, List<Employee>> EMPLOYEE_BY_ALL_DEPARTMENT = EMPLOYEES.values()
            .stream()
            .collect(Collectors.groupingBy(Employee::getDepartment));
}
