package com.company;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;


public class Main {

    private static final String SERVER_NAME = "localhost";
    private static final int SERVER_PORT = 5000;
    private static final String EXIT = "exit";


    public static void main(String[] args) {
        try {
            InetAddress serverAddress = InetAddress.getByName(SERVER_NAME);
            DatagramSocket clientSocket = new DatagramSocket(5678);

            Scanner scanner = new Scanner(System.in);
            String clientMessage;

            do {
                System.out.println("Enter your message ....");
                clientMessage = scanner.nextLine();

                if (clientMessage.equals(EXIT)) break;

                byte[] buffer = clientMessage.getBytes();

                DatagramPacket sendingPacket = new DatagramPacket(buffer, buffer.length,
                        serverAddress,SERVER_PORT);
                clientSocket.send(sendingPacket);
            }while (true);

            clientSocket.close();

        } catch (UnknownHostException e) {
            System.out.println("The destination not found: " + e.getMessage());
        } catch (SocketException e) {
            System.out.println("Problem on the socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
