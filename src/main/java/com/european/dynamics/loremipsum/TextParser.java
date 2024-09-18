package com.european.dynamics.loremipsum;

import com.european.dynamics.loremipsum.models.Book;
import com.european.dynamics.loremipsum.models.Chapter;
import com.european.dynamics.loremipsum.models.Line;
import com.european.dynamics.loremipsum.models.Paragraph;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible for parsing a text file into a Book object.
 * The text is divided into lines, paragraphs, and chapters based on specified rules.
 */
public class TextParser {

    /**
     * Parses a text file into a structured Book object.
     * Every line ends with a full stop (.) and each paragraph consists of 10 lines.
     * A chapter is formed after every 3 paragraphs.
     *
     * @param filePath The path of the text file to be parsed.
     * @return A Book object representing the parsed text.
     * @throws IOException If there is an issue reading the file.
     */
    public static Book parseTextFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        List<Chapter> chapters = new ArrayList<>();
        List<Paragraph> paragraphs = new ArrayList<>();
        List<Line> lines = new ArrayList<>();
        int lineCount = 0;

        while ((line = reader.readLine()) != null) {
            if (line.trim().isEmpty()) {
                continue;
            }

            String[] sentences = line.split("\\.");
            for (String sentence : sentences) {
                if (!sentence.trim().isEmpty()) {
                    Line lineObj = new Line();
                    lineObj.setContent(sentence.trim() + ".");
                    lines.add(lineObj);
                    lineCount++;

                    if (lineCount % 10 == 0) {
                        Paragraph paragraph = new Paragraph();
                        paragraph.setLines(new ArrayList<>(lines));
                        paragraphs.add(paragraph);
                        lines.clear();
                    }
                }
            }

            if (paragraphs.size() == 3) {
                Chapter chapter = new Chapter();
                chapter.setParagraphs(new ArrayList<>(paragraphs));
                chapters.add(chapter);
                paragraphs.clear();
            }
        }

        if (!lines.isEmpty()) {
            Paragraph paragraph = new Paragraph();
            paragraph.setLines(new ArrayList<>(lines));
            paragraphs.add(paragraph);
        }

        if (!paragraphs.isEmpty()) {
            Chapter chapter = new Chapter();
            chapter.setParagraphs(new ArrayList<>(paragraphs));
            chapters.add(chapter);
        }

        reader.close();
        Book book = new Book();
        book.setChapters(chapters);
        return book;
    }
}