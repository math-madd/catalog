package com.mathmadd.catalog.web.dto;

import java.time.LocalDate;

public class NoteDTO {

    private Long id;
    private String note;
    private LocalDate dateCreated;

    public NoteDTO(Long id, String note, LocalDate dateCreated) {
        this.id = id;
        this.note = note;
        this.dateCreated = dateCreated;
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

}
