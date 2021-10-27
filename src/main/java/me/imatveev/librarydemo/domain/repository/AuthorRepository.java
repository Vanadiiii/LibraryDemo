package me.imatveev.librarydemo.domain.repository;

import me.imatveev.librarydemo.domain.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> {
    Optional<Author> findAuthorByFullName(String name);

    boolean existsById(UUID id);
}
