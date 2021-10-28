package me.imatveev.librarydemo.domain.repository;

import me.imatveev.librarydemo.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
    Optional<Book> findBookByTitle(String title);

    List<Book> findAllByAuthorFullName(String authorName);

    boolean existsByTitle(String title);
}
