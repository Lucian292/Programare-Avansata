package server;

/**
 * Class Main - used to test the server
 */

public class Main {
    public static void main(String[] args) {
        int port = 2424;
        GameServer server = new GameServer(port); //make new GameServer at given port
        server.run(); //start the server
    }
}