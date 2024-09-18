package com.european.dynamics.loremipsum;

import com.european.dynamics.loremipsum.models.Book;

/**
 * Main class to demonstrate the various use cases of the application.
 * The application parses a text file, generates an XML file, creates an XSD schema,
 * validates the XML file against the XSD schema, presents specific elements from the document,
 * and generates document statistics such as the number of paragraphs, lines, words, distinct words,
 * and other metadata (e.g., author name, creation date/time).
 */
public class LoremIpsum {

    /**
     * Main method to run the application, which includes the following steps:
     * 1. Parse a text file into a structured Book object.
     * 2. Marshall the Book object into an XML file.
     * 3. Generate an XSD schema based on the Book model.
     * 4. Validate the XML file against the generated XSD schema.
     * 5. Present specific elements from the document (Line 13, Paragraph 7, Chapter 4).
     * 6. Generate and display statistics about the document.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        try {
            // Paths for input, output, and XSD
            String filePath = "C:/Users/admin/Downloads/sample-lorem-ipsum-text-file.txt";
            String xmlOutputPath = "C:/Users/admin/Downloads/output.xml";
            String xsdPath = "src/main/resources/schemas/book-schema.xsd";

            // Step 1: Parse the text file into a Book object
            Book book = TextParser.parseTextFile(filePath);

            // Step 2: Marshall the Book object to XML
            XMLMarshaller.marshallToXML(book, xmlOutputPath);

            // Step 3: Generate XSD from the Book model
            XSDGenerator.generateXSD(xsdPath);

            // Step 4: Validate the XML against the generated XSD
            XMLValidator.validateXMLSchema(xsdPath, xmlOutputPath);

            // Step 5: Present specific elements (Line 13, Paragraph 7, Chapter 4)
            ElementPresenter.presentSpecificElements(book);

            // Step 6: Generate and display document statistics
            StatisticsGenerator.generateStatistics(book);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}