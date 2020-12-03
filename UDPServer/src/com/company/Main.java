package com.company;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Main {

    private static final int PORT = 5000;
    private static final int BUFFER_LENGTH = 1024;

    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(PORT);
            System.out.println("The server is launched !");
            System.out.println("Waiting for new messages ....");

            while (true){
                byte[] buffer = new byte[BUFFER_LENGTH];

                DatagramPacket receivedPacket = new DatagramPacket(buffer, buffer.length);
                serverSocket.receive(receivedPacket);
                String messageReceived = new String(receivedPacket.getData());

                System.out.println("****************************************");
                System.out.println("New message !!!");
                System.out.println("From: " + receivedPacket.getAddress());
                System.out.println("On Port: "  + receivedPacket.getPort());
                System.out.println("Message: " + messageReceived);
                System.out.println("****************************************");

            }
        } catch (SocketException e) {
            System.out.println("SocketException: " + e.getMessage());
        } catch (IOException e){
            System.out.println("IOExecption: " + e.getMessage());
        }
    }
}
