package example;


//method for capturing stones from an opponent’s pit and adding them to their own pit.

public class Players {


    public static void player1 (NewBoard board, Players player, int pit) {

            int stones = board.getStones(pit);
            board.setStones(pit, 0);

            while (stones > 0) {
                pit++;
                if (pit == 13) {
                    pit = 0;
                }
                if (pit == 6) {
                    pit++;
                }
                board.addStone(pit);
                stones--;
            }

        }



        public static void player2 (NewBoard board, Players player, int pit) {

            int stones = board.getStones(pit);
            board.setStones(pit, 0);

            while (stones > 0) {

                pit++;

                if (pit == 14) {
                    pit = 0;
                }
                if (pit == 13) {
                    pit++;
                }
                board.addStone(pit);
                stones--;
            }

        }
}

