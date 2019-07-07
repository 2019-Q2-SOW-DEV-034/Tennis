# TennisGame
 This kata is about implementing a simple tennis game by following TDD approach in Java.

## User Story
* US0001. The running score of each game is described in a manner peculiar to tennis: scores from zero to three points are described as “love”, “fifteen”, “thirty”, and “forty” respectively.
* US0002. A game is won by the first player to have won at least four points in total and at least two points more than the opponent.
* US0003. If at least three points have been scored by each player, and the scores are equal, the score is “deuce”.
* US0004. If at least three points have been scored by each side and a player has one more point than his opponent, the score of the game is “advantage” for the player in the lead.

### Assumption
* Each game has only one set to decide the winner
* Minimum and Maximum number of player is 2
* Player one will always do the service, hence the game score will be always represented with respect to player1 i.e. player1 score - player2 score


### Prerequisite
~~~
Java 1.8 version
Maven 3.5+
Git
~~~

## Set up application
#### IDE
~~~
1. Clone the repository https://github.com/2019-Q2-SOW-DEV-034/Tennis
2. Add as Maven project
3. Select Project SDK as JDK 1.8
~~~

#### Command prompt
~~~
1. Clone repository from GIT 'git clone https://github.com/2019-Q2-SOW-DEV-034/Tennis'
2. Run `mvn clean install`
~~~
