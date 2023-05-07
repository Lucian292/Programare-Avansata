package client;

/**
 * Class Main - used to test the client
 */
public class Main {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 2424;
        GameClient client = new GameClient(serverAddress, serverPort);
        client.run();
    }
}