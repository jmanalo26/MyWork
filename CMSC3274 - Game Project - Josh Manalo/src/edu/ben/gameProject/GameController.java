package edu.ben.gameProject;

import java.awt.Color;

import edu.ben.gameProject.characters.EnemyFactory;
import edu.ben.gameProject.characters.Player;
import edu.ben.gameProject.gameBoard.GameBoard;

import java.util.Random;

/**
 * Game controller class used for launching the game
 * 
 * @author Mirsky Party Crew
 * @version 1.0
 */
public class GameController {

	private static GameBoard board = new GameBoard();

	private Player player = board.getPlayer();

	public static int round;

	private static EnemyFactory enemyGenerator = new EnemyFactory();
	private static final Random randomNumberGenerator = new Random();
	private final static int compilerEnemyType = 0;
	private static Game newGame;
	private static TrivialWindow questionWindow = new TrivialWindow();

	/**
	 * GameController constructor
	 */
	public GameController() {
	}

	/**
	 * Main method for Game Controller
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		StartWindow.main(args);
		round = 0;
	}

	/**
	 * Starts the round and creates a splash screen for each round
	 */
	public static void startRound() {
		SplashScreen gameInfo = new SplashScreen(1);
		SplashScreen gameInfo2 = new SplashScreen(2);
		SplashScreen gameInfo3 = new SplashScreen(3);

		round++;
		board = new GameBoard();
		if (round <= 3) {
			newGame = new Game();

			Random rand = new Random();
			// Will make only light colors
			float r = (float) (rand.nextFloat() / 2f + 0.5);
			float g = (float) (rand.nextFloat() / 2f + 0.5);
			float b = (float) (rand.nextFloat() / 2f + 0.5);
			Color randomColor = new Color(r, g, b);
			newGame.setColor(randomColor);

			// uses splash screen for first round
			if (round == 1) {
				generateRandomEnemies(6, compilerEnemyType);
				generateRandomExit();
				newGame.showBoardState("ProfMirsky.png");
				gameInfo.show();
			} else if (round == 2) {
				gameInfo.hide();
				generateRandomEnemies(12, compilerEnemyType);
				generateRandomExit();
				newGame.showBoardState("ProfSpeh.png");
				gameInfo2.show();
			} else if (round == 3) {
				gameInfo2.hide();
				generateRandomEnemies(20, compilerEnemyType);
				generateRandomExit();
				newGame.showBoardState("ProfDelg.png");
				gameInfo3.show();
			}
		} else {
			gameInfo.hide();
			gameInfo2.hide();
			gameInfo3.hide();
			Game.win();
		}
	}

	/**
	 * Places an object marker on the board
	 * 
	 * @param posX   x-axis
	 * @param posY   y-axis
	 * @param marker object that is being stored
	 * @return true or false if the place works
	 */
	public static Boolean placeOnBoard(int posX, int posY, Object marker) {
		if (isTileOccupied(posX, posY)) {
			return false;
		} else {
			board.placeOnBoard2(posX, posY, marker);
			return true;
		}

	}

	/**
	 * Moves the player if the location is valid
	 * 
	 * @param posX x-axis
	 * @param posY y-axis
	 * @return true or false based on if the move is valid
	 */
	public boolean movePlayerTo(int posX, int posY) {
		if (board.isValidPlayerMove(posX, posY)) {
			board.movePlayer(posX, posY);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method is used to lower the players health and end the game if the
	 * player is out of health
	 */
	public void playerHit() {
		player.damageDealt(50);
	}

	public boolean isPlayerDead() {
		if (player.isDead()) {
			Game.gameOver();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Checks to see if the current tile is occupied
	 * 
	 * @param posX x-axis position
	 * @param posY y-axis position
	 * @return true or false based on if the tile is occupied
	 */
	public static boolean isTileOccupied(int posX, int posY) {
		return board.isTileOccupied(posX, posY);
	}

	/**
	 * Checks if the current tile is the exit
	 * 
	 * @param posX x-axis
	 * @param posY y-axis
	 * @return true or false based on if the tile is the exit
	 */
	public boolean isExitTile(int posX, int posY) {
		return board.isExit(posX, posY);
	}

	/**
	 * Gets the player object
	 * 
	 * @return player object
	 */
	public Player getPlayer() {
		return board.getPlayer();

	}

	/**
	 * Checks if the tile is the current position of the player
	 * 
	 * @param posX x-axis
	 * @param posY y-axis
	 * @return true or false based on if the tile is the players position
	 */
	public boolean isPlayerTile(int posX, int posY) {
		return (board.getPlayer().getXPosition() == posX && board.getPlayer().getYPosition() == posY);

	}

	/**
	 * Creates the locations of the enemies
	 * 
	 * @param numberOfEnemies the number of enemies being created
	 * @param enemyType       type of enemy being created
	 */
	private static void generateRandomEnemies(int numberOfEnemies, int enemyType) {
		int controlBreak = 0;
		while (controlBreak < numberOfEnemies) {

			int enemyXPositon = randomNumberGenerator.nextInt(10);
			int enemyYPositon = randomNumberGenerator.nextInt(10);

			if (!isTileOccupied(enemyXPositon, enemyYPositon)) {
				placeOnBoard(enemyXPositon, enemyYPositon,
						enemyGenerator.createNewEnemy(enemyType, enemyXPositon, enemyYPositon));
				controlBreak++;
			}
		}
	}

	/**
	 * Creates a randomly generated exit
	 */
	private static void generateRandomExit() {
		int exitXPosition = randomNumberGenerator.nextInt(10);
		int exitYPosition = randomNumberGenerator.nextInt(10);
		while (isTileOccupied(exitXPosition, exitYPosition)) {
			exitXPosition = randomNumberGenerator.nextInt(10);
			exitYPosition = randomNumberGenerator.nextInt(10);
		}
		placeOnBoard(exitXPosition, exitYPosition, "X");
	}

	/**
	 * Disposes the newGame frame
	 */
	public static void closeFrame() {
		newGame.disposeFrame();
	}

	/**
	 * Generates questions for the enemies. Hides if player dies
	 */
	public void generateQuestions() {
		setFrameVisibility(false);
		questionWindow.generateQuestion(this);
		isPlayerDead();
	}

	/**
	 * Sets the frames visibility
	 * 
	 * @param frameVisibility true or false sets the frames visibility
	 */
	public void setFrameVisibility(boolean frameVisibility) {
		newGame.setFrameVisibility(frameVisibility);
	}

}
