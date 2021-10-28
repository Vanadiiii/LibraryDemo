package me.imatveev.librarydemo.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "that book wasn't found")
public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String message) {
        super(message);
    }

    public static BookNotFoundException ofId(UUID id) {
        return new BookNotFoundException("No such book with id - " + id);
    }

    public static BookNotFoundException ofName(String name) {
        return new BookNotFoundException("No such book with name - " + name);
    }
}
