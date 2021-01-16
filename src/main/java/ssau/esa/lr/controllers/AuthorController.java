package ssau.esa.lr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ssau.esa.lr.entity.Author;
import ssau.esa.lr.repos.AuthorRepo;

@RestController
public class AuthorController {

    private final AuthorRepo repo;

    @Autowired
    public AuthorController(AuthorRepo repo) {
        this.repo = repo;
    }

    @GetMapping(path = "/authors", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private Iterable<Author> findAll(){
        return repo.findAll();
    }
}
