package tictactoe;

public class GameResult {

    public static boolean whoWins(char[][] table) {
        //print result of game
        boolean xWins = false;
        boolean oWins = false;
        boolean draw = false;
        int xCounter = 0;
        int oCounter = 0;
        boolean gameIsOn = true;

        for (int i = 0; i < 3; i++) {
            // rows
            if (table[i][0] == table[i][1] && table[i][1] == table[i][2]) {
                if (table[i][0] == 'X') {
                    xWins = true;
                    System.out.println("X wins");
                } else if (table[i][0] == 'O') {
                    oWins = true;
                    System.out.println("O wins");
                }
            }
            // columns
            if (table[0][i] == table[1][i] && table[1][i] == table[2][i]) {
                if (table[0][i] == 'X') {
                    xWins = true;
                    System.out.println("X wins");
                } else if (table[0][i] == 'O') {
                    oWins = true;
                    System.out.println("O wins");
                }
            }
        }

        // diagonals
        if ((table[0][0] == table[1][1] && table[1][1] == table[2][2]) || (table[0][2] == table[1][1] && table[1][1] == table[2][0])) {
            if (table[1][1] == 'X') {
                xWins = true;
                System.out.println("X wins");
            } else if (table[1][1] == 'O') {
                oWins = true;
                System.out.println("O wins");
            }
        }

        // X and O counter
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (table[i][j] == 'X') {
                    xCounter++;
                } else if (table[i][j] == 'O') {
                    oCounter++;
                }
            }
        }

        // draw
        if (((!xWins && !oWins) || (xWins && oWins)) && ((xCounter == 4 && oCounter == 5) || (xCounter == 5 && oCounter == 4))) {
            draw = true;
            System.out.println("Draw");
        }

        // end of game
        if (xWins || oWins || draw) {
            gameIsOn = false;
        }

        return gameIsOn;
    }
}
