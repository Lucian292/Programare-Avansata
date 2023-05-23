package Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Player {
    private final Socket socket;
    private final BufferedReader in;
    private final PrintWriter out;
    public boolean isInGame = false;
    public Player(Socket socket) throws IOException {
        this.socket = socket;
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(socket.getOutputStream(), true);
    }

    public void sendMessage(String message) {
        out.println(message);
    }

    public String receiveMessage() throws IOException {
        return in.readLine();
    }

    public Socket getSocket() {
        return socket;
    }

    public void close() throws IOException {
        in.close();
        out.close();
        socket.close();
    }
}
