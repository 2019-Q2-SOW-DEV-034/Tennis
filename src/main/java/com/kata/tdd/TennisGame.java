package com.kata.tdd;

public class TennisGame {

    private int playerOneScoredPoint;
    private int playerTwoScoredPoint;

    private String playerOneName;

    public TennisGame(){
        playerOneName = "Player1";
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
}
