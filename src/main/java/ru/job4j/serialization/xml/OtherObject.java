package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "other")
public class OtherObject {
    @XmlAttribute
    private int value;
    @XmlAttribute
    private String name;

    public OtherObject() {
    }

    public OtherObject(int value, String name) {
        this.value = value;
        this.name = name;
    }

    @Override
    public String toString() {
        return "OtheObject{"
                + "value=" + value
                + ", name='" + name + '\''
                + '}';
    }
}
