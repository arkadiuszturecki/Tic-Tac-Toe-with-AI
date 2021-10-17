package tictactoe.Moves;

import tictactoe.Table.Table;

import java.util.ArrayList;
import java.util.List;

public class HardMode extends Table {

    public static void hardMove(int player) {
        System.out.println("Making move level \"hard\"");

        char symbol = ' ';

        switch (player) {
            case 1:
                symbol = 'X';
                break;
            case 2:
                symbol = 'O';
                break;
        }

        HardMove bestMove = minimax(table, player, player);

        table[bestMove.index[0]][bestMove.index[1]] = symbol;

        printTable();
    }

    private static HardMove minimax(char[][] table, int firstPLayerV, int secondPlayerV) {
        char huPlayer = ' ';
        char aiPlayer = ' ';
        char symbol = ' ';
        int humanNumber = 0;

        if (firstPLayerV == 1) {
            aiPlayer = 'X';
            huPlayer = 'O';
        } else if (firstPLayerV == 2) {
            huPlayer = 'X';
            aiPlayer = 'O';
        }

        if (secondPlayerV == 1) {
            symbol = 'X';
            humanNumber = 2;
        } else if (secondPlayerV == 2) {
            symbol = 'O';
            humanNumber = 1;
        }

        int[][] availSpots = emptyIndexes(table);

        if (winning(table, huPlayer)) {
            return new HardMove(-10);
        } else if (winning(table, aiPlayer)) {
            return new HardMove(10);
        } else if (!checkEmptyIndexes(table)){
            return new HardMove(0);
        }

        List<HardMove> moves = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (availSpots[i][j] == 1) {
                    HardMove move = new HardMove();
                    move.index = new int[]{i, j};
                    table[i][j] = symbol;
                    HardMove result = minimax(table, firstPLayerV, humanNumber);
                    move.score = result.score;
                    table[i][j] = ' ';
                    moves.add(move);
                }
            }
        }

        int bestMove = 0;

        if (secondPlayerV == firstPLayerV) {
            int bestScore = -10000;
            for (int i = 0; i < moves.size(); i++) {
                if (moves.get(i).score > bestScore) {
                    bestScore = moves.get(i).score;
                    bestMove = i;
                }
            }
        } else {
            int bestScore = 10000;
            for (int i = 0; i < moves.size(); i++) {
                if (moves.get(i).score < bestScore) {
                    bestScore = moves.get(i).score;
                    bestMove = i;
                }
            }
        }

        return moves.get(bestMove);
    }

    private static int[][] emptyIndexes(char[][] table) {
        int[][] tableEmptyIndexes = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (table[i][j] == ' ') {
                    tableEmptyIndexes[i][j] = 1;
                } else {
                    tableEmptyIndexes[i][j] = 0;
                }
            }
        }
        return tableEmptyIndexes;
    }

    private static boolean checkEmptyIndexes(char[][] table) {
        boolean emptyIndexes = false;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (table[i][j] == ' ') {
                    emptyIndexes = true;
                    break;
                }
            }
        }

        return emptyIndexes;
    }

    private static boolean winning(char[][] table, char player) {
        // all possibilities of winning game
        return (table[0][0] == player && table[0][1] == player && table[0][2] == player) ||
                (table[1][0] == player && table[1][1] == player && table[1][2] == player) ||
                (table[2][0] == player && table[2][1] == player && table[2][2] == player) ||
                (table[0][0] == player && table[1][0] == player && table[2][0] == player) ||
                (table[0][1] == player && table[1][1] == player && table[2][1] == player) ||
                (table[0][2] == player && table[1][2] == player && table[2][2] == player) ||
                (table[0][0] == player && table[1][1] == player && table[2][2] == player) ||
                (table[0][2] == player && table[1][1] == player && table[2][0] == player);
    }
}

class HardMove {
    int[] index;
    int score;

    HardMove() {
    }

    HardMove(int s) {
        score = s;
    }
}