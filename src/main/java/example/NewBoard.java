package example;


/**Creating a new board object with a constructor that takes an integer size as a
parameter. It initializes the board array with six stones in each pit except for the two big pits
6 & 13 which are initialized to zero.
 It also contains methods for getting and setting the number of stones in a pit and adding stones to a pit.
 The getBoard() method returns the board array.**/

public class NewBoard {
        private final int[] board;

        public NewBoard() {
            board = new int[14];
            for (int i = 0; i < 14; i++) {
                if (i == 6 || i == 13) {
                    board[i] = 0;
                } else {
                    board[i] = 6;
                }
            }
        }

        public int getStones(int pit) {
            return board[pit];
        }

        public void setStones(int pit, int stones) {
            board[pit] = stones;
        }

        public void addStone(int pit) {
            board[pit]++;
        }


    /** Method takes two parameters pit = index of the pit where player starts, and player =
     the player making the move. Method gets the number of stones in the starting pit and
     sets the starting pit to zero. If the last stone lands in an empty pit on the player’s side of the
     board and there are stones in the opposite pit, those stones are captured and added to the player’s
     big pit*/
    public void moveStones(int pit, int player) {
        int stones = board[pit];
        board[pit] = 0;
        while (stones > 0) {
            pit++;
            if (pit == 14) {
                pit = 0;
            }
            if ((player == 1 && pit == 13) || (player == 2 && pit == 6)) {
                continue;
            }
            board[pit]++;
            stones--;
        }
        if (player == 1 && pit <= 5 && board[pit] == 1 || player == 2 && pit >= 7 && pit <= 12 && board[pit] == 1) {
            int oppositePit = 12 - pit;
            if (board[oppositePit] > 0) {
                if (player == 1) {
                    board[6] += board[oppositePit] + 1;
                } else {
                    board[13] += board[oppositePit] + 1;
                }
                board[oppositePit] = 0;
                board[pit] = 0;
            }
        }
    }


    /** If player 1 has more stones in their big pit (index 6), then player 1 wins, method returns 1.
     If player 2 has more stones in their big pit (index 13), then player 2 wins, method returns 2.
     If both players have the same number of stones in their big pits, it's a tie and method
     returns 0.*/
    public int getWinner() {
        if (board[6] > board[13]) {
            return 1;
        } else if (board[13] > board[6]) {
            return 2;
        } else {
            return 0;
        }
    }


    /** Method returns true if the game is over and false if not. It calculates the
     sum of the stones in each player’s pits and returns true if either sum is equal to zero.*/
    public boolean isGameOver() {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < board.length; i++) {
            if (i != 6 && i != 13) {
                if (i < 6) {
                    sum1 += board[i];
                } else {
                    sum2 += board[i];
                }
            }
        }
        return sum1 == 0 || sum2 == 0;
    }
}





//        NewBoard newBoard = new NewBoard(14);
//        int[] board = newBoard.getBoard();

