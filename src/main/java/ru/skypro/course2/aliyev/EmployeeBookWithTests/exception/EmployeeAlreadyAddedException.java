package ru.skypro.course2.aliyev.EmployeeBookWithTests.exception;

public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException(String message) {
        super(message);
    }
}
