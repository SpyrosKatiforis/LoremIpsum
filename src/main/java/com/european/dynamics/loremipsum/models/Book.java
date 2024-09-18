package com.european.dynamics.loremipsum.models;

import java.util.List;

/**
 * Represents a book, consisting of multiple chapters.
 */
public class Book {

    private List<Chapter> chapters;

    /**
     * Gets the list of chapters in the book.
     *
     * @return A list of Chapter objects.
     */
    public List<Chapter> getChapters() {
        return chapters;
    }

    /**
     * Sets the list of chapters in the book.
     *
     * @param chapters A list of Chapter objects.
     */
    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }
}
