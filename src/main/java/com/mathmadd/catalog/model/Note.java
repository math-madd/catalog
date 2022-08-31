package com.mathmadd.catalog.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String note;
    private LocalDate dateCreated;

    public Note(String note, LocalDate dateCreated) {
        this.note = note;
        this.dateCreated = dateCreated;
    }


    public Note(Note note) { this(note.getNote(), note.getDateCreated()); }

    public Note() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note1 = (Note) o;
        return Objects.equals(note, note1.note) && Objects.equals(dateCreated, note1.dateCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(note, dateCreated);
    }

    @Override
    public String toString() {
        return "Note{" +
                "note='" + note + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
