package com.mathmadd.catalog.web.dto;

import java.util.List;

public class BookDTO {

    private Long id;
    private String isbn;
    private String title;
    private String author_lastname;
    private String author_firstname;
    private String publisher;
    private String genre;
    private int pages;
    private String status;
    private List<NoteDTO> notes;

    public BookDTO() {
    }

    public BookDTO(Long id, String isbn, String title, String author_lastname, String author_firstname, String publisher, String genre, int pages, String status) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author_lastname = author_lastname;
        this.author_firstname = author_firstname;
        this.publisher = publisher;
        this.genre = genre;
        this.pages = pages;
        this.status = status;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor_lastname() {
        return author_lastname;
    }

    public void setAuthor_lastname(String author_lastname) {
        this.author_lastname = author_lastname;
    }

    public String getAuthor_firstname() {
        return author_firstname;
    }

    public void setAuthor_firstname(String author_firstname) {
        this.author_firstname = author_firstname;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<NoteDTO> getNotes() {
        return notes;
    }

    public void setNotes(List<NoteDTO> notes) {
        this.notes = notes;
    }

}
