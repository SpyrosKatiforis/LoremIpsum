package com.european.dynamics.loremipsum;

import com.european.dynamics.loremipsum.models.Book;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

/**
 * Class responsible for generating an XSD schema from the Book model.
 */
public class XSDGenerator {

    /**
     * Generates an XSD schema based on the Book model and saves it to the specified path.
     *
     * @param outputPath The path where the generated XSD schema will be saved.
     * @throws Exception If there is an issue generating the schema.
     */
    public static void generateXSD(String outputPath) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(Book.class);
        jaxbContext.generateSchema(new SchemaOutputResolver() {
            @Override
            public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
                File file = new File(outputPath);
                StreamResult result = new StreamResult(file);
                result.setSystemId(file.toURI().toString());
                return result;
            }
        });
        System.out.println("XSD schema generated at: " + outputPath);
    }
}