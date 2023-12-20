package ru.skypro.course2.aliyev.EmployeeBookWithTests.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
