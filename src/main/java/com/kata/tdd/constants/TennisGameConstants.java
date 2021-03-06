package com.kata.tdd.constants;

public class TennisGameConstants {
    public static final int MINIMUM_WINNING_SCORE = 4;
    public static final int ADVANTAGE_DIFFERENCE_POINT = 1;
    public static final int MINIMUM_DEUCE_POINT = 3;

    public static final int PLAYER_ONE_WINNING_INDICATOR = 1;
    public static final int PLAYER_TWO_WINNING_INDICATOR = 2;


    public static final char HYPHEN = '-';
    public static final String WON_THE_MATCH = " won the game";
    public static final String DEUCE = "Deuce";
    public static final String HAS_ADVANTAGE = " has advantage";
    public static final String HYPHEN_ALL = HYPHEN + "All";
    public static final String PLAYER_ONE_DEFAULT_NAME = "Player1";
    public static final String PLAYER_TWO_DEFAULT_NAME = "Player2";

    private TennisGameConstants(){
        throw new IllegalStateException("Utility class");
    }
}
