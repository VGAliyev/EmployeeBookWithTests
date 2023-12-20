package ru.skypro.course2.aliyev.EmployeeBookWithTests.constants;

import ru.skypro.course2.aliyev.EmployeeBookWithTests.model.Employee;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TestConstants {
    public static final Employee EMPLOYEE1 = new Employee("Alexandr", "Kirshman", 90_000.0f, 2);
    public static final Employee EMPLOYEE2 = new Employee("Mary", "Ivanovich", 120_350.0f, 4);
    public static final Employee EMPLOYEE3 = new Employee("Ivan", "Fedorov", 100_000.0f, 1);
    public static final Map<String, Employee> EMPLOYEES = new HashMap<String, Employee>(){{
       put("Ivan Fedorov", new Employee("Ivan", "Fedorov", 100_000.0f, 1));
       put("Petr Ivanov", new Employee("Petr", "Ivanov", 120_000.0f, 1));
       put("Maria Petrova", new Employee("Maria", "Petrova", 110_000.0f, 3));
    }};
}
