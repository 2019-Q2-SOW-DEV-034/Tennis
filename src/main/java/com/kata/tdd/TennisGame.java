package com.kata.tdd;

import com.kata.tdd.model.Player;

public class TennisGame {

    private static final String[] score = {"Love", "Fifteen", "Thirty"};

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

    protected String calculateGameScore() {
        if (playerOne.getScoredPoint() == playerTwo.getScoredPoint()) {
            return score[playerOne.getScoredPoint()] + "-All";
        } else {
            return score[playerOne.getScoredPoint()] + "-" + score[playerTwo.getScoredPoint()];
        }
    }
}
