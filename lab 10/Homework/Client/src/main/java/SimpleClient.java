import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class SimpleClient {
    public static void main(String[] args) throws IOException {
        String serverAddress = "127.0.0.1";
        int PORT = 8100;
        Boolean running = true;
        try (
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter out =
                        new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(System.in))
        ) {
            while (running) {
                String request = reader.readLine();

                out.println(request);
                out.flush();

                String response = in.readLine();

                if (response.equals("exit"))
                    running = false;

                System.out.println(response);
            }
        } catch (ConnectException e) {
            System.err.println("Serverul este oprit");
        } catch (SocketException e) {
            System.err.println("Ai fost deconectat pentru ca a trecut prea mult timp fara nici o comanda");
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }
}