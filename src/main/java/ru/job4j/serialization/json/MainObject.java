package ru.job4j.serialization.json;

import java.util.Arrays;

public class MainObject {
    private OtheObject object;
    private boolean isBoolean;
    private int index;
    private String text;
    private char[] chars;

    public MainObject(OtheObject object, boolean isBoolean,
                      int index, String text, char[] chars) {
        this.object = object;
        this.isBoolean = isBoolean;
        this.index = index;
        this.text = text;
        this.chars = chars;
    }

    public OtheObject getObject() {
        return object;
    }

    public boolean isBoolean() {
        return isBoolean;
    }

    public int getIndex() {
        return index;
    }

    public String getText() {
        return text;
    }

    public char[] getChars() {
        return chars;
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
