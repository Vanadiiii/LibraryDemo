package me.imatveev.librarydemo.service.patcher;

import me.imatveev.librarydemo.domain.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.function.BinaryOperator;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface BookPatcher extends BinaryOperator<Book> {

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "author", ignore = true)
    Book apply(@MappingTarget Book source, Book changed);
}
