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
        if (isScoresAreEqual()) {
            return isMinimumDeucePointScored() ? DEUCE : score[playerOne.getScoredPoint()] + HYPHEN_ALL;
        } else if (isGameWonByAnyPlayer()){
            return getTopScorerName() + WON_THE_MATCH;
        } else if (isAdvantage()) {
            return getTopScorerName() + HAS_ADVANTAGE;
        } else {
            return score[playerOne.getScoredPoint()] + HYPHEN + score[playerTwo.getScoredPoint()];
        }
    }

    private boolean isScoresAreEqual() {
        return playerOne.getScoredPoint() == playerTwo.getScoredPoint();
    }

    private boolean isMinimumDeucePointScored() {
        return playerOne.getScoredPoint() >= MINIMUM_DEUCE_POINT;
    }

    private boolean isGameWonByAnyPlayer(){
        return (playerOne.getScoredPoint() >= MINIMUM_WINNING_SCORE || playerTwo.getScoredPoint() >= MINIMUM_WINNING_SCORE)
                && (Math.abs(playerOne.getScoredPoint() - playerTwo.getScoredPoint())>= MINIMUM_WINNING_DIFFERENCE_POINT);
    }

    private boolean isAdvantage() {
        return (playerOne.getScoredPoint() >= MINIMUM_WINNING_SCORE || playerTwo.getScoredPoint() >= MINIMUM_WINNING_SCORE)
                && (Math.abs(playerOne.getScoredPoint() - playerTwo.getScoredPoint()) == ADVANTAGE_DIFFERENCE_POINT);
    }

    private String getTopScorerName() {
        return playerOne.getScoredPoint() > playerTwo.getScoredPoint() ? playerOne.getName() : playerTwo.getName();
    }
}
