package com.european.dynamics.loremipsum.models;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;

public class Chapter {
    private List<Paragraph> paragraphs;

    @XmlElement(name = "paragraph")
    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }

    public void setParagraphs(List<Paragraph> paragraphs) {
        this.paragraphs = paragraphs;
    }
}