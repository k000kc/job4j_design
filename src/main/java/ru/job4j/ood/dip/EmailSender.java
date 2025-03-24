package ru.job4j.ood.dip;

public class EmailSender {
    public void send(String to, String subject, String text) {
        System.out.println("Send to" + to + "Subject" + subject + "text:" + text);
    }
}
