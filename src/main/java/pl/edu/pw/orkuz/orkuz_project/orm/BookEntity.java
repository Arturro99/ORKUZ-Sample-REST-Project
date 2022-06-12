package pl.edu.pw.orkuz.orkuz_project.orm;

import static lombok.AccessLevel.PRIVATE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@FieldDefaults(level = PRIVATE)
@Table(name = "books")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    Long id;

    @Column(nullable = false)
    @Max(13)
    @NotBlank
    String isbn;

    @Column(nullable = false)
    @Max(128)
    @NotBlank
    String title;

    @Column
    @Max(218)
    String author;

    @Column(name = "page_number", nullable = false)
    @NotBlank
    int pageNumber;
}
