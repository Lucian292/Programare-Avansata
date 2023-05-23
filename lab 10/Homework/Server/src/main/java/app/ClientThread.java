package app;

import Network.GameRoom;
import Network.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;

class ClientThread extends Thread {
    private Socket socket = null;
    public GameRoom globalRoom;
    private boolean gameStarted = false;
    private Boolean running = true;

    public ClientThread(Socket socket) {
        this.socket = socket;
        //Player player = new Player(socket);
    }

    //Player player = new Player(socket);
    public void run() {
        GameRoom currentRoom = null;
        try {

            //socket.setSoTimeout(60 * 1000);
            System.out.println("Conectat la serverul de jocuri");

            while (running) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

                String request = in.readLine();

                System.out.println("Cerere: " + request);

                String response = "";

                if (request != null) {
                    String[] command = request.trim().toLowerCase().split(" ");

                    switch (command[0]) {
                        case "create":
                            response = createGame();
                            break;
                        case "join":
                            response = joinGame(socket);
                            break;
                        case "start":
                            response = startGame();
                            break;
                        case "submit":
                            response = submitMove(command[1]);
                            break;
                        case "exit":
                            running = false;
                            response = "exit";
                            break;
                        default:
                            response = "Comanda incorecta";
                            break;
                    }
                }

                PrintWriter out = new PrintWriter(socket.getOutputStream());
                out.println(response);
                out.flush();
            }

        } /*catch (SocketTimeoutException e) {
            System.err.println("Utilizatorul a fost inactiv prea mult timp");
        }*/ catch (IOException e) {
            System.err.println("Eroare de comunicare... " + e);
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
                if (currentRoom != null) {
                    currentRoom.removePlayer(socket);
                    if (currentRoom.getNumberOfPlayers() == 0) {
                        SimpleServer.removeGameRoom(currentRoom);
                    }
                }
                System.out.println("Conexiune inchisa");
            } catch (IOException e) {
                System.err.println("Eroare la inchiderea conexiunii... " + e);
            }
        }
    }


    private synchronized String createGame() throws IOException {
        GameRoom currentRoom = globalRoom;
        if (currentRoom == null) {
            currentRoom = new GameRoom(socket);
            globalRoom = currentRoom;
            System.out.println("A fost creata camera " + globalRoom);
            return "Joc creat cu succes!";
        } else {
            return "Sunteti deja intr-un joc!";
        }
    }


    private String joinGame(Socket socket) throws IOException {
        GameRoom currentRoom = globalRoom;
        if (currentRoom != null/* && (currentRoom.getNumberOfPlayers() == 1 || currentRoom.getNumberOfPlayers()==0)*/) {
            GameRoom availableRoom = currentRoom.getAvailableGameRoom();
            System.out.println("a fost gasita camera " + currentRoom);
            if (availableRoom != null) {
                currentRoom.addPlayer(socket);
                System.out.println("s-a intrat in camera " + currentRoom);
                return "S-a intrat in joc cu succes!";
            } else {
                return "Nu sunt camere de joc disponibile momentan.";
            }
        } else {
            System.out.println("sunteti deja intr-un joc impreuna cu "+ currentRoom.getPlayers());
            return "Sunteti deja intr-un joc!";
        }
    }

    private String startGame() {
        GameRoom currentRoom = globalRoom;
        if (currentRoom != null && currentRoom.getNumberOfPlayers() == 2 && !gameStarted) {
            gameStarted = true;
            currentRoom.startGame();
            return "Jocul a inceput!";
        } else {
            return "Nu sunt suficienti jucatori sau jocul a inceput deja!";
        }
    }

    private String submitMove(String move) {
        GameRoom currentRoom = globalRoom;
        if (gameStarted && currentRoom != null && currentRoom.isPlayerTurn(socket)) {
            String result = currentRoom.makeMove(move);
            return result;
        } else {
            return "Nu este randul tau sau jocul nu a inceput!";
        }
    }
}