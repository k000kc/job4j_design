package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream output = socket.getOutputStream();
                     BufferedReader input = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    output.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    String answer = prepareAnswer(input.readLine());
                    if (Objects.equals(answer, "Exit")) {
                        output.write("Shut down the server".getBytes());
                        server.close();
                        break;
                    }
                    if (Objects.equals(answer, "Hello")) {
                        output.write(answer.getBytes());
                    } else {
                        output.write("What".getBytes());
                    }
                    output.flush();
                }
            }
        }
    }

    private static String prepareAnswer(String line) {
        String rsl = "";
        Pattern pattern = Pattern.compile("((?<=msg=).*?(?= HTTP))");
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            rsl = matcher.group();
        }
        return rsl;
    }
}
