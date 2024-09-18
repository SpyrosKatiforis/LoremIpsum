package com.european.dynamics.loremipsum.models;

import java.util.List;

/**
 * Represents a chapter in a book, consisting of multiple paragraphs.
 */
public class Chapter {

    private List<Paragraph> paragraphs;

    /**
     * Gets the list of paragraphs in the chapter.
     *
     * @return A list of Paragraph objects.
     */
    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }

    /**
     * Sets the list of paragraphs in the chapter.
     *
     * @param paragraphs A list of Paragraph objects.
     */
    public void setParagraphs(List<Paragraph> paragraphs) {
        this.paragraphs = paragraphs;
    }
}
