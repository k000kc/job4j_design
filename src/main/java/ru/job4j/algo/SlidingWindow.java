package ru.job4j.algo;

public class SlidingWindow {
    public static int findMaxSum(int[] arr, int k) {
        // Проверка на случай, если размер окна больше, чем длина массива
        if (arr.length < k) {
            throw new IllegalArgumentException("Размер окна должен быть меньше или равен длине массива");
        }

        int maxSum = 0;
        int windowSum = 0;

        // Инициализация первого окна
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;

        // Скольжение окна по массиву
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 3;
        System.out.println("Максимальная сумма подмассива длиной " + k + " равна " + findMaxSum(arr, k));
    }
}
