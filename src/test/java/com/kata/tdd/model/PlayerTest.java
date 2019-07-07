package com.kata.tdd.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    @Test
    @DisplayName("When Player score a point then player scored point should be increment by 1")
    public void whenPlayerScorePointThenPlayerScoredPointShouldBeIncrementedByOne(){
        Player player = new Player("Tom");
        int previousScoredPoint = player.getScoredPoint();

        player.incrementPlayerScore();

        assertEquals(previousScoredPoint+1, player.getScoredPoint());
    }
}
