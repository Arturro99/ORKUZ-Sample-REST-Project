package pl.edu.pw.orkuz.orkuz_project.endpoint;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

import java.net.URI;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pw.orkuz.orkuz_project.service.BooksService;

@RestController
@AllArgsConstructor
@Transactional(propagation = REQUIRES_NEW)
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class BooksController {

    BooksService booksService;

    @GetMapping("/get/{isbn}")
    public ResponseEntity<BookDto> get(@PathVariable String isbn) {
        return ResponseEntity.ok(booksService.get(isbn));
    }

    @GetMapping("/get")
    public ResponseEntity<List<BookDto>> getAll() {
        return ResponseEntity.ok(booksService.getAll());
    }

    @PostMapping("/create")
    public ResponseEntity<BookDto> create(@RequestBody BookDto bookDto) {
        URI location = URI.create(String.format("/get/%s", bookDto.getIsbn()));
        return ResponseEntity.created(location)
            .body(booksService.create(bookDto));
    }

    @DeleteMapping("/remove/{isbn}")
    public ResponseEntity<Void> remove(@PathVariable String isbn) {
        booksService.remove(isbn);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{isbn}")
    public ResponseEntity<BookDto> update(@PathVariable String isbn, @RequestBody BookDto bookDto) {
        return ResponseEntity.ok(booksService.update(isbn, bookDto));
    }
}
