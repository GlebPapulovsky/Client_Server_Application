package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    public static final Integer PORT = 8080;


    public static void main(String[] args) throws IOException {
        Map<String, UserInfo> map = new HashMap<>();
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server starts");
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
                ) {
                    UserInfo userInfo = new UserInfo();
                    writer.println("Write your name: ");
                    userInfo.setName(reader.readLine());
                    writer.println("Write your surname: ");
                    userInfo.setSurname(reader.readLine());
                    writer.println("How many years old are you?");
                    userInfo.setAge(Integer.parseInt(reader.readLine()));
                    if (userInfo.getAge() < 14) {
                        writer.printf("Welcome to the kids area, %s! Let's play!",userInfo.getName() );
                    } else {
                        writer.printf("Welcome to the adult zone, %s! Have a good rest, or a good working day!", userInfo.getName());
                    }
                    writer.println(userInfo.printInfo());
                    while(true){
                        writer.println("Print 'exit' for end.");
                    }


                }
            }
        }

    }

}
