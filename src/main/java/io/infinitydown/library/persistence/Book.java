package io.infinitydown.library.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.*;
import jakarta.persistence.Entity;
import java.time.LocalDate;

/**
 * Entity representing a book in the library system.
 * This class extends the Abstract class to inherit common fields
 * and provides additional fields specific to a book.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book extends Abstract{

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "isbn", unique = true, nullable = false)
    private String isbn;

    @Column(name = "publishedDate", nullable = false)
    private LocalDate publishedDate;

    @Column(name = "price")
    private Double price;

    @Column(name = "description", length = 1000)
    private String description;
}
