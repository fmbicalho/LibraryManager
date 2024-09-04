package io.infinitydown.library.controller;

import io.infinitydown.library.command.BookDTO;
import io.infinitydown.library.command.BookDTOToBook;
import io.infinitydown.library.command.BookToBookDTO;
import io.infinitydown.library.persistence.Book;
import io.infinitydown.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;
import java.util.List;

/**
 * Controller for handling book-related requests.
 */
@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookDTOToBook bookDtoToBook;
    private final BookToBookDTO bookToBookDTO;
    private final BookService bookService;

    /**
     * Displays a list of all books.
     *
     * @param model the model to which the list of books will be added
     * @return the view name for displaying the list of books
     */
    @RequestMapping(method = RequestMethod.GET, path = {"/list", "/", ""})
    public String listBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "index";
    }

    /**
     * Displays the details of a specific book.
     *
     * @param id the ID of the book to display
     * @param model the model to which the book will be added
     * @return the view name for displaying the book details
     */
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public String showBook(@PathVariable Long id, Model model){
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "detail";
    }

    /**
     * Displays the form for adding a new book.
     *
     * @param model the model to which a new BookDTO will be added
     * @return the view name for adding or editing a book
     */
    @RequestMapping(method = RequestMethod.GET, path = "/add")
    public String addBook(Model model) {
        model.addAttribute("book", new BookDTO());
        return "add-edit";
    }

    /**
     * Displays the form for editing an existing book.
     *
     * @param id the ID of the book to edit
     * @param model the model to which the BookDTO will be added
     * @return the view name for adding or editing a book
     */
    @RequestMapping(method = RequestMethod.GET, path = "/{id}/edit")
    public String editBook(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookToBookDTO.convert(bookService.getBookById(id)));
        return "add-edit";
    }

    /**
     * Saves a new or existing book.
     *
     * @param bookDto the BookDTO containing book details
     * @param bindingResult the result of binding the bookDto
     * @param redirectAttributes attributes to be redirected
     * @return the redirect view name after saving
     */
    @RequestMapping(method = RequestMethod.POST, path = {"/", ""}, params = "action=save")
    public String saveBook(@Valid @ModelAttribute("book") BookDTO bookDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "/add-edit";
        }
        Book savedBook = bookService.saveBook(bookDtoToBook.convert(bookDto));
        redirectAttributes.addFlashAttribute("lastAction", "Saved " + savedBook.getTitle() + " " + savedBook.getAuthor());
        return "redirect:/books/" + savedBook.getId();
    }

    /**
     * Cancels the book addition or editing process.
     *
     * @return the redirect view name for canceling the process
     */
    @RequestMapping(method = RequestMethod.POST, path = {"/", ""}, params = "action=cancel")
    public String cancelSaveBook() {
        return "redirect:/books/";
    }

    /**
     * Deletes a specific book.
     *
     * @param id the ID of the book to delete
     * @param redirectAttributes attributes to be redirected
     * @return the redirect view name after deleting the book
     */
    @RequestMapping(method = RequestMethod.GET, path = "{id}/delete")
    public String deleteBook(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        Book book = bookService.getBookById(id);
        bookService.deleteBook(id);
        redirectAttributes.addFlashAttribute("lastAction", "Deleted " + book.getTitle() + " " + book.getAuthor());
        return "redirect:/books";
    }
}


