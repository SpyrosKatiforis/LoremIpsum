package com.european.dynamics.loremipsum.models;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;

public class Paragraph {
    private List<Line> lines;

    @XmlElement(name = "line")
    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }
}