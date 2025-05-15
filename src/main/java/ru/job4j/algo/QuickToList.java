package ru.job4j.algo;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QuickToList {
    public static <T> void quickSort(List<T> sequence, Comparator<T> comparator) {
        quickSort(sequence, 0, sequence.size() - 1, comparator);
    }

    private static <T> void quickSort(List<T> sequence, int start, int end, Comparator<T> comparator) {
        if (start >= end) {
            return;
        }
        int h = breakPartition(sequence, start, end, comparator);
        quickSort(sequence, start, h - 1, comparator);
        quickSort(sequence, h + 1, end, comparator);
    }

    private static <T> int breakPartition(List<T> sequence, int start, int end, Comparator<T> comparator) {
        int beginToEnd = start + 1;
        T supportElement = sequence.get(start);
        for (int i = beginToEnd; i <= end; i++) {
            if (comparator.compare(sequence.get(i), supportElement) < 0) {
                Collections.swap(sequence, i, beginToEnd);
                beginToEnd++;
            }
        }
        Collections.swap(sequence, start, beginToEnd - 1);
        return beginToEnd - 1;
    }

    private static <T> void swap(List<T> array, int i, int j) {
        Collections.swap(array, i, j);
    }
}
