package com.european.dynamics.loremipsum.models;

import java.util.List;

/**
 * Represents a paragraph in a chapter, consisting of multiple lines.
 */
public class Paragraph {

    private List<Line> lines;

    /**
     * Gets the list of lines in the paragraph.
     *
     * @return A list of Line objects.
     */
    public List<Line> getLines() {
        return lines;
    }

    /**
     * Sets the list of lines in the paragraph.
     *
     * @param lines A list of Line objects.
     */
    public void setLines(List<Line> lines) {
        this.lines = lines;
    }
}
