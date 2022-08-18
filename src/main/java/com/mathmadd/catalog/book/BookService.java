package com.mathmadd.catalog.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Autowired
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public void addNewBook(Book book) {
       Optional<Book> bookOptional = bookRepository
               .findBookByIsbn(book.getIsbn());
       if(bookOptional.isPresent()) {
           throw new IllegalStateException("ISBN already exists within database");
       }
       bookRepository.save(book);
    }

    public void deleteBook(Long bookId) {
        boolean bookExists = bookRepository.existsById(bookId);
        if(!bookExists) {
            throw new IllegalStateException("BOOK ID: " + bookId + " not found.");
        }
        bookRepository.deleteById(bookId);
        }

    @Transactional
    public void updateBook(Long bookId, String title, String isbn) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(()-> new IllegalStateException(
                        "BOOK ID: " + bookId + " not found."
                ));

        if(title != null && title.length() > 0 && !Objects.equals(book.getTitle(), title)) {
            book.setTitle(title);
        }

        if(isbn != null && isbn.length() > 0 && !Objects.equals(book.getIsbn(), isbn)) {
            Optional<Book> bookOptional = bookRepository.findBookByIsbn(isbn);
            if(bookOptional.isPresent()) {
                throw new IllegalStateException("ISBN already exists.");
            }
            book.setIsbn(isbn);
        }
    }
}

