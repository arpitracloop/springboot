package arpit.springboot.springbootproject.controllers;

import arpit.springboot.springbootproject.domian.Book;
import arpit.springboot.springbootproject.repositories.BookRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public Iterable<Book> getBooks(Model model)
    {
        Iterable<Book> books = bookRepository.findAll();
        model.addAttribute("books",bookRepository.findAll());
        return books;

    }
}
