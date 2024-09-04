package io.infinitydown.library.command;

import io.infinitydown.library.persistence.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.*;
import java.time.LocalDate;

/**
 * Data Transfer Object for Book entity.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    /**
     * Converts a Book entity to a BookDTO.
     *
     * @param book the Book entity to convert
     * @return the converted BookDTO
     */
    public BookDTO convertBookToBookDTO(Book book){
        BookDTO bookDto = new BookDTO();
        bookDto.setId(book.getId());
        bookDto.setIsbn(book.getIsbn());
        bookDto.setAuthor(book.getAuthor());
        bookDto.setPrice(book.getPrice());
        bookDto.setPublishedDate(book.getPublishedDate());
        bookDto.setTitle(book.getTitle());

        return bookDto;
    }

    private Long id;

    @NotNull(message = "Title is mandatory")
    @NotBlank(message = "Title is mandatory")
    @Size(min = 2, max = 64, message = "Title must be between 2 and 64 characters")
    private String title;

    @NotNull(message = "Author is mandatory")
    @NotBlank(message = "Author is mandatory")
    @Size(min = 3, max = 64, message = "Author must be between 3 and 64 characters")
    private String author;

    @NotBlank(message = "ISBN is mandatory")
    @Size(min = 9, max = 15, message = "ISBN must be between 9 and 15 characters")
    private String isbn;

    @PastOrPresent(message = "Published date must be in the past or present")
    private LocalDate publishedDate;

    @DecimalMin(value = "0.01", message = "Price must be greater than 0")
    private Double price;

    @Size(max = 1000, message = "Description cannot exceed 1000 characters")
    private String description;

    /**
     * Gets the title of the book.
     *
     * @return the title
     */
    public @NotNull(message = "Title is mandatory") @NotBlank(message = "Title is mandatory") @Size(min = 2, max = 64) String getTitle() {
        return title;
    }

    /**
     * Sets the title of the book.
     *
     * @param title the title to set
     */
    public void setTitle(@NotNull(message = "Title is mandatory") @NotBlank(message = "Title is mandatory") @Size(min = 2, max = 64) String title) {
        this.title = title;
    }

    /**
     * Gets the author of the book.
     *
     * @return the author
     */
    public @NotNull(message = "Author is mandatory") @NotBlank(message = "Author is mandatory") @Size(min = 3, max = 64) String getAuthor() {
        return author;
    }

    /**
     * Sets the author of the book.
     *
     * @param author the author to set
     */
    public void setAuthor(@NotNull(message = "Author is mandatory") @NotBlank(message = "Author is mandatory") @Size(min = 3, max = 64) String author) {
        this.author = author;
    }

    /**
     * Gets the ISBN of the book.
     *
     * @return the ISBN
     */
    public @NotBlank(message = "Isbn is mandatory") @Size(min = 9, max = 15) String getIsbn() {
        return isbn;
    }

    /**
     * Sets the ISBN of the book.
     *
     * @param isbn the ISBN to set
     */
    public void setIsbn(@NotBlank(message = "Isbn is mandatory") @Size(min = 9, max = 15) String isbn) {
        this.isbn = isbn;
    }
}
