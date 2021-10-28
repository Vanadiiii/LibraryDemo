package me.imatveev.librarydemo.web.advice;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.PropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class LibraryControllerAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PropertyValueException.class)
    public ErrorInfo handleValidationException(Exception ex) {
        return new ErrorInfo(ex.getMessage());
    }

    @Data
    @AllArgsConstructor
    private static class ErrorInfo {
        private String errorMessage;
    }
}
