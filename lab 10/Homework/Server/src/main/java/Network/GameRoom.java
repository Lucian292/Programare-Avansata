package Network;

import app.SimpleServer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public class GameRoom {
    private final int ROOM_ID;
    private final String ROOM_NAME;
    private final Player[] players;
    private int currentPlayerIndex;
    private boolean gameStarted;
    private final GamokuBoard board;
    private boolean gameFinished;
    private final Random random;
    private GameRoom[] rooms = new GameRoom[50];

    public GameRoom(Socket player1Socket) throws IOException {
        this.ROOM_ID = SimpleServer.getNextRoomID();
        this.ROOM_NAME = "Room " + ROOM_ID;
        this.players = new Player[2];
        this.players[0] = new Player(player1Socket);
        this.currentPlayerIndex = 0;
        this.gameStarted = false;
        this.board = new GamokuBoard();
        this.gameFinished = false;
        this.random = new Random();
        rooms[ROOM_ID] = this;
        System.out.println("Created room " + ROOM_ID);
    }

    public void addPlayer(Socket player2Socket) throws IOException {
        players[1] = new Player(player2Socket);
    }

    public synchronized GameRoom getAvailableGameRoom() {
        for (GameRoom room : rooms) {
            if (room != null && room.getNumberOfPlayers() < 2) {
                return room;
            }
        }
        return null;
    }

    public int getNumberOfPlayers() {
        int count = 0;
        for (Player player : players) {
            if (player != null) {
                count++;
            }
        }
        return count;
    }
    public String getPlayers() {
        String playersInRoom = "";
        for (Player player : players) {
            if (player != null) {
                playersInRoom = player.getSocket().toString();
            }
        }
        return playersInRoom;
    }
    public void removePlayer(Socket playerSocket) {
        for (int i = 0; i < players.length; i++) {
            if (players[i] != null && players[i].getSocket().equals(playerSocket)) {
                players[i] = null;
                break;
            }
        }
    }

    public boolean isPlayerTurn(Socket playerSocket) {
        return players[currentPlayerIndex].getSocket().equals(playerSocket);
    }

    public void startGame() {
        gameStarted = true;
        players[0].sendMessage("gamestart b");
        players[1].sendMessage("gamestart w");
    }

    public String makeMove(String move) {
        int x, y;
        try {
            String[] coordinates = move.split(",");
            x = Integer.parseInt(coordinates[0]);
            y = Integer.parseInt(coordinates[1]);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            return "Invalid move";
        }

        if (board.getStone(x, y) != GamokuBoard.EMPTY) {
            return "Invalid move";
        }

        char color = (currentPlayerIndex == 0) ? 'b' : 'w';
        board.setStone(x, y, color);
        players[0].sendMessage("move " + move + " " + color);
        players[1].sendMessage("move " + move + " " + color);

        if (board.hasWinner(x, y, color)) {
            gameFinished = true;
            String winnerColor = (currentPlayerIndex == 0) ? "Black" : "White";
            return winnerColor + " wins!";
        }

        if (board.isBoardFull()) {
            gameFinished = true;
            return "Draw";
        }

        currentPlayerIndex = (currentPlayerIndex + 1) % 2;

        String nextPlayerColor = (currentPlayerIndex == 0) ? "b" : "w";
        players[currentPlayerIndex].sendMessage("next " + nextPlayerColor);

        return "";
    }
}