package com.kata.tdd;

import com.kata.tdd.model.Player;

public class TennisGame {

    private Player playerOne;
    private Player playerTwo;

    public TennisGame(){
        playerOne = new Player("Player1");
        playerTwo = new Player("Player2");
    }

    protected Player getPlayerOne() {
        return playerOne;
    }

    protected Player getPlayerTwo() {
        return playerTwo;
    }

    public String calculateGameScore() {
        return "Love-All";
    }
}
