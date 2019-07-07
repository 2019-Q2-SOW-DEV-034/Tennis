package com.kata.tdd;

import com.kata.tdd.model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TennisGameTest {

    private TennisGame tennisGame;

    @BeforeEach
    public void initializeBeforeEachMethod(){
        tennisGame = new TennisGame();
    }


    @Test
    @DisplayName("When the Tennis Game start, player one scored point should be equal to zero")
    public void whenTheGameStartsPlayerOneScoredPointShouldBeEqualToZeroTest(){
        assertEquals(0, tennisGame.getPlayerOne().getScoredPoint());
    }

    @Test
    @DisplayName("When the Tennis Game start, player two scored point should be equal to zero")
    public void whenTheGameStartsPlayerTwoScoredPointShouldBeEqualToZeroTest(){
        assertEquals(0, tennisGame.getPlayerTwo().getScoredPoint());
    }

    @Test
    @DisplayName("When the Tennis Game start, player one name should be initialized as 'Player1'")
    public void whenTheGameStartsPlayerOneNameShouldBeInitializedAsPlayer1Test(){
        assertEquals("Player1", tennisGame.getPlayerOne().getName());
    }

    @Test
    @DisplayName("When the Tennis Game start, player two name should be initialized as 'Player2'")
    public void whenTheGameStartsPlayerTwoNameShouldBeInitializedAsPlayer2Test(){
        assertEquals("Player2", tennisGame.getPlayerTwo().getName());
    }

    @Test
    @DisplayName("When the Tennis Game starts, current game score should be equal to 'Love-All'")
    public void whenTheGameStartsGameScoreShouldBeEqualToLoveAllTest(){
        assertEquals("Love-All", tennisGame.calculateGameScore());
    }

    @Test
    @DisplayName("When the Player1 score one point then game score should be equal to 'Fifteen-Love'")
    public void whenPlayerOneWinsAPointThenGameScoreShouldBeFifteenLoveTest() {
        tennisGame.getPlayerOne().incrementPlayerScore();

        assertEquals("Fifteen-Love", tennisGame.calculateGameScore());
    }

    @Test
    @DisplayName("When the Player2 scored two points and player1 scored zero point then game score should be equal to 'Love-Thirty'")
    public void whenPlayerTwoWonTwoPointsThenGameScoreShouldBeLoveThirtyTest() {
        updatePlayerScoreBasedOnNumberOfWins(tennisGame.getPlayerTwo(), 2);

        assertEquals("Love-Thirty", tennisGame.calculateGameScore());
    }

    @Test
    @DisplayName("When the Player1 scored three points and Player2 scored 2 points then game score should be equal to Forty-Thirty")
    public void whenPlayer1WinsThreeServicesAndPlayer2WinsTwoServicesThenGameStatusShouldBeEqualToFortyThirtyTest() {
        updatePlayerScoreBasedOnNumberOfWins(tennisGame.getPlayerOne(), 3);
        updatePlayerScoreBasedOnNumberOfWins(tennisGame.getPlayerTwo(), 2);

        assertEquals("Forty-Thirty", tennisGame.calculateGameScore());
    }

    @ParameterizedTest
    @CsvSource({"1,0,Fifteen-Love", "0,1,Love-Fifteen", "1,1,Fifteen-All", "1,2,Fifteen-Thirty",
            "2,1,Thirty-Fifteen", "1,3,Fifteen-Forty", "2,3,Thirty-Forty", "3,2,Forty-Thirty", "2,2,Thirty-All"})
    @DisplayName("The running score of each game is described in a manner peculiar to tennis:" +
            " scores from zero to three points are described as “love”, “fifteen”, “thirty”, and “forty” respectively")
    public void runningScoreShouldBeDescribedInAMannerPeculiarToTennis(int player1Points, int player2Points, String gameScore) {
        updatePlayerScoreBasedOnNumberOfWins(tennisGame.getPlayerOne(), player1Points);
        updatePlayerScoreBasedOnNumberOfWins(tennisGame.getPlayerTwo(), player2Points);

        assertEquals(gameScore, tennisGame.calculateGameScore());
    }

    @Test
    @DisplayName("A game is Won by a player1 to have won at least four points in total and at least two points more than the player2")
    public void whenAPlayer1ScoresMinimumFourPointsInTotalAndMinimumTwoPointsMoreThanThePlayer2ThenGameIsWonByThatPlayer1() {
        updatePlayerScoreBasedOnNumberOfWins(tennisGame.getPlayerOne(), 4);
        updatePlayerScoreBasedOnNumberOfWins(tennisGame.getPlayerTwo(), 2);

        assertEquals("Player1 won the game", tennisGame.calculateGameScore());
    }

    private void updatePlayerScoreBasedOnNumberOfWins(Player player, int numberOfWins){
        for(int index=0; index < numberOfWins; index++){
            player.incrementPlayerScore();
        }
    }
}
