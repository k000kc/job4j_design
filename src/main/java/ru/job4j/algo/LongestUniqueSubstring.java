package ru.job4j.algo;

import java.util.HashSet;
import java.util.Set;

public class LongestUniqueSubstring {
    public static String longestUniqueSubstring(String str) {
        int longest = 0;
        int longestIndex = 0;
        int start = 0;
        int end = 0;
        Set<Character> chars = new HashSet<>();
        while (end < str.length()) {
            char currentChar = str.charAt(end);
            if (!chars.contains(currentChar)) {
                chars.add(currentChar);
                end++;
                if (chars.size() > longest) {
                    longest = chars.size();
                    longestIndex = start;
                }
            } else {
                chars.remove(str.charAt(start));
                start++;
            }
        }
        return str.substring(longestIndex, longestIndex + longest);
    }
}
