package ru.job4j.io;

import java.io.*;
import java.util.*;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;
    private boolean stopChat;
    private List<String> log;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
        log = new LinkedList<>();
    }

    public void run() {
        List<String> phrases = readPhrases();
        Scanner scanner = new Scanner(System.in);
        String question = "";
        String answer;
        while (!Objects.equals(question, OUT)) {
            System.out.println(toAnswer(question));
            question = scanner.nextLine();
            log.add(question);
            if (!stopChat) {
                answer = phrases.get(new Random().nextInt(phrases.size()));
                System.out.println(answer);
            }
        }
        saveLog(log);
    }

    private String toAnswer(String question) {
        String res = "Задайте вопрос боту:";
        if (stopChat || Objects.equals(STOP, question)) {
            res = "Чат приостановлен. Введите 'продолжить' чтобы продолжить.";
            stopChat = true;
        }
        if (Objects.equals(CONTINUE, question)) {
            res = "Чат возобновлен.";
            stopChat = false;
        }
        log.add(res);
        return res;
    }

    private List<String> readPhrases() {
        List<String> phrases = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(botAnswers))) {
            reader.lines().map(phrase -> phrase + System.lineSeparator()).forEach(phrases::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return phrases;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter writer = new PrintWriter(path)) {
            log.forEach(writer::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat consoleChat = new ConsoleChat("./src/data/log.txt", "./src/data/answers.txt");
        consoleChat.run();
    }
}
