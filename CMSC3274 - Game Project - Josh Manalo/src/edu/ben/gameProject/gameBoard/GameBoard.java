package edu.ben.gameProject.gameBoard;

import edu.ben.gameProject.characters.Player;

/**
 * 
 * @author Anunay Jujjavarapu
 * @version 11-24-19
 * 
 *          Description: This is the backend of our program. It will contain all
 *          our Actor objects and the exit.
 *
 */
public class GameBoard {

	/**
	 * Setting up the necessary variables
	 */
	final public static int NUM_TILES = 10;
	private static Tile[][] board = new Tile[NUM_TILES][NUM_TILES];
	final private int startingPlayerLocation = 0;
	final private double playerTotalHealth = 150;
	private Player player = new Player(playerTotalHealth, startingPlayerLocation, startingPlayerLocation);

	/**
	 * Set up the tiles, set up the board itself, and start the player on the first
	 * tile.
	 */
	public GameBoard() {
		board = new Tile[NUM_TILES][NUM_TILES];
		setBoard();
		board[startingPlayerLocation][startingPlayerLocation].setData(player);
	}

	/**
	 * This method will simply place any object on the board
	 * 
	 * @param posX   the x coordinate
	 * @param posY   the y coordinate
	 * @param marker the object you want me to place
	 * 
	 */
	public void placeOnBoard2(int posX, int posY, Object marker) {
		board[posX][posY].setData(marker);

	}

	/**
	 * Sets the entire board with tiles that have the data of empty strings
	 */
	public static void setBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = new Tile(i, j, " ");
				;
			}

		}
	}

	/**
	 * Boolean check to see whether a given tile is occupied or not
	 * 
	 * @param posX the x position
	 * @param posY the y position
	 * @return true is the tile is occupied, false if not
	 */
	public boolean isTileOccupied(int posX, int posY) {
		return board[posX][posY].isTileOccupied();
	}

	/**
	 * Boolean check to see if the given tile location is the exit or not
	 * 
	 * @param posX the x position
	 * @param posY the y position
	 * @return true is the tile is exit, false if not
	 */
	public boolean isExit(int posX, int posY) {
		return board[posX][posY].isExit();
	}

	/**
	 * A boolean check to see whether the player can in fact make that move
	 * 
	 * @param posX the x position
	 * @param posY the y position
	 * @return true if valid move, false if not
	 */
	public boolean isValidPlayerMove(int posX, int posY) {
		return player.isValidMove(posX, posY);
	}

	/**
	 * moves the player to the designated location on the board, and makes sure
	 * their previous location is updated
	 * 
	 * @param posX the x position
	 * @param posY the y position
	 */
	public void movePlayer(int posX, int posY) {
		int tempPlayerPosX = player.getXPosition();
		int tempPlayerPosY = player.getYPosition();
		player.setXPosition(posX);
		player.setYPosition(posY);
		board[tempPlayerPosX][tempPlayerPosY].setData(" ");
		placeOnBoard2(posX, posY, player);

	}

	/**
	 * returns the instance of the player
	 * 
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

}