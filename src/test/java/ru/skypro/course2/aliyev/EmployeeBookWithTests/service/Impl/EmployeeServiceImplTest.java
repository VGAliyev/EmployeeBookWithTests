package ru.skypro.course2.aliyev.EmployeeBookWithTests.service.Impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.skypro.course2.aliyev.EmployeeBookWithTests.exception.EmployeeAlreadyAddedException;
import ru.skypro.course2.aliyev.EmployeeBookWithTests.exception.EmployeeNotFoundException;
import ru.skypro.course2.aliyev.EmployeeBookWithTests.exception.EmployeeNotValidateException;
import ru.skypro.course2.aliyev.EmployeeBookWithTests.model.Employee;
import ru.skypro.course2.aliyev.EmployeeBookWithTests.service.EmployeeService;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static ru.skypro.course2.aliyev.EmployeeBookWithTests.constants.TestConstants.*;

class EmployeeServiceImplTest {
    private final EmployeeService employeeService = new EmployeeServiceImpl();

    @BeforeEach
    void employeesInit() {
        employeeService.add("Ivan", "Fedorov", 100_000.0f, 1);
        employeeService.add("Petr", "Ivanov", 120_000.0f, 1);
        employeeService.add("Maria", "Petrova", 110_000.0f, 3);
    }

    @Test
    void add() {
        Employee result1 = employeeService.add("Alexandr", "Kirshman", 90_000.0f, 2);
        Employee result2 = employeeService.add("Mary", "Ivanovich", 120_350.0f, 4);
        assertEquals(result1, EMPLOYEE1);
        assertEquals(result2, EMPLOYEE2);
    }

    @Test
    void remove() {
        Employee result = employeeService.remove("Ivan", "Fedorov");
        assertEquals(result, EMPLOYEE3);
    }

    @Test
    void find() {
        Employee result = employeeService.find("Ivan", "Fedorov");
        assertEquals(result, EMPLOYEE3);
    }

    @Test
    void getEmployees() {
        Map<String, Employee> result = employeeService.getEmployees();
        assertEquals(result, EMPLOYEES);
    }

    @Test
    void addEmployeeAlreadyAddedException() {
        assertThrows(EmployeeAlreadyAddedException.class, () -> employeeService.add("Ivan", "Fedorov", 100_000.0f, 1));
    }

    @Test
    void removeEmployeeNotFoundException() {
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.remove("John", "Smith"));
    }

    @Test
    void findEmployeeNotFoundException() {
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.find("John", "Smith"));
    }

    @Test
    void employeeNotValidateException() {
        assertThrows(EmployeeNotValidateException.class, () -> employeeService.add("John1", "Smith", 200_000.0f, 5));
    }
}