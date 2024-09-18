package com.european.dynamics.loremipsum;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

/**
 * Class responsible for validating an XML file against an XSD schema.
 */
public class XMLValidator {

    /**
     * Validates the given XML file against the specified XSD schema.
     *
     * @param xsdPath The path to the XSD schema file.
     * @param xmlPath The path to the XML file to be validated.
     * @return True if the XML file is valid according to the XSD schema, otherwise false.
     */
    public static boolean validateXMLSchema(String xsdPath, String xmlPath) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
            System.out.println("XML is valid.");
            return true;
        } catch (IOException | SAXException e) {
            System.out.println("XML is NOT valid. Reason: " + e.getMessage());
            return false;
        }
    }
}
