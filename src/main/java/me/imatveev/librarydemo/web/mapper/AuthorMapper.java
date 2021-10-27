package me.imatveev.librarydemo.web.mapper;

import me.imatveev.librarydemo.domain.entity.Author;
import me.imatveev.librarydemo.web.dto.AuthorDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.function.Function;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface AuthorMapper extends Function<Author, AuthorDto> {
    @Override
    AuthorDto apply(Author author);

    @Mapping(target = "books", ignore = true)
    Author apply(AuthorDto authorDto);
}
