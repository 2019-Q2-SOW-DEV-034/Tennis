package com.kata.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TennisGameTest {

    @Test
    @DisplayName("When the Tennis Game start, player one scored point should be equal to zero")
    public void whenTheGameStartsPlayerOneScoredPointShouldBeEqualToZero(){
        TennisGame tennisGame = new TennisGame();

        assertEquals(0, tennisGame.getPlayerOneScoredPoint());
    }
}
