package com.kata.tdd;

import com.kata.tdd.model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        prepareAndAssertCalculateGameScore(3, 2, "Forty-Thirty");
    }

    @ParameterizedTest
    @CsvSource({
            "0,1,Love-Fifteen",
            "1,1,Fifteen-All",
            "1,2,Fifteen-Thirty",
            "1,3,Fifteen-Forty",
            "2,1,Thirty-Fifteen",
            "2,3,Thirty-Forty",
            "2,2,Thirty-All",
            "3,1,Forty-Fifteen"})
    @DisplayName("The running score of each game is described in a manner peculiar to tennis:" +
            " scores from zero to three points are described as “love”, “fifteen”, “thirty”, and “forty” respectively")
    public void runningScoreShouldBeDescribedInAMannerPeculiarToTennisTest(int player1Points, int player2Points, String gameScore) {
        prepareAndAssertCalculateGameScore(player1Points, player2Points, gameScore);
    }

    @Test
    @DisplayName("A game is Won by a player1 to have won at least four points in total and at least two points more than the player2")
    public void whenAPlayer1ScoresMinimumFourPointsInTotalAndMinimumTwoPointsMoreThanThePlayer2ThenGameIsWonByThatPlayer1Test() {
        prepareAndAssertCalculateGameScore(4, 2, "Player1 won the game");
    }

    @Test
    @DisplayName("A game is Won by a player2 to have won at least four points in total and at least two points more than the player1")
    public void whenAPlayer2ScoresMinimumFourPointsInTotalAndMinimumTwoPointsMoreThanThePlayer1ThenGameIsWonByThatPlayer2Test() {
        prepareAndAssertCalculateGameScore(2, 4, "Player2 won the game");
    }

    @ParameterizedTest
    @CsvSource({
            "4,0,Player1 won the game",
            "5,3,Player1 won the game",
            "6,4,Player1 won the game",
            "10,8,Player1 won the game",
            "0,4,Player2 won the game",
            "1,4,Player2 won the game",
            "3,5,Player2 won the game",
            "6,8,Player2 won the game",
            "9,11,Player2 won the game"})
    @DisplayName("A game is Won by a player to have won at least four points in total and at least two points more than the opponent")
    public void whenAPlayerScoresMinimumFourPointsInTotalAndMinimumTwoPointsMoreThanTheOpponentThenGameIsWonByThatPlayer(int player1Points, int player2Points, String gameScore) {
        prepareAndAssertCalculateGameScore(player1Points, player2Points, gameScore);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 7, 8, 11})
    @DisplayName("If at least three points have been scored by each player, and the scores are equal, the score is Deuce")
    public void whenAtLeastThreePointsScoredByEachPlayerAndScoresAreEqualThenGameScoreShouldBeEqualToDeuce(int points) {
        updatePlayerScore(points, points);

        assertEquals("Deuce", tennisGame.calculateGameScore());
    }

    @ParameterizedTest
    @CsvSource({
            "4,3,Player1 has advantage",
            "5,4,Player1 has advantage",
            "7,6,Player1 has advantage",
            "3,4,Player2 has advantage",
            "9,10,Player2 has advantage"})
    @DisplayName("If at least three points have been scored by each side and a player has one more point than his opponent, the score of the game is “advantage” for the player in the lead.")
    public void whenAtLeastThreePointsScoredByEachPlayerAndPointDifferenceIsOneThenGameIsAdvantageForThePlayerInLead(int player1Points, int player2Points, String gameScore) {
        prepareAndAssertCalculateGameScore(player1Points, player2Points, gameScore);
    }

    @Test
    @DisplayName("Tennis Game should have possibility to initialize the players with customer names")
    public void whenTheGameStartsTennisGameShouldHavePossibilityToRegisterCustomNameForTwoPlayersTest() {
        tennisGame = new TennisGame("Tom", "John");

        assertEquals("Tom", tennisGame.getPlayerOne().getName());
        assertEquals("John", tennisGame.getPlayerTwo().getName());
    }

    @Test
    @DisplayName("If the winning indicator is one then PlayerOne point should be incremented by one")
    public void whenTheWinningIndicatorIsOneThenPlayer1PointShouldBeIncrementByOneTest() {
        updatePlayerScore(2, 1);
        int expectedPlayerOnePoint = tennisGame.getPlayerOne().getScoredPoint() + 1;

        tennisGame.addCurrentServicePointToWinner(1);

        assertEquals(expectedPlayerOnePoint, tennisGame.getPlayerOne().getScoredPoint());
    }

    @Test
    @DisplayName("If the winning indicator is two then PlayerTwo point should be incremented by one")
    public void whenTheWinningIndicatorIsTwoThenPlayer2PointShouldBeIncrementByOneTest() {
        updatePlayerScore(2, 1);
        int expectedPlayerOnePoint = tennisGame.getPlayerTwo().getScoredPoint() + 1;

        tennisGame.addCurrentServicePointToWinner(2);

        assertEquals(expectedPlayerOnePoint, tennisGame.getPlayerTwo().getScoredPoint());
    }

    @Test
    @DisplayName("If the winning indicator is other than one and two then throw IllegalArgumentException")
    public void whenTheWinningIndicatorIsWrongThenThrowIllegalArgumentExceptionTest() {

        assertThrows(IllegalArgumentException.class, () -> tennisGame.addCurrentServicePointToWinner(4));
    }

    @ParameterizedTest
    @CsvSource({"0, 0, 1, Fifteen-Love"})
    @DisplayName("Get Current Service Game score should add current service point to the winner based on the winning indicator and return the newly calculated game score")
    public void getCurrentServiceGameScoreShouldAddServicePointToWinnerAndReturnNewlyCalculatedGameScore(int player1Points, int player2Points, int winningIndicator, String expectedGameScore) {
        updatePlayerScore(player1Points, player2Points);

        assertEquals(expectedGameScore, tennisGame.getCurrentServiceGameScore(winningIndicator));
    }

    private void prepareAndAssertCalculateGameScore(int player1Points, int player2Points, String gameScore) {
        updatePlayerScore(player1Points, player2Points);

        assertEquals(gameScore, tennisGame.calculateGameScore());
    }

    private void updatePlayerScore(int playerOnePoints, int playerTwoPoints) {
        updatePlayerScoreBasedOnNumberOfWins(tennisGame.getPlayerOne(), playerOnePoints);
        updatePlayerScoreBasedOnNumberOfWins(tennisGame.getPlayerTwo(), playerTwoPoints);
    }

    private void updatePlayerScoreBasedOnNumberOfWins(Player player, int numberOfWins){
        for(int index=0; index < numberOfWins; index++){
            player.incrementPlayerScore();
        }
    }
}
