package pl.edu.pw.orkuz.orkuz_project.service.mapper;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import pl.edu.pw.orkuz.orkuz_project.endpoint.BookDto;
import pl.edu.pw.orkuz.orkuz_project.orm.BookEntity;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = IGNORE)
public interface BookMapper {

    BookEntity toEntityModel(BookDto book);

    BookEntity toEntityModel(@MappingTarget BookEntity bookEntity, BookDto bookDto);

    BookDto toDtoModel(BookEntity book);
}
