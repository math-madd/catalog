package com.mathmadd.catalog.model;

public enum BookStatus {

    UNREAD("Unread"),
    CURRENTLY_READING("Reading"),
    READ("Read");

    private final String label;

    BookStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
