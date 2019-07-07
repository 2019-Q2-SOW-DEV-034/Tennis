package com.kata.tdd;

import com.kata.tdd.model.Player;

public class TennisGame {

    private Player playerOne;
    private Player playerTwo;

    public TennisGame(){
        playerOne = new Player();
        playerOne.setName("Player1");

        playerTwo = new Player();
        playerTwo.setName("Player2");
    }

    protected Player getPlayerOne() {
        return playerOne;
    }

    protected Player getPlayerTwo() {
        return playerTwo;
    }
}
