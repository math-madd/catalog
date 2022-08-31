package com.mathmadd.catalog.service;

import com.mathmadd.catalog.model.Book;
import com.mathmadd.catalog.model.Note;

import java.util.List;


public interface BookService {

    List<Book> getBooks();


    void addNewBook(Book book);


    void deleteBook(Long bookId);


    void updateBook(Long bookId, String title, String isbn);

    void addNote(Long bookId, Note note);

}

