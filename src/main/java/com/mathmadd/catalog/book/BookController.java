package com.mathmadd.catalog.book;

import org.openwms.core.http.Index;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mathmadd.catalog.CatalogConstants.API_BOOKS;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping(API_BOOKS + "/index")
    public ResponseEntity<Index> bookIndex() throws Exception {
        return ResponseEntity.ok(
                new Index(
                        linkTo(methodOn(BookController.class).getBooks()).withRel("get-all-books")
                )
        );
    }

    @GetMapping(value = API_BOOKS + "/all_books")
    public ResponseEntity<List<Book>> getBooks() {

        return ResponseEntity.ok(bookService.getBooks());
    }

    @PostMapping
    public void addNewBook(@RequestBody Book book) {
        bookService.addNewBook(book);
    }

    @DeleteMapping(path = {"bookId"})
    public void deleteBook(@PathVariable("bookId") Long bookId){
        bookService.deleteBook(bookId);
    }

    @PutMapping(path = {"bookId"})
    public void updateBook(
            @PathVariable("bookId") Long bookId,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String isbn) {
        bookService.updateBook(bookId, title, isbn);
    }
}
