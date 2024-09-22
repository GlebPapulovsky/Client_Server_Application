package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import static org.example.Server.PORT;

public class Client {
    public static  void main (String[] args)throws IOException{
        try(Socket clientSocket=new Socket("localhost", Server.PORT);
        PrintWriter writer=new PrintWriter(clientSocket.getOutputStream(),true);
        BufferedReader reader=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))){
            System.out.println("Client starts");
            writer.println("Hello,I'm you");
            System.out.println(reader.readLine()+ "___Me too");

        }


    }
}
