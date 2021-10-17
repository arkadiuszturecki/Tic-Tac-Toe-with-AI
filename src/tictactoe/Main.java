package tictactoe;

import tictactoe.Moves.*;
import tictactoe.Table.Table;

import java.util.Scanner;

public abstract class Main extends Table {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean appIsOn = true;
        boolean gameIsOn;

        while (appIsOn) {
            System.out.print("Input command: ");
            String inputCommand = scanner.nextLine();
            String startLevel = "";
            String player1 = "";
            String player2 = "";

            if (inputCommand.split(" ").length == 1) {
                startLevel = inputCommand.split(" ")[0];
            }

            if (inputCommand.split(" ").length == 3) {
                startLevel = inputCommand.split(" ")[0];
                player1 = inputCommand.split(" ")[1];
                player2 = inputCommand.split(" ")[2];
            }

            boolean badParameters = false;
            switch (startLevel) {
                case "start":
                    gameIsOn = true;
                    for (String player : new String[]{player1, player2}) {
                        switch (player) {
                            case "easy":
                            case "medium":
                            case "hard":
                            case "user":
                                gameIsOn = true;
                                break;
                            default:
                                badParameters = true;
                                gameIsOn = false;
                        }
                    }
                    break;
                case "exit":
                    gameIsOn = false;
                    appIsOn = false;
                    badParameters = false;
                    break;
                default:
                    gameIsOn = false;
                    badParameters = true;
            }

            if (badParameters) {
                System.out.println("Bad parameters!");
                gameIsOn = false;
            }

            startEmptyTable();

            if (gameIsOn) {
                printTable();
            }

            while (gameIsOn) {
                switch (player1) {
                    case "easy":
                        EasyMode.easyMove(1);
                        break;
                    case "medium":
                        MediumMode.mediumMove(1);
                        break;
                    case "hard":
                        HardMode.hardMove(1);
                        break;
                    case "user":
                        PlayerMove.move(1);
                        break;
                }

                gameIsOn = GameResult.whoWins(table);
                if (!gameIsOn) {
                    break;
                }

                switch (player2) {
                    case "easy":
                        EasyMode.easyMove(2);
                        break;
                    case "medium":
                        MediumMode.mediumMove(2);
                        break;
                    case "hard":
                        HardMode.hardMove(2);
                        break;
                    case "user":
                        PlayerMove.move(2);
                        break;
                }

                gameIsOn = GameResult.whoWins(table);
                if (!gameIsOn) {
                    break;
                }
            }
        }
    }
}
