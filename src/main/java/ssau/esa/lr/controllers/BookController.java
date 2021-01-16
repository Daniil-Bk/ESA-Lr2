package ssau.esa.lr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ssau.esa.lr.entity.Book;
import ssau.esa.lr.repos.BookRepo;

@RestController
public class BookController {
    private final BookRepo  repo;

    @Autowired
    public BookController(BookRepo repo) {
        this.repo = repo;
    }

    @GetMapping(path = "/books", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private Iterable<Book> findAll(){
        return repo.findAll();
    }
}
