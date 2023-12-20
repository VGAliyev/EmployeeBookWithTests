package ru.skypro.course2.aliyev.EmployeeBookWithTests.service.Impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro.course2.aliyev.EmployeeBookWithTests.exception.EmployeeNotFoundException;
import ru.skypro.course2.aliyev.EmployeeBookWithTests.service.EmployeeService;

import static java.util.Collections.emptyMap;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static ru.skypro.course2.aliyev.EmployeeBookWithTests.constants.TestConstants.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @Test
    void getAllEmployeeByDepartment() {
        when(employeeService.getEmployees()).thenReturn(EMPLOYEES);
        assertEquals(EMPLOYEES_BY_DEPARTMENT_ID_1, departmentService.getAllEmployeeByDepartment(DEPARTMENT_ID));
    }

    @Test
    void getSumSalary() {
        when(employeeService.getEmployees()).thenReturn(EMPLOYEES);
        assertEquals(SUM_BY_DEPARTMENT_ID_1, departmentService.getSumSalary(DEPARTMENT_ID));
    }

    @Test
    void getMaxSalary() {
        when(employeeService.getEmployees()).thenReturn(EMPLOYEES);
        assertEquals(MAX_BY_DEPARTMENT_ID_1, departmentService.getMaxSalary(DEPARTMENT_ID));
    }

    @Test
    void getMinSalary() {
        when(employeeService.getEmployees()).thenReturn(EMPLOYEES);
        assertEquals(MIN_BY_DEPARTMENT_ID_1, departmentService.getMinSalary(DEPARTMENT_ID));
    }

    @Test
    void getAllEmployee() {
        when(employeeService.getEmployees()).thenReturn(EMPLOYEES);
        assertEquals(EMPLOYEE_BY_ALL_DEPARTMENT, departmentService.getAllEmployee());
    }

    @Test
    void getMaxSalaryEmployeeNotFoundException() {
        when(employeeService.getEmployees()).thenReturn(emptyMap());
        assertThrows(EmployeeNotFoundException.class, () -> departmentService.getMaxSalary(DEPARTMENT_ID));
    }

    @Test
    void getMinSalaryEmployeeNotFoundException() {
        when(employeeService.getEmployees()).thenReturn(emptyMap());
        assertThrows(EmployeeNotFoundException.class, () -> departmentService.getMinSalary(DEPARTMENT_ID));
    }
}