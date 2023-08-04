package example;

import java.util.Scanner;

/** created new board and player objects and looped through the game.
 * added exception to cash outofbound error */

public class PlayTheGame {

    public static <e> void main(String[] args) {

        NewBoard board = new NewBoard();
        Players player1 = new Players();
        Players player2 = new Players();

        int currentPlayer = 1;

        while (!board.isGameOver()) {
            System.out.println("Player " + currentPlayer + "'s turn");
            System.out.println("Current board:");
            for (int i = 0; i < 14; i++) {
                System.out.print(board.getStones(i) + " ");
            }
            System.out.println();
            Scanner input = new Scanner(System.in);
            System.out.print("Choose a pit to move stones from: ");
            try {
                int pit = input.nextInt();
                board.moveStones(pit, currentPlayer);
            } catch ( Exception e){
                System.out.println("Invalid input. Please enter a " +
                        "number between 0 and 6.");
                if (currentPlayer == 1) {
                    currentPlayer = 2;
                } else {
                    currentPlayer = 1;
                }
            }
        }
        int winner = board.getWinner();
        if (winner == 0) {
            System.out.println("It's a tie!");
        } else {
            System.out.println("Player " + winner + " wins!");
        }
    }

}

