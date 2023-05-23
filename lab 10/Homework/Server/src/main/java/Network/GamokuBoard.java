package Network;

public class GamokuBoard {
    public static final char EMPTY = ' ';

    private char[][] board;
    private static final int BOARD_SIZE = 15;

    public GamokuBoard() {
        board = new char[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public boolean makeMove(int row, int col, char playerSymbol) {
        if (row < 0 || row >= BOARD_SIZE || col < 0 || col >= BOARD_SIZE) {
            return false;
        }
        if (board[row][col] != ' ') {
            return false;
        }
        board[row][col] = playerSymbol;
        return true;
    }

    public boolean isFull() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasWinner(int row, int col, char playerSymbol) {
        int count = 0;
        // verificăm pe orizontală
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[row][i] == playerSymbol) {
                count++;
            } else {
                count = 0;
            }
            if (count == 5) {
                return true;
            }
        }
        count = 0;
        // verificăm pe verticală
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i][col] == playerSymbol) {
                count++;
            } else {
                count = 0;
            }
            if (count == 5) {
                return true;
            }
        }
        count = 0;
        // verificăm pe diagonală
        int delta = Math.min(row, col);
        int i = row - delta;
        int j = col - delta;
        while (i < BOARD_SIZE && j < BOARD_SIZE) {
            if (board[i][j] == playerSymbol) {
                count++;
            } else {
                count = 0;
            }
            if (count == 5) {
                return true;
            }
            i++;
            j++;
        }
        count = 0;
        // verificăm pe cealaltă diagonală
        delta = Math.min(row, BOARD_SIZE - 1 - col);
        i = row - delta;
        j = col + delta;
        while (i < BOARD_SIZE && j >= 0) {
            if (board[i][j] == playerSymbol) {
                count++;
            } else {
                count = 0;
            }
            if (count == 5) {
                return true;
            }
            i++;
            j--;
        }
        return false;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
    public Character getStone(int x, int y) {
        if (x < 0 || x >= 15 || y < 0 || y >= 15) {
            return null;
        }
        return board[x][y];
    }

    public void setStone(int x, int y, char color) {
        board[x][y] = color;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("  ");
        for (int j = 0; j < BOARD_SIZE; j++) {
            sb.append(j).append(" ");
        }
        sb.append("\n");
        for (int i = 0; i < BOARD_SIZE; i++) {
            sb.append(i).append(" ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
