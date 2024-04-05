package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "main")
@XmlAccessorType(XmlAccessType.FIELD)
public class MainObject {
    private OtherObject object;
    @XmlAttribute
    private boolean isBoolean;
    @XmlAttribute
    private int index;
    @XmlAttribute
    private String text;
    @XmlElementWrapper(name = "chars")
    @XmlElement(name = "char")
    private String[] chars;

    public MainObject() {
    }

    public MainObject(OtherObject object, boolean isBoolean,
                      int index, String text, String[] chars) {
        this.object = object;
        this.isBoolean = isBoolean;
        this.index = index;
        this.text = text;
        this.chars = chars;
    }

    @Override
    public String toString() {
        return "MainObject{"
                + "object=" + object
                + ", isBoolean=" + isBoolean
                + ", index=" + index
                + ", text='" + text + '\''
                + ", chars=" + Arrays.toString(chars)
                + '}';
    }
}
