package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Class GameServer - creates a ServerSocket at a specified port,
 * manages client requests and connections
 *
 */

public class GameServer {
    private ServerSocket serverSocket;
    private boolean running; //true or false


    public GameServer(int port) { // create ServerSocket at port given as parameter
        try {
            serverSocket = new ServerSocket(port);
            running = true;
            System.out.println("Game server started on port " + port);
        } catch (IOException e) {
            System.err.println("Error starting server: " + e.getMessage());
        }
    }

    public void run() {
        while (running) {
            try {
                Socket clientSocket = serverSocket.accept();
                ClientThread clientThread = new ClientThread(clientSocket, this);
                clientThread.start();
                System.out.println("Client connected: " + clientSocket);
            } catch (IOException e) {
                System.err.println("Error accepting client connection: " + e.getMessage());
            }
        }
    }

    public void stop() {
        try {
            running = false; // stop the server from running
            serverSocket.close(); //close the socket
            System.out.println("Game server stopped");
        } catch (IOException e) {
            System.err.println("Error stopping server: " + e.getMessage());
        }
    }

    public void receiveRequest(String request) {
        // will handle the requests here
        System.out.println("Received request: " + request);
    }
}
