package tictactoe.Moves;

import tictactoe.Table.Table;

import java.util.Random;

public class EasyMode extends Table {

    public static void easyMove(int player) {
        System.out.println("Making move level \"easy\"");

        Random random = new Random();
        int x, y;
        char symbol = ' ';

        switch (player) {
            case 1:
                symbol = 'X';
                break;
            case 2:
                symbol = 'O';
                break;
        }

        do {
            x = random.nextInt(3);
            y = random.nextInt(3);
        } while (table[x][y] != ' ');

        table[x][y] = symbol;

        printTable();
    }
}
