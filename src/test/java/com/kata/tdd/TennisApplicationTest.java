package com.kata.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TennisApplicationTest {
    private static final String NEW_LINE = System.getProperty("line.separator");
    private static final String PLAYER_ONE_NAME = "Tom";
    private static final String PLAYER_TWO_NAME = "John";

    private static final String WINNING_INDICATOR_MESSAGE = new StringBuilder("Press [1] to indicate '")
            .append(PLAYER_ONE_NAME).append("' win the current service or Press [2] to indicate '")
            .append(PLAYER_TWO_NAME).append("' win the current service or Press any other key to quit the game")
            .append(NEW_LINE).toString();

    @Test
    @DisplayName("Tennis Application should provide user to play the tennis game till the end through the console")
    public void tennisApplicationShouldAllowUserToTestTennisGameViaConsole() {


        final StringBuilder expectedValueBuilder = new StringBuilder("Welcome!! Are you ready to play Tennis! ")
                .append(NEW_LINE).append("Please enter the player1 name").append(NEW_LINE)
                .append("Please enter the player2 name").append(NEW_LINE)
                .append("Lets start the game !!").append(NEW_LINE)
                .append(WINNING_INDICATOR_MESSAGE)
                .append("Current Game score: Fifteen-Love").append(NEW_LINE)
                .append(WINNING_INDICATOR_MESSAGE)
                .append("Current Game score: Thirty-Love").append(NEW_LINE)
                .append(WINNING_INDICATOR_MESSAGE)
                .append("Current Game score: Forty-Love").append(NEW_LINE)
                .append(WINNING_INDICATOR_MESSAGE)
                .append("Current Game score: Tom won the game").append(NEW_LINE)
                .append("Game Over !!").append(NEW_LINE);

        StringBuilder inputStreamBuilder = new StringBuilder(PLAYER_ONE_NAME).append(NEW_LINE)
                .append(PLAYER_TWO_NAME).append(NEW_LINE)
                .append(1).append(NEW_LINE).append(1).append(NEW_LINE).append(1).append(NEW_LINE).append(1).append(NEW_LINE);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        System.setIn(new ByteArrayInputStream(inputStreamBuilder.toString().getBytes()));

        TennisApplication.main(new String[]{});

        assertEquals(expectedValueBuilder.toString(), outputStream.toString());
    }

    @Test
    @DisplayName("Tennis Application should allow user to play the tennis game and quit through the console")
    public void tennisApplicationShouldAllowUserToTestTennisGameAndQuitViaConsole() {


        final StringBuilder expectedValueBuilder = new StringBuilder("Welcome!! Are you ready to play Tennis! ")
                .append(NEW_LINE).append("Please enter the player1 name").append(NEW_LINE)
                .append("Please enter the player2 name").append(NEW_LINE)
                .append("Lets start the game !!").append(NEW_LINE)
                .append(WINNING_INDICATOR_MESSAGE)
                .append("Exception:Winning indicator should be either 1 or 2").append(NEW_LINE)
                .append("Game Over !!").append(NEW_LINE);

        StringBuilder inputStreamBuilder = new StringBuilder(PLAYER_ONE_NAME).append(NEW_LINE)
                .append(PLAYER_TWO_NAME).append(NEW_LINE)
                .append(5).append(NEW_LINE);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        System.setIn(new ByteArrayInputStream(inputStreamBuilder.toString().getBytes()));

        TennisApplication.main(new String[]{});

        assertEquals(expectedValueBuilder.toString(), outputStream.toString());
    }
}
