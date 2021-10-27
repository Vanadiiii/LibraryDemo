package me.imatveev.librarydemo.web.exception;

import java.util.UUID;

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
