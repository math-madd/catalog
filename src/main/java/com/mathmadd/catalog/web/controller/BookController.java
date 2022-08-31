package com.mathmadd.catalog.web.controller;

import com.mathmadd.catalog.model.Book;
import com.mathmadd.catalog.model.Note;
import com.mathmadd.catalog.service.BookService;
import com.mathmadd.catalog.service.NoteService;
import com.mathmadd.catalog.web.dto.BookDTO;
import com.mathmadd.catalog.web.dto.NoteDTO;
import org.openwms.core.http.Index;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/v1/catalog/books")
public class BookController {

    private final BookService bookService;
    private final NoteService noteService;


    public BookController(BookService bookService, NoteService noteService) {

        this.bookService = bookService;
        this.noteService = noteService;
    }


    @GetMapping(value = "/index")
    public ResponseEntity<Index> bookIndex() {
        return ResponseEntity.ok(
                new Index(
                        linkTo(methodOn(BookController.class).getBooks()).withRel("get-all-books"),
                        linkTo(methodOn(BookController.class).addNewBook(new BookDTO())).withRel("add-new-book"),
                        linkTo(methodOn(BookController.class).updateBook(1L, "title", "0000000000000")).withRel("update-book"),
                        linkTo(methodOn(BookController.class).addNote(1L, "notes")).withRel("add-note-by-id"),
                        linkTo(methodOn(BookController.class).deleteBook(1L)).withRel("delete-book")
                )
        );
    }

    @GetMapping(value = "/all_books")
    public ResponseEntity<List<BookDTO>> getBooks() {
        Iterable<Book> allBooks = this.bookService.getBooks();
        List<BookDTO> bookDTOS = new ArrayList<>();
        allBooks.forEach(book -> bookDTOS.add(convertToBookDTO(book)));

        return ResponseEntity.ok(bookDTOS);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Book> addNewBook(@RequestBody BookDTO newBook)
    {
        Book bookEO = convertToBookEntity(newBook);
        bookService.addNewBook(bookEO);
        return ResponseEntity.ok(bookEO);
    }

    @PutMapping(path = "{bookId}")
    public ResponseEntity<Void> updateBook(
            @PathVariable("bookId") Long bookId,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String isbn)
    {
        bookService.updateBook(bookId, title, isbn);
        return ResponseEntity.ok(null);
    }

    @PutMapping(path = "addNote/{bookId}")
    public ResponseEntity<Void> addNote(
            @PathVariable("bookId") Long bookId,
            @RequestBody String note)
    {
        bookService.addNote(bookId, noteService.createNote(new Note(note, LocalDate.now())));
        return ResponseEntity.ok(null);
    }

    @DeleteMapping(path = "{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable("bookId") Long bookId){

        bookService.deleteBook(bookId);
        return ResponseEntity.ok(null);
    }

    protected BookDTO convertToBookDTO(Book bookEO) {
        BookDTO bookDTO = new BookDTO(
                bookEO.getId(),
                bookEO.getIsbn(),
                bookEO.getTitle(),
                bookEO.getAuthor_lastname(),
                bookEO.getAuthor_firstname(),
                bookEO.getPublisher(),
                bookEO.getGenre(),
                bookEO.getPages(),
                bookEO.getStatus()
        );
        bookDTO.setNotes(bookEO.getNotes()
                .stream()
                .map(this::convertToNoteDTO)
                .collect(Collectors.toList()));

        return bookDTO;
    }

    protected Book convertToBookEntity(BookDTO bookDTO) {
        Book book = new Book(
                bookDTO.getIsbn(),
                bookDTO.getTitle(),
                bookDTO.getAuthor_lastname(),
                bookDTO.getAuthor_firstname(),
                bookDTO.getPublisher(),
                bookDTO.getGenre(),
                bookDTO.getPages());

        if(!Objects.isNull((bookDTO.getId()))) {
            book.setId(book.getId());
        }
        return book;
    }

    protected NoteDTO convertToNoteDTO(Note note) {
        return new NoteDTO(
                note.getId(),
                note.getNote(),
                note.getDateCreated()
        );
    }

    protected Note convertToNoteEntity(NoteDTO noteDTO) {
        Note note = new Note(
                noteDTO.getNote(),
                noteDTO.getDateCreated()
        );
        if(!Objects.isNull(noteDTO.getId())) {
            note.setNote(noteDTO.getNote());
        }
        return note;
    }

}
