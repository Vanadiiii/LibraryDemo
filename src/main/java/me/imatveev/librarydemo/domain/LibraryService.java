package me.imatveev.librarydemo.domain;

import me.imatveev.librarydemo.domain.entity.Book;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface LibraryService {
    Optional<Book> findById(UUID id);

    Optional<Book> findByTitle(String title);

    Collection<Book> findAllByAuthorName(String authorName);

    Book changeBookInfo(UUID bookId, Book changedBook);

    Book saveNewBook(Book book);
}
