package com.kata.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TennisGameTest {

    @Test
    @DisplayName("When the Tennis Game start, player one scored point should be equal to zero")
    public void whenTheGameStartsPlayerOneScoredPointShouldBeEqualToZeroTest(){
        TennisGame tennisGame = new TennisGame();

        assertEquals(0, tennisGame.getPlayerOneScoredPoint());
    }

    @Test
    @DisplayName("When the Tennis Game start, player two scored point should be equal to zero")
    public void whenTheGameStartsPlayerTwoScoredPointShouldBeEqualToZeroTest(){
        TennisGame tennisGame = new TennisGame();

        assertEquals(0, tennisGame.getPlayerTwoScoredPoint());
    }

    @Test
    @DisplayName("When the Tennis Game start, player one name should be initialized as 'Player1'")
    public void whenTheGameStartsPlayerOneNameShouldBeInitializedAsPlayer1Test(){
        TennisGame tennisGame = new TennisGame();

        assertEquals("Player1", tennisGame.getPlayerOneName());
    }
}
