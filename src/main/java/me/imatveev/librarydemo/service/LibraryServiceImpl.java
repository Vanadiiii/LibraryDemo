package me.imatveev.librarydemo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.imatveev.librarydemo.domain.LibraryService;
import me.imatveev.librarydemo.domain.entity.Book;
import me.imatveev.librarydemo.domain.repository.BookRepository;
import me.imatveev.librarydemo.service.patcher.BookPatcher;
import me.imatveev.librarydemo.web.exception.BookAlreadyExistsException;
import me.imatveev.librarydemo.web.exception.BookNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class LibraryServiceImpl implements LibraryService {
    private final BookRepository bookRepository;
    private final BookPatcher bookPatcher;


    @Override
    public Optional<Book> findById(UUID id) {
        log.info("try to find book by id - {}", id);

        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> findByTitle(String title) {
        log.info("try to find book by title - {}", title);

        return bookRepository.findBookByTitle(title);
    }

    @Override
    public Collection<Book> findAllByAuthorName(String authorName) {
        log.info("try to find book by authorName - {}", authorName);

        return bookRepository.findAllByAuthorFullName(authorName);
    }

    @Override
    public Book changeBookInfo(UUID id, Book changedBook) {
        log.info("try to find book by id - {}", id);

        return bookRepository.findById(id)
                .map(sourceBook -> bookPatcher.apply(sourceBook, changedBook))
                .orElseThrow(() -> BookNotFoundException.ofId(id));
    }

    @Override
    public Book saveNewBook(Book book) {
        if (bookRepository.existsByTitle(book.getTitle())) {
            throw BookAlreadyExistsException.ofTitle(book.getTitle());
        }

        log.info("try to save new book - {}", book);
        return bookRepository.save(book);
    }
}
