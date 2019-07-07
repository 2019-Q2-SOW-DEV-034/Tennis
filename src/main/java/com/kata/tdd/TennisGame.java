package com.kata.tdd;

public class TennisGame {

    private int playerOneScoredPoint;
    private int playerTwoScoredPoint;

    private String playerOneName;
    private String playerTwoName;

    public TennisGame(){
        playerOneName = "Player1";
        playerTwoName = "Player2";
    }

    protected int getPlayerOneScoredPoint() {
        return playerOneScoredPoint;
    }

    protected int getPlayerTwoScoredPoint() {
        return playerTwoScoredPoint;
    }

    protected String getPlayerOneName() {
        return playerOneName;
    }

    protected String getPlayerTwoName() {
        return playerTwoName;
    }
}
