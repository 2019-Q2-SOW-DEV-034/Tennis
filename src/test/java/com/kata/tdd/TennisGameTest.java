package com.kata.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TennisGameTest {

    private TennisGame tennisGame;

    @BeforeEach
    public void initializeBeforeEachMethod(){
        tennisGame = new TennisGame();
    }


    @Test
    @DisplayName("When the Tennis Game start, player one scored point should be equal to zero")
    public void whenTheGameStartsPlayerOneScoredPointShouldBeEqualToZeroTest(){
        assertEquals(0, tennisGame.getPlayerOne().getScoredPoint());
    }

    @Test
    @DisplayName("When the Tennis Game start, player two scored point should be equal to zero")
    public void whenTheGameStartsPlayerTwoScoredPointShouldBeEqualToZeroTest(){
        assertEquals(0, tennisGame.getPlayerTwo().getScoredPoint());
    }

    @Test
    @DisplayName("When the Tennis Game start, player one name should be initialized as 'Player1'")
    public void whenTheGameStartsPlayerOneNameShouldBeInitializedAsPlayer1Test(){
        assertEquals("Player1", tennisGame.getPlayerOne().getName());
    }

    @Test
    @DisplayName("When the Tennis Game start, player two name should be initialized as 'Player2'")
    public void whenTheGameStartsPlayerTwoNameShouldBeInitializedAsPlayer2Test(){
        assertEquals("Player2", tennisGame.getPlayerTwo().getName());
    }

    @Test
    @DisplayName("When the Tennis Game starts, current game score should be equal to 'Love-All'")
    public void whenTheGameStartsGameScoreShouldBeEqualToLoveAllTest(){
        assertEquals("Love-All", tennisGame.calculateGameScore());
    }
}
