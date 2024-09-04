package io.infinitydown.library.service;

import io.infinitydown.library.persistence.Book;
import java.util.List;

/**
 * Service interface for managing books in the library.
 */
public interface BookService {

    /**
     * Retrieves all books in the library.
     *
     * @return a list of all books
     */
    List<Book> getAllBooks();

    /**
     * Retrieves a book by its ID.
     *
     * @param id the ID of the book to retrieve
     * @return the book with the specified ID, or null if not found
     */
    Book getBookById(Long id);

    /**
     * Saves a book to the library.
     *
     * @param book the book to save
     * @return the saved book
     */
    Book saveBook(Book book);

    /**
     * Deletes a book from the library by its ID.
     *
     * @param id the ID of the book to delete
     */
    void deleteBook(Long id);
}
