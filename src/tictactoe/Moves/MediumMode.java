package tictactoe.Moves;

import tictactoe.Table.Table;

import java.util.Random;

public class MediumMode extends Table {

    public static void mediumMove(int player) {
        System.out.println("Making move level \"medium\"");

        // which player is computer
        char symbol = ' ';
        char secondSymbol = ' ';

        switch (player) {
            case 1:
                symbol = 'X';
                secondSymbol = 'O';
                break;
            case 2:
                symbol = 'O';
                secondSymbol = 'X';
                break;
        }

        boolean isMoveMade = false;
        int[] move = new int[2];
        int[] coords = mediumMoveCoords(table, symbol);

        // win with one move
        if (coords[0] != -1) {
            move = coords;
            isMoveMade = true;
        }

        // block opponent
        if (!isMoveMade) {
            coords = mediumMoveCoords(table, secondSymbol);
            if (coords[0] != -1) {
                move = coords;
                isMoveMade = true;
            }
        }

        // random move
        Random random = new Random();
        int x, y;

        if (!isMoveMade) {
            do {
                x = random.nextInt(3);
                y = random.nextInt(3);
            } while (table[x][y] != ' ');

            table[x][y] = symbol;
        } else {
            table[move[0]][move[1]] = symbol;
        }

        printTable();
    }

    private static int[] mediumMoveCoords(char[][] table, char symbol) {
        int rowIndex = -1;
        int columnIndex = -1;

        // row and column index
        for (int i = 0; i < 3; i++) {
            if (table[i][0] == symbol && table[i][1] == symbol && table[i][2] == ' ') {
                rowIndex = i;
                columnIndex = 2;
            } else if (table[i][0] == symbol && table[i][1] == ' ' && table[i][2] == symbol) {
                rowIndex = i;
                columnIndex = 1;
            } else if (table[i][0] == ' ' && table[i][1] == symbol && table[i][2] == symbol) {
                rowIndex = i;
                columnIndex = 0;
            } else if (table[0][i] == symbol && table[1][i] == symbol && table[2][i] == ' ') {
                rowIndex = 2;
                columnIndex = i;
            } else if (table[0][i] == symbol && table[1][i] == ' ' && table[2][i] == symbol) {
                rowIndex = 1;
                columnIndex = i;
            } else if (table[0][i] == ' ' && table[1][i] == symbol && table[2][i] == symbol) {
                rowIndex = 0;
                columnIndex = i;
            }
        }

        // diagonals index
        if (table[0][0] == symbol && table[1][1] == symbol && table[2][2] == ' ') {
            rowIndex = 2;
            columnIndex = 2;
        } else if (table[0][0] == symbol && table[1][1] == ' ' && table[2][2] == symbol) {
            rowIndex = 1;
            columnIndex = 1;
        } else if (table[0][0] == ' ' && table[1][1] == symbol && table[2][2] == symbol) {
            rowIndex = 0;
            columnIndex = 0;
        } else if (table[0][2] == symbol && table[1][1] == symbol && table[2][0] == ' ') {
            rowIndex = 2;
            columnIndex = 0;
        } else if (table[0][2] == symbol && table[1][1] == ' ' && table[2][0] == symbol) {
            rowIndex = 1;
            columnIndex = 1;
        } else if (table[0][2] == ' ' && table[1][1] == symbol && table[2][0] == symbol) {
            rowIndex = 0;
            columnIndex = 2;
        }

        return new int[] {rowIndex, columnIndex};
    }
}