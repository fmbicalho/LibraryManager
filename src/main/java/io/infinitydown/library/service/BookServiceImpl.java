package io.infinitydown.library.service;

import io.infinitydown.library.persistence.Book;
import io.infinitydown.library.persistence.dao.BookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Implementation of the BookService interface for managing books.
 */
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    /**
     * Retrieves all books from the repository.
     *
     * @return a list of all books
     */
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    /**
     * Retrieves a book by its ID from the repository.
     *
     * @param id the ID of the book to retrieve
     * @return the book with the specified ID, or null if not found
     */
    @Override
    public Book getBookById(Long id) {
        return bookRepository.getReferenceById(id);
    }

    /**
     * Saves a book to the repository.
     *
     * @param book the book to save
     * @return the saved book
     */
    @Transactional
    @Override
    public Book saveBook(Book book) {
        bookRepository.save(book);
        return book;
    }

    /**
     * Deletes a book from the repository by its ID.
     *
     * @param id the ID of the book to delete
     */
    @Transactional
    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

}
