package io.infinitydown.library.command;

import io.infinitydown.library.persistence.Book;
import org.springframework.stereotype.Component;

/**
 * Converts a Book entity to a BookDTO.
 */
@Component
public class BookToBookDTO {

    /**
     * Converts a Book entity to a BookDTO.
     *
     * @param book the Book entity to convert
     * @return the converted BookDTO
     */
    public BookDTO convert(Book book) {
        BookDTO bookDto = new BookDTO();
        bookDto.setId(book.getId());
        bookDto.setIsbn(book.getIsbn());
        bookDto.setAuthor(book.getAuthor());
        bookDto.setPrice(book.getPrice());
        bookDto.setPublishedDate(book.getPublishedDate());
        bookDto.setTitle(book.getTitle());

        return bookDto;
    }

}
