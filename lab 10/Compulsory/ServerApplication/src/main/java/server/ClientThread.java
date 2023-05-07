package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Class ClientThread - responsible with communicating with a client Socket
 */

public class ClientThread extends Thread {
    private final Socket clientSocket;
    private final GameServer server;
    private PrintWriter out;


    public ClientThread(Socket clientSocket, GameServer server) {
        this.clientSocket = clientSocket;
        this.server = server;
    }

    @Override
    public void run() {
        BufferedReader in;
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received message from client: " + inputLine); //print message from client
                if (inputLine.equals("stop")) { //stop the server when receiving the command stop
                    server.stop();
                    sendMessage("Server stopped");
                    break;
                } else {
                    server.receiveRequest(inputLine);
                    sendMessage("Server received the request: " + inputLine);
                }
            }
            in.close();
            out.close();
            clientSocket.close();
            System.out.println("Client disconnected: " + clientSocket);
        } catch (Exception e) {
            System.err.println("Error in client thread: " + e.getMessage());
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }
}

