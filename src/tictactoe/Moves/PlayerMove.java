package tictactoe.Moves;

import tictactoe.Table.Table;

import java.util.Scanner;

public class PlayerMove extends Table {
    private static final Scanner scanner = new Scanner(System.in);

    public static void move(int player) {
        //player's coords
        int pCoord1, pCoord2, tIndex1, tIndex2;
        boolean isMoveLegal = false;
        char symbol = ' ';

        switch (player) {
            case 1:
                symbol = 'X';
                break;
            case 2:
                symbol = 'O';
                break;
        }

        while(!isMoveLegal) {
            System.out.print("Enter the coordinates: ");

            // row index
            if (scanner.hasNextInt()) {
                pCoord1 = scanner.nextInt();
                tIndex1 = pCoord1 - 1;
            } else {
                scanner.nextLine();
                System.out.println("You should enter numbers!");
                continue;
            }

            // column index
            if (scanner.hasNextInt()) {
                pCoord2 = scanner.nextInt();
                tIndex2 = pCoord2 - 1;
            } else {
                scanner.nextLine();
                System.out.println("You should enter numbers!");
                continue;
            }

            if (tIndex1 < 0 || tIndex1 > 2 || tIndex2 < 0 || tIndex2 > 2) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            if (table[tIndex1][tIndex2] != ' ') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }

            isMoveLegal = true;

            table[tIndex1][tIndex2] = symbol;

            printTable();
        }
    }
}
