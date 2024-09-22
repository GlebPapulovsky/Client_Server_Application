package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import static org.example.Server.PORT;

public class Client {
    public static void main(String[] args) throws IOException {
        try (Socket clientSocket = new Socket("netology.homework", Server.PORT);
             PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Client starts");
            while (true) {
                System.out.print(reader.readLine());
                String inputLine = scanner.nextLine();
                if (inputLine.equals("exit")) System.exit(0);
                writer.println(inputLine);
            }


        }


    }
}
