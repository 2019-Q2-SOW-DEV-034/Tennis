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
        } else if (isGameWonByAnyPlayer()){
            return getTopScorerName() + " won the game";
        } else {
            return score[playerOne.getScoredPoint()] + "-" + score[playerTwo.getScoredPoint()];
        }
    }

    private boolean isGameWonByAnyPlayer(){
        return (playerOne.getScoredPoint() >= 4 || playerTwo.getScoredPoint() >= 4) && (Math.abs(playerOne.getScoredPoint() - playerTwo.getScoredPoint())>=2);
    }

    private String getTopScorerName() {
        return playerOne.getScoredPoint() > playerTwo.getScoredPoint() ? playerOne.getName() : playerTwo.getName();
    }
}
