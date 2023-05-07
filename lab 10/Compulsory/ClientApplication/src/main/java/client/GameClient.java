package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Class GameClient - reads commands from the keyboard and sends them
 * to the server
 */
public class GameClient {
    private final String serverAddress;
    private final int serverPort;
    private Socket socket;
    private boolean running;

    public GameClient(String serverAddress, int serverPort) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
    }

    public void run() {
        PrintWriter output;
        BufferedReader input;
        try {
            socket = new Socket(serverAddress, serverPort);
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
            running = true;

            System.out.println("Connected to game server");

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (running) {
                String command = reader.readLine();
                if (command == null || command.equals("exit")) {
                    stop();
                    break;
                }
                output.println(command);
                String response = input.readLine();
                System.out.println("Server response: " + response);

                if (response != null && response.equals("Server stopped")) {
                    stop();
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Error connecting to server: " + e.getMessage());
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }
            System.out.println("Disconnected from game server");
        }
    }

    public void stop() {
        running = false;
        try {
            socket.close();
        } catch (IOException e) {
            // ignore
        }
    }


}

