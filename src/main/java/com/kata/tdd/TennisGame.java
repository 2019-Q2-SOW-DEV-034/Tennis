package com.kata.tdd;

import com.kata.tdd.model.Player;

import static com.kata.tdd.constants.TennisGameConstants.*;

public class TennisGame {

    private static final String[] score = {"Love", "Fifteen", "Thirty","Forty"};

    private Player playerOne;
    private Player playerTwo;

    public TennisGame(){
        this(PLAYER_ONE_DEFAULT_NAME, PLAYER_TWO_DEFAULT_NAME);
    }

    public TennisGame(String playerOneName, String playerTwoName) {
        playerOne = new Player(playerOneName);
        playerTwo = new Player(playerTwoName);
    }

    protected Player getPlayerOne() {
        return playerOne;
    }

    protected Player getPlayerTwo() {
        return playerTwo;
    }

    public String getCurrentServiceGameScore(int winningIndicator) {
        addCurrentServicePointToWinner(winningIndicator);
        return calculateGameScore();
    }

    protected void addCurrentServicePointToWinner(int winningIndicator) {

        switch (winningIndicator) {
            case PLAYER_ONE_WINNING_INDICATOR:
                playerOne.incrementPlayerScore();
                break;
            case PLAYER_TWO_WINNING_INDICATOR:
                playerTwo.incrementPlayerScore();
                break;
            default:
                throw new IllegalArgumentException("Winning indicator should be either 1 or 2");
        }
    }

    protected String calculateGameScore() {
        String gameScore;
        if (isScoresAreEqual()) {
            gameScore = isMinimumDeucePointScored() ? DEUCE : score[playerOne.getScoredPoint()] + HYPHEN_ALL;
        } else if (isAnyPlayerEligibleToWin()) {
            gameScore = isScoredPointsDifferenceEqualToOne() ? getEligibleWinningPlayerScore(HAS_ADVANTAGE) : getEligibleWinningPlayerScore(WON_THE_MATCH);
        } else {
            gameScore = score[playerOne.getScoredPoint()] + HYPHEN + score[playerTwo.getScoredPoint()];
        }
        return gameScore;
    }

    private boolean isScoresAreEqual() {
        return playerOne.getScoredPoint() == playerTwo.getScoredPoint();
    }

    private boolean isMinimumDeucePointScored() {
        return playerOne.getScoredPoint() >= MINIMUM_DEUCE_POINT;
    }

    private boolean isAnyPlayerEligibleToWin() {
        return playerOne.getScoredPoint() >= MINIMUM_WINNING_SCORE || playerTwo.getScoredPoint() >= MINIMUM_WINNING_SCORE;
    }

    private boolean isScoredPointsDifferenceEqualToOne() {
        return Math.abs(playerOne.getScoredPoint() - playerTwo.getScoredPoint()) == ADVANTAGE_DIFFERENCE_POINT;
    }

    private String getEligibleWinningPlayerScore(String eligibleWinnerScore) {
        return getTopScorerName() + eligibleWinnerScore;
    }

    private String getTopScorerName() {
        return playerOne.getScoredPoint() > playerTwo.getScoredPoint() ? playerOne.getName() : playerTwo.getName();
    }

}
