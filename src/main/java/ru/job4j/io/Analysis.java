package ru.job4j.io;

import java.io.*;

public class Analysis {

    public void unavailable(String source, String target) {
        String[] statusAndTime;
        boolean statusMarker = true;
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             PrintWriter writer = new PrintWriter(
                     new BufferedOutputStream(
                             new FileOutputStream(target))
             )) {
            for (String str : reader.lines().toList()) {
                statusAndTime = str.split(" ");
                if (!isWork(statusAndTime[0]) && statusMarker) {
                    builder.append(statusAndTime[1]).append(";");
                    statusMarker = false;
                }
                if (isWork(statusAndTime[0]) && !statusMarker) {
                    builder.append(statusAndTime[1]).append(";\n");
                    statusMarker = true;
                }
            }
            writer.print(builder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isWork(String status) {
        return !"400".equals(status) && !"500".equals(status);
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}
