package app;

import Network.GameRoom;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class SimpleServer {
    public static final int PORT = 8100;
    public static Boolean running = true;

    private static final GameRoom[] ROOMS = new GameRoom[50];
    private static int nextRoomID = 1;

    public static synchronized void removeGameRoom(GameRoom room) {
        for (int i = 0; i < ROOMS.length; i++) {
            if (ROOMS[i] == room) {
                ROOMS[i] = null;
                break;
            }
        }
    }



    public static synchronized int getNextRoomID() {
        return nextRoomID++;
    }

    public SimpleServer() throws IOException {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(PORT);
            while (running) {
                serverSocket.setSoTimeout(1000);
                try {
                    Socket socket = serverSocket.accept();
                    new ClientThread(socket).start();
                } catch (SocketTimeoutException e) {
                    // System.err.println("acceptam un nou client");
                }
            }
        } catch (IOException e) {
            System.err.println("Ooops... " + e);
        } finally {
            serverSocket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        SimpleServer server = new SimpleServer();
    }

}