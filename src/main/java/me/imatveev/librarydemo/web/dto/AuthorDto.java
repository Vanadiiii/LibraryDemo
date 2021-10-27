package me.imatveev.librarydemo.web.dto;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder(toBuilder = true)
public class AuthorDto {
    UUID id;
    @NotNull
    String fullName;
    String biography;
}
