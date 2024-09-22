package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final Integer PORT = 8080;

    public static void main(String[] args) throws IOException {
        try(ServerSocket serverSocket=new ServerSocket(PORT)){
            System.out.println("Server starts");
            while(true){
                try(Socket clientSocket=serverSocket.accept();
                PrintWriter printWriter=new PrintWriter(clientSocket.getOutputStream(),true);
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
                ){
                    String info=bufferedReader.readLine();
                    System.out.println("Your name port is "+clientSocket.getPort()+". You say: "+info);
                    printWriter.println("I see you! ");

                }
            }
        }

        }
}
