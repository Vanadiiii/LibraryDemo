package me.imatveev.librarydemo.web.mapper;

import me.imatveev.librarydemo.domain.entity.Book;
import me.imatveev.librarydemo.web.dto.BookDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.function.Function;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        uses = AuthorMapper.class)
public interface BookMapper extends Function<Book, BookDto> {
    @Override
    BookDto apply(Book book);

    Book apply(BookDto bookDto);
}
