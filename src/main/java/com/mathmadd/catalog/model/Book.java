package com.mathmadd.catalog.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table
public class Book {
    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    private Long id;
    private String isbn;
    private String title;
    private String author_lastname;
    private String author_firstname;
    private String publisher;
    private String genre;
    private int pages;
    private String status;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private List<Note> notes;

    public Book() {
    }

    public Book(String isbn, String title, String author_lastname, String author_firstname, String publisher, String genre, int pages) {
        this.isbn = isbn;
        this.title = title;
        this.author_lastname = author_lastname;
        this.author_firstname = author_firstname;
        this.publisher = publisher;
        this.genre = genre;
        this.pages = pages;
        this.status = BookStatus.UNREAD.getLabel();
        this.notes = new ArrayList<>();
    }

    public Book(String isbn, String title, String author_lastname, String author_firstname, String publisher, String genre, int pages, String status) {
        this.isbn = isbn;
        this.title = title;
        this.author_lastname = author_lastname;
        this.author_firstname = author_firstname;
        this.publisher = publisher;
        this.genre = genre;
        this.pages = pages;
        this.status = status;
        this.notes = new ArrayList<>();
    }

    public Book(Book book) {
        this(book.getIsbn(), book.getTitle(), book.getAuthor_lastname(), book.getAuthor_firstname(), book.getPublisher(), book.getGenre(), book.getPages());
        this.notes = new ArrayList<>(book.getNotes());
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

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return pages == book.pages && Objects.equals(id, book.id) && Objects.equals(isbn, book.isbn) && Objects.equals(title, book.title) && Objects.equals(author_lastname, book.author_lastname) && Objects.equals(author_firstname, book.author_firstname) && Objects.equals(publisher, book.publisher) && Objects.equals(genre, book.genre) && Objects.equals(notes, book.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isbn, title, author_lastname, author_firstname, publisher, genre, pages, notes);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author_lastname='" + author_lastname + '\'' +
                ", author_firstname='" + author_firstname + '\'' +
                ", publisher='" + publisher + '\'' +
                ", genre='" + genre + '\'' +
                ", pages=" + pages +
                ", notes=" + notes +
                '}';
    }

}
