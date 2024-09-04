package io.infinitydown.library.command;

import io.infinitydown.library.persistence.Book;
import io.infinitydown.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Converts a BookDTO to a Book entity.
 */
@RequiredArgsConstructor
@Component
public class BookDTOToBook {

    private final BookService bookService;

    /**
     * Converts a BookDTO to a Book entity. If the BookDTO has an ID, it retrieves
     * the existing Book from the BookService; otherwise, it creates a new Book instance.
     *
     * @param bookDto the BookDTO to convert
     * @return the converted Book entity
     */
    public Book convert(BookDTO bookDto) {
        Book book = (bookDto.getId() != null ? bookService.getBookById(bookDto.getId()) : new Book());

        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        book.setPublishedDate(bookDto.getPublishedDate());
        book.setPrice(bookDto.getPrice());
        book.setIsbn(bookDto.getIsbn());

        return book;
    }
}
