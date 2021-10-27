package me.imatveev.librarydemo.web;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.imatveev.librarydemo.domain.LibraryService;
import me.imatveev.librarydemo.web.dto.BookDto;
import me.imatveev.librarydemo.web.exception.BookNotFoundException;
import me.imatveev.librarydemo.web.mapper.BookMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/library/v1/")
@OpenAPIDefinition(
        info = @Info(
                title = "Library API",
                description = "simple API for simple Library",
                contact = @Contact(name = "Ivan Matveev", email = "vanadiiii42@gmail.com"),
                version = "1.0"
        )
)
public class LibraryController {
    private final LibraryService libraryService;
    private final BookMapper bookMapper;

    @Operation(summary = "get book by special UUID")
    @GetMapping("/books/{id}")
    public BookDto getBookById(@PathVariable UUID id) {
        return libraryService.findById(id)
                .map(bookMapper)
                .orElseThrow(() -> BookNotFoundException.ofId(id));
    }

    @Operation(summary = "get book by it's title")
    @GetMapping("/books")
    public BookDto getBookByName(@RequestParam String title) {
        return libraryService.findByTitle(title)
                .map(bookMapper)
                .orElseThrow(() -> BookNotFoundException.ofName(title));
    }

    @Operation(summary = "get all book by author's name")
    @GetMapping("/authors/books")
    public Collection<BookDto> getAllBooksByAuthorName(@RequestParam String authorName) {
        return libraryService.findAllByAuthorName(authorName)
                .stream()
                .map(bookMapper)
                .collect(Collectors.toList());
    }

    @Operation(summary = "change book's info")
    @PatchMapping("/books/{id}")
    public BookDto changeBook(@PathVariable UUID id, @RequestBody BookDto bookDto) {
        return Optional.ofNullable(bookDto)
                .map(bookMapper::apply)
                .map(book -> libraryService.changeBookInfo(id, book))
                .map(bookMapper)
                .orElseThrow(() -> BookNotFoundException.ofId(id));
    }

    @Operation(summary = "save new book in library")
    @PostMapping("/books")
    public BookDto saveBook(@RequestBody BookDto bookDto) {
        return Optional.of(bookDto)
                .map(bookMapper::apply)
                .map(libraryService::saveNewBook)
                .map(bookMapper)
                .orElseThrow();
    }
}
