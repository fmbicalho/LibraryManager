package io.infinitydown.library.controller;

import io.infinitydown.library.command.BookDTO;
import io.infinitydown.library.command.BookDTOToBook;
import io.infinitydown.library.command.BookToBookDTO;
import io.infinitydown.library.persistence.Book;
import io.infinitydown.library.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;
import java.util.stream.Collectors;

/**
 * REST controller for managing books.
 */
@RestController
@CrossOrigin(origins = "http://localhost:8085")
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookRestController {

    private final BookDTOToBook bookDTOToBook;
    private final BookToBookDTO bookToBookDTO;
    private final BookService bookService;

    /**
     * Retrieves a list of all books.
     *
     * @return a ResponseEntity containing a list of BookDTOs
     */
    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<BookDTO> books = bookService.getAllBooks().stream()
                .map(bookToBookDTO::convert)
                .collect(Collectors.toList());
        return ResponseEntity.ok(books);
    }

    /**
     * Retrieves a specific book by its ID.
     *
     * @param id the ID of the book to retrieve
     * @return a ResponseEntity containing the BookDTO if found, or NOT_FOUND status if not
     */
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bookToBookDTO.convert(book), HttpStatus.OK);
    }

    /**
     * Creates a new book.
     *
     * @param bookDto the BookDTO containing book details
     * @param bindingResult the result of binding the bookDto
     * @param uriComponentsBuilder used to build the URI for the new book
     * @return a ResponseEntity with CREATED status and the location of the new book
     */
    @RequestMapping(method = RequestMethod.POST, path = {"/", ""})
    public ResponseEntity<?> createBook(@Valid @RequestBody BookDTO bookDto, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) {
        if (bindingResult.hasErrors() || bookDto.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Book savedBook = bookService.saveBook(bookDTOToBook.convert(bookDto));
        UriComponents uriComponents = uriComponentsBuilder.path("/api/books/" + savedBook.getId()).build();
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    /**
     * Updates an existing book.
     *
     * @param bookDto the BookDTO containing updated book details
     * @param bindingResult the result of binding the bookDto
     * @param id the ID of the book to update
     * @return a ResponseEntity with OK status or BAD_REQUEST status if there were validation errors
     */
    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<BookDTO> updateBook(@Valid @RequestBody BookDTO bookDto, BindingResult bindingResult, @PathVariable Long id) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (bookDto.getId() != null && !bookDto.getId().equals(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (bookService.getBookById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        bookDto.setId(id);
        bookService.saveBook(bookDTOToBook.convert(bookDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Deletes a specific book by its ID.
     *
     * @param id the ID of the book to delete
     * @return a ResponseEntity with NO_CONTENT status
     */
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<BookDTO> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
