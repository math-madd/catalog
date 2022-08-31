package com.mathmadd.catalog.service;

import com.mathmadd.catalog.model.Note;

import java.util.Optional;

public interface NoteService {

    Optional<Note> findbyId(Long id);

    Note createNote(Note book);
}
