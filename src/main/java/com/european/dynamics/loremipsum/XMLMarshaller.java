package com.european.dynamics.loremipsum;

import com.european.dynamics.loremipsum.models.Book;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

/**
 * Class responsible for marshalling a Book object to XML format.
 */
public class XMLMarshaller {

    /**
     * Marshals the given Book object into an XML file.
     * The output XML is formatted for readability.
     *
     * @param book The Book object to be marshalled.
     * @param outputFilePath The path where the generated XML file will be saved.
     */
    public static void marshallToXML(Book book, String outputFilePath) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Book.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            File file = new File(outputFilePath);
            jaxbMarshaller.marshal(book, file);
            System.out.println("XML file created: " + outputFilePath);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}