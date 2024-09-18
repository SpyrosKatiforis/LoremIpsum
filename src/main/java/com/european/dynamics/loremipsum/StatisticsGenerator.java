package com.european.dynamics.loremipsum;

import com.european.dynamics.loremipsum.models.Book;
import com.european.dynamics.loremipsum.models.Chapter;
import com.european.dynamics.loremipsum.models.Line;
import com.european.dynamics.loremipsum.models.Paragraph;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

/**
 * Class responsible for generating and displaying statistics about the parsed document.
 * The statistics include the number of paragraphs, lines, words, distinct words, 
 * the creation date/time, the author's name, and the application class name.
 */
public class StatisticsGenerator {

    private static final String AUTHOR_NAME = "Lorem Ipsum";

    /**
     * Generates and prints statistics such as the number of paragraphs, lines, words, distinct words,
     * creation time, author name, and application class name.
     *
     * @param book The Book object representing the parsed document.
     */
    public static void generateStatistics(Book book) {
        int paragraphCount = 0;
        int lineCount = 0;
        int wordCount = 0;
        Set<String> distinctWords = new HashSet<>();

        // Count paragraphs, lines, and words, and collect distinct words
        for (Chapter chapter : book.getChapters()) {
            for (Paragraph paragraph : chapter.getParagraphs()) {
                paragraphCount++;
                for (Line line : paragraph.getLines()) {
                    lineCount++;
                    String[] words = line.getContent().split("\\s+");
                    wordCount += words.length;
                    for (String word : words) {
                        distinctWords.add(word.toLowerCase());
                    }
                }
            }
        }

        // Get current date and time for document creation, formatted to yyyy-MM-dd HH:mm:ss
        LocalDateTime creationDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Print the statistics
        System.out.println("\n==== Document Statistics ====");
        System.out.println("Author's Name: " + AUTHOR_NAME);
        System.out.println("Application Class Name: " + StatisticsGenerator.class.getSimpleName());
        System.out.println("Date/Time of Creation: " + creationDateTime.format(formatter));
        System.out.println("Number of Paragraphs: " + paragraphCount);
        System.out.println("Number of Lines: " + lineCount);
        System.out.println("Number of Words: " + wordCount);
        System.out.println("Number of Distinct Words: " + distinctWords.size());
        System.out.println("==============================\n");
    }
}