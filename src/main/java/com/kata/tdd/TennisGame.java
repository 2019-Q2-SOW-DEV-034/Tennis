package com.kata.tdd;

import com.kata.tdd.model.Player;

public class TennisGame {

    private int playerTwoScoredPoint;
    private String playerTwoName;

    private Player playerOne;

    public TennisGame(){
        playerOne = new Player();
        playerOne.setName("Player1");

        playerTwoName = "Player2";
    }

    protected Player getPlayerOne() {
        return playerOne;
    }

    protected int getPlayerTwoScoredPoint() {
        return playerTwoScoredPoint;
    }

    protected String getPlayerTwoName() {
        return playerTwoName;
    }
}
