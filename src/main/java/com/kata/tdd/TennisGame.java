package com.kata.tdd;

import com.kata.tdd.model.Player;

import static com.kata.tdd.constants.TennisGameConstants.*;

public class TennisGame {

    private static final String[] score = {"Love", "Fifteen", "Thirty","Forty"};

    private Player playerOne;
    private Player playerTwo;

    public TennisGame(){
        playerOne = new Player(PLAYER_ONE_DEFAULT_NAME);
        playerTwo = new Player(PLAYER_TWO_DEFAULT_NAME);
    }

    protected Player getPlayerOne() {
        return playerOne;
    }

    protected Player getPlayerTwo() {
        return playerTwo;
    }

    protected String calculateGameScore() {
        if (playerOne.getScoredPoint() == playerTwo.getScoredPoint()) {
            if (playerOne.getScoredPoint() >= 3) {
                return "Deuce";
            } else {
                return score[playerOne.getScoredPoint()] + HYPHEN_ALL;
            }
        } else if (isGameWonByAnyPlayer()){
            return getTopScorerName() + WON_THE_MATCH;
        } else {
            return score[playerOne.getScoredPoint()] + HYPHEN + score[playerTwo.getScoredPoint()];
        }
    }

    private boolean isGameWonByAnyPlayer(){
        return (playerOne.getScoredPoint() >= MINIMUM_WINNING_SCORE || playerTwo.getScoredPoint() >= MINIMUM_WINNING_SCORE)
                && (Math.abs(playerOne.getScoredPoint() - playerTwo.getScoredPoint())>= MINIMUM_WINNING_DIFFERENCE_POINT);
    }

    private String getTopScorerName() {
        return playerOne.getScoredPoint() > playerTwo.getScoredPoint() ? playerOne.getName() : playerTwo.getName();
    }
}
