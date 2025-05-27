package ru.job4j.algo;

import java.util.*;

public class Main {
    public static int[] findMaxOverlapInterval(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return new int[] {-1, -1};
        }
        Collections.sort(intervals, Comparator.comparingInt(i -> i.start));
        Queue<Interval> activeIntervals = new PriorityQueue<>(Comparator.comparingInt(i -> i.end));
        int maxOverlap = 0;
        int maxStart = -1;
        int maxEnd = -1;

        for (Interval interval : intervals) {
            while (!activeIntervals.isEmpty() && activeIntervals.peek().end < interval.start) {
                activeIntervals.poll();
            }
            activeIntervals.add(interval);
            if (activeIntervals.size() > maxOverlap) {
                maxOverlap = activeIntervals.size();
                maxStart = interval.start;
                maxEnd = activeIntervals.peek().end;
            }
            if (activeIntervals.size() == maxOverlap) {
                if (interval.start < maxStart) {
                    maxStart = interval.start;
                }
                if (activeIntervals.peek().end < maxEnd) {
                    maxEnd = activeIntervals.peek().end;
                }
            }
        }
        return new int[] {
                maxStart, maxEnd
        };
    }

    public static void main(String[] args) {
        List intervals = new ArrayList();
        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(3, 5));
        intervals.add(new Interval(7, 8));

        int[] result = findMaxOverlapInterval(intervals);

        System.out.println("Interval that overlaps the maximum number of intervals: [" + result[0] + ", " + result[1] + "]");
    }
}
