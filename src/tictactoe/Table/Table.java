package tictactoe.Table;

import java.util.Arrays;

public class Table {

    protected static char[][] table = new char[3][3];

    protected static void startEmptyTable() {
        for (char[] chars : table) {
            Arrays.fill(chars, ' ');
        }
    }

    protected static void printTable() {
        System.out.println("---------");
        System.out.println("| " + table[0][0] + ' ' + table[0][1] + ' ' + table[0][2] + " |");
        System.out.println("| " + table[1][0] + ' ' + table[1][1] + ' ' + table[1][2] + " |");
        System.out.println("| " + table[2][0] + ' ' + table[2][1] + ' ' + table[2][2] + " |");
        System.out.println("---------");
    }
}
