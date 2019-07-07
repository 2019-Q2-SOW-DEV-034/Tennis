package com.kata.tdd;

import com.kata.tdd.model.Player;

public class TennisGame {

    private static final String[] score = {"Love", "Fifteen", "Thirty","Forty"};

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
        } else if (playerOne.getScoredPoint() >= 4 && (playerOne.getScoredPoint() - playerTwo.getScoredPoint() >= 2)) {
            return "Player1 won the game";
        } else if (playerTwo.getScoredPoint() >= 4 && (playerTwo.getScoredPoint() - playerOne.getScoredPoint() >= 2)) {
            return "Player2 won the game";
        } else {
            return score[playerOne.getScoredPoint()] + "-" + score[playerTwo.getScoredPoint()];
        }
    }
}
