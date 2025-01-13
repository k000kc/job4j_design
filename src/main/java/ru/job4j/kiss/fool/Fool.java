package ru.job4j.kiss.fool;

import java.util.Scanner;

public class Fool {
    public static void main(String[] args) {
        new Fool().startFizzBuzz();
    }

    public void startFizzBuzz() {
        System.out.println("Игра FizzBuzz.");
        var startAt = 1;
        var input = new Scanner(System.in);
        while (startAt < 100) {
            String expectedAnswer = getExpectedAnswer(startAt);
            System.out.println(expectedAnswer);
            var answer = input.nextLine();
            startAt++;
            expectedAnswer = getExpectedAnswer(startAt);
            if (!checkAnswer(answer, expectedAnswer)) {
                System.out.println("Ошибка. Начинай снова.");
                startAt = 0;
            }
            startAt++;
        }
    }

    private String getExpectedAnswer(int startAt) {
        String message = String.valueOf(startAt);
        if (startAt % 3 == 0 && startAt % 5 == 0) {
            message = "FizzBuzz";
        } else if (startAt % 3 == 0) {
            message = "Fizz";
        } else if (startAt % 5 == 0) {
            message = "Buzz";
        }
        return message;
    }

    private boolean checkAnswer(String answer, String expectedAnswer) {
        return answer.equals(expectedAnswer);
    }
}
