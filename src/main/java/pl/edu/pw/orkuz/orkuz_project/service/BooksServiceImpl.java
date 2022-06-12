package pl.edu.pw.orkuz.orkuz_project.service;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.transaction.annotation.Propagation.MANDATORY;

import java.util.List;
import java.util.stream.Collectors;
import lombok.experimental.FieldDefaults;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.pw.orkuz.orkuz_project.endpoint.BookDto;
import pl.edu.pw.orkuz.orkuz_project.exception.BookingException;
import pl.edu.pw.orkuz.orkuz_project.orm.BookEntity;
import pl.edu.pw.orkuz.orkuz_project.orm.BooksRepository;
import pl.edu.pw.orkuz.orkuz_project.service.mapper.BookMapper;

@Service
@Transactional(propagation = MANDATORY)
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class BooksServiceImpl implements BooksService {

    BooksRepository repository;

    BookMapper mapper;

    @Autowired
    public BooksServiceImpl(BooksRepository repository) {
        this.repository = repository;
        this.mapper = Mappers.getMapper(BookMapper.class);
    }

    @Override
    public List<BookDto> getAll() {
        return repository.findAll().stream()
            .map(mapper::toDtoModel)
            .collect(Collectors.toList());
    }

    @Override
    public BookDto get(String isbn) {
        return mapper.toDtoModel(
            repository.findByIsbn(isbn).orElseThrow(BookingException::notFoundException));
    }

    @Override
    public BookDto create(BookDto book) {
        if (repository.findByIsbn(book.getIsbn()).isPresent()) {
            throw BookingException.conflictException();
        }
        BookEntity bookEntity = mapper.toEntityModel(book);
        BookEntity saved = repository.save(bookEntity);
        return mapper.toDtoModel(saved);
    }

    @Override
    public void remove(String isbn) {
        BookEntity bookEntity = repository.findByIsbn(isbn)
            .orElseThrow(BookingException::notFoundException);

        repository.delete(bookEntity);
    }

    @Override
    public BookDto update(String isbn, BookDto book) {
        BookEntity bookEntity = repository.findByIsbn(isbn)
            .orElseThrow(BookingException::notFoundException);

        BookEntity updated = mapper.toEntityModel(bookEntity, book);
        repository.save(updated);
        return mapper.toDtoModel(updated);
    }
}
