package ru.job4j.regex;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample2 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("11");
        String text = "111111";
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println("Найдено совпадение: " + matcher.group());
        }

        String string = "123+=-456:/789";
        String[] result = string.split("\\D+");
        System.out.println(Arrays.toString(result));

        pattern = Pattern.compile("\\d{2}\\.\\d{2}\\.\\d{4}");
        text = "24.04.1987 11.11.111111 99.99.99991 99.99.9999 99999999 0000.00.00";
        matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println("Найдено совпадение: " + matcher.group());
        }
        System.out.println();
        pattern = Pattern.compile("\\b\\d{2}\\.\\d{2}\\.\\d{4}\\b");
        text = "24.04.1987 11.11.111111 99.99.99991 99.99.9999 99999999 0000.00.00";
        matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println("Найдено совпадение: " + matcher.group());
        }
        System.out.println();
        pattern = Pattern.compile("\\S{1,}@\\S{1,}\\.\\S{1,}");
        text = "peter-2022@example.com example65@mail_box.ru 123_45@example-mailbox.com";
        matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println("Найдено совпадение: " + matcher.group());
        }
    }
}
