package ru.job4j.algo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SmallestRangeFinder {
    public static int[] findSmallestRange(int[] nums, int k) {
        for (int i = 0; i <= nums.length - k; i++) {
            Set<Integer> distinctElements = new HashSet<>();
            for (int j = i; j < i + k; j++) {
                    distinctElements.add(nums[j]);
            }
            if (distinctElements.size() == k) {
                return new int[]{i, i + k - 1};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9};
        int k = 3;
        int[] result = findSmallestRange(nums, k);
        if (result != null) {
            System.out.println("Наименьший диапазон с " + k + " различными элементами: " + Arrays.toString(result));
        } else {
            System.out.println("Такой диапазон не существует.");
        }
    }
}
