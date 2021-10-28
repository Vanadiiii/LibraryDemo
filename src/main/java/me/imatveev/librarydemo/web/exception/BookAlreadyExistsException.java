package me.imatveev.librarydemo.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "that book already exists")
public class BookAlreadyExistsException extends RuntimeException {
    public BookAlreadyExistsException(String message) {
        super(message);
    }

    public static BookAlreadyExistsException ofTitle(String name) {
        return new BookAlreadyExistsException("Book with this title - " + name + " already exists");
    }
}
