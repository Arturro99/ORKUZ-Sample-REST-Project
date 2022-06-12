package pl.edu.pw.orkuz.orkuz_project.service;

import java.util.List;
import pl.edu.pw.orkuz.orkuz_project.endpoint.BookDto;

public interface BooksService {

    List<BookDto> getAll();

    BookDto get(String isbn);

    BookDto create(BookDto book);

    void remove(String isbn);

    BookDto update(String isbn, BookDto book);
}
