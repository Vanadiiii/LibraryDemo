package me.imatveev.librarydemo.web.dto;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Value;
import me.imatveev.librarydemo.domain.entity.Genre;

import java.util.UUID;

@Value
@Builder(toBuilder = true)
public class BookDto {
    UUID id;
    @NotNull
    String title;
    @NotNull
    String description;
    @NotNull
    Genre genre;
    @NotNull
    AuthorDto author;
}
