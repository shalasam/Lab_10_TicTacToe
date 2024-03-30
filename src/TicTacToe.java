import java.util.Scanner;

public class TicTacToe {
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String[][] board = new String[ROW][COL];
    private static String currentPlayer = "X"; // X always moves first
    private static boolean gameWon = false;
    private static boolean gameTied = false;
    private static Scanner scanner = new Scanner(System.in);

    // Other methods will go here

    public static void main(String[] args) {
        // Initialize the board
        clearBoard();
        display();

        // Main game loop
        while (!gameWon && !gameTied) {
            // Get coordinates for the move
            int rowMove = getMove("row");
            int colMove = getMove("column");

            // Convert player move coordinates to array indices
            int rowIdx = rowMove - 1;
            int colIdx = colMove - 1;

            // Check if the move is valid
            if (isValidMove(rowIdx, colIdx)) {
                // Update the board
                board[rowIdx][colIdx] = currentPlayer;

                // Display the updated board
                display();

                // Check for win or tie
                gameWon = isWin(currentPlayer);
                gameTied = isTie();

                // Toggle the player
                currentPlayer = currentPlayer.equals("X") ? "O" : "X";
            } else {
                // Invalid move, prompt the player to try again
                System.out.println("Invalid move. Please try again.");
            }
        }

        // Game over, announce the result
        if (gameWon) {
            System.out.println("Player " + currentPlayer + " wins!");
        } else if (gameTied) {
            System.out.println("It's a tie!");
        }

        // Prompt the players to play again
        boolean playAgain = SafeInput.getYNConfirm(scanner, "Play again? (Y/N)");
        if (playAgain) {
            main(null); // Restart the game
        } else {
            System.out.println("Thanks for playing!");
        }

        // Close the scanner
        scanner.close();
    }

    private static int getMove(String coordinate) {
        Scanner console = new Scanner(System.in);
        int move;

        do {
            System.out.print("Enter the " + coordinate + " number (1-3): ");
            move = SafeInput.getRangedInt(console, "", 1, 3); // Using SafeInput method for input validation

            if (move < 1 || move > 3) {
                System.out.println("Invalid " + coordinate + " number. Please enter a number between 1 and 3.");
            }
        } while (move < 1 || move > 3);

        return move;
    }

    private static void clearBoard() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                board[i][j] = " ";
            }
        }
    }
    private static void display() {
        System.out.println("-------------");
        for (int i = 0; i < ROW; i++) {
            System.out.print("| ");
            for (int j = 0; j < COL; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }
    private static boolean isValidMove(int row, int col) {
        return board[row][col].equals(" ");
    }
    private static boolean isWin(String player) {
        return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
    }
    private static boolean isRowWin(String player) {
        for (int i = 0; i < ROW; i++) {
            if (board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) {
                return true;
            }
        }
        return false;
    }
    private static boolean isColWin(String player) {
        for (int i = 0; i < COL; i++) {
            if (board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player)) {
                return true;
            }
        }
        return false;
    }
    private static boolean isDiagonalWin(String player) {
        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) ||
                (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
    }
    private static boolean isTie() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (board[i][j].equals(" ")) {
                    return false; // There is still an empty cell, game is not tied
                }
            }
        }
        return true; // All cells are filled, game is tied
    }
}