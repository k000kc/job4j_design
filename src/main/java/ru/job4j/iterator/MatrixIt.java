package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row;
    private int column;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (row < data.length && (column >= data[row].length || data[row].length == 0)) {
            row++;
            column = 0;
        }
        return row < data.length;
    }
//    while (data[row].length == 0 || column >= data[row].length) {
//            row++;
//            column = 0;
//            if (row >= data.length) {
//                return false;
//            }
//        }
//        return true;
//    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row][column++];
    }
}
