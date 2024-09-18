package com.european.dynamics.loremipsum;

import com.european.dynamics.loremipsum.models.Book;
import com.european.dynamics.loremipsum.models.Chapter;
import com.european.dynamics.loremipsum.models.Line;
import com.european.dynamics.loremipsum.models.Paragraph;

/**
 * Class responsible for presenting specific elements such as lines, paragraphs, and chapters.
 */
public class ElementPresenter {

    /**
     * Presents specific elements (Line 13, Paragraph 7, and Chapter 4) from the given Book object.
     *
     * @param book The Book object from which the elements are presented.
     */
    public static void presentSpecificElements(Book book) {
        System.out.println("\n==== Specific Elements Presentation ====");

        // Present Line 13
        int lineNumber = 13;
        Line line = getLine(book, lineNumber);
        if (line != null) {
            System.out.println("Line " + lineNumber + ": " + line.getContent());
        } else {
            System.out.println("Line " + lineNumber + " not found.");
        }

        // Present Paragraph 7
        int paragraphNumber = 7;
        Paragraph paragraph = getParagraph(book, paragraphNumber);
        if (paragraph != null) {
            System.out.println("\nParagraph " + paragraphNumber + ":");
            paragraph.getLines().forEach(l -> System.out.println(l.getContent()));
        } else {
            System.out.println("Paragraph " + paragraphNumber + " not found.");
        }

        // Present Chapter 4 without "Paragraph:" label
        int chapterNumber = 4;
        if (book.getChapters().size() >= chapterNumber) {
            Chapter chapter = book.getChapters().get(chapterNumber - 1);
            System.out.println("\nChapter " + chapterNumber + ":");

            chapter.getParagraphs().forEach(p -> {
                p.getLines().forEach(l -> System.out.println(l.getContent()));
            });
        } else {
            System.out.println("Chapter " + chapterNumber + " not found.");
        }

        System.out.println("\n==== End of Specific Elements Presentation ====\n");
    }

    // Helper method to get a specific line
    private static Line getLine(Book book, int lineNumber) {
        int currentLine = 0;
        for (Chapter chapter : book.getChapters()) {
            for (Paragraph paragraph : chapter.getParagraphs()) {
                for (Line line : paragraph.getLines()) {
                    currentLine++;
                    if (currentLine == lineNumber) {
                        return line;
                    }
                }
            }
        }
        return null; // Line not found
    }

    // Helper method to get a specific paragraph
    private static Paragraph getParagraph(Book book, int paragraphNumber) {
        int currentParagraph = 0;
        for (Chapter chapter : book.getChapters()) {
            for (Paragraph paragraph : chapter.getParagraphs()) {
                currentParagraph++;
                if (currentParagraph == paragraphNumber) {
                    return paragraph;
                }
            }
        }
        return null; // Paragraph not found
    }
}