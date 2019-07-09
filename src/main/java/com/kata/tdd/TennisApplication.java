package com.kata.tdd;

import com.kata.tdd.controller.TennisGame;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TennisApplication {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Welcome!! Are you ready to play Tennis! \r\nPlease enter the player1 name");
        String playerOneName = inputScanner.nextLine();

        System.out.println("Please enter the player2 name");
        String playerTwoName = inputScanner.nextLine();

        launchTennisGame(inputScanner, playerOneName, playerTwoName);

        System.out.println("Game Over !!");
    }

    private static void launchTennisGame(Scanner inputScanner, String playerOneName, String playerTwoName) {
        int winningIndicator;
        String gameScore;

        final String winningIndicatorSysOutMessage = new StringBuilder("Press [1] to indicate '")
                .append(playerOneName).append("' win the current service or Press [2] to indicate '")
                .append(playerTwoName).append("' win the current service or Press any other key to quit the game").toString();

        TennisGame tennisGame = new TennisGame(playerOneName, playerTwoName);
        System.out.println("Lets start the game !!");
        do {
            System.out.println(winningIndicatorSysOutMessage);

            try {
                winningIndicator = inputScanner.nextInt();
                gameScore = tennisGame.getCurrentServiceGameScore(winningIndicator);
            } catch (InputMismatchException | IllegalArgumentException exception) {
                System.out.println("Exception:" + exception.getMessage());
                break;
            }
            System.out.println("Current Game score: " + gameScore);
        } while (isGameInProgress(gameScore));
    }

    private static boolean isGameInProgress(String gameScore) {
        return !gameScore.endsWith("won the game");
    }
}
