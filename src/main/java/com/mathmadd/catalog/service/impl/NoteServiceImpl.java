package com.mathmadd.catalog.service.impl;

import com.mathmadd.catalog.model.Note;
import com.mathmadd.catalog.repository.NoteRepository;
import com.mathmadd.catalog.service.NoteService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }


    @Override
    public Optional<Note> findbyId(Long id) {
        return noteRepository.findById(id);
    }

    @Override
    public Note createNote(Note book) {
        return noteRepository.save(book);
    }
}
