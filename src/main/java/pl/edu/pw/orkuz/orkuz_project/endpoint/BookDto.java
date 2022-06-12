package pl.edu.pw.orkuz.orkuz_project.endpoint;

import static lombok.AccessLevel.PRIVATE;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Valid
@Getter
@Setter
@FieldDefaults(level = PRIVATE)
public class BookDto {

    @Max(13)
    @NotBlank
    String isbn;

    @Max(128)
    @NotBlank
    String title;

    @Max(218)
    String author;

    @NotBlank
    int pageNumber;
}
