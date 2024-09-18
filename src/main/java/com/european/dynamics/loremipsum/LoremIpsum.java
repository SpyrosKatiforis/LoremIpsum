package com.european.dynamics.loremipsum;

import com.european.dynamics.loremipsum.models.Book;

/**
 * Main class to demonstrate the use cases of parsing, marshalling, XSD generation,
 * XML validation, and presenting specific elements.
 */
public class LoremIpsum {

    /**
     * Main method to demonstrate various use cases of the application.
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

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}