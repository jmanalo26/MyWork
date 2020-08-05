package edu.ben.gameProject.gameBoard;

/**
 * 
 * @author Anunay Jujjavarapu
 * @version (10-30-19)
 * 
 *          Description: These are the individual tiles our our board. Each tile
 *          has a location as well as some object contained within it.
 * 
 * @TODO: I would like to create two more objects, one which dictates an open
 *        slot and one which is restricted. So it makes restricting player
 *        movement much simpler.
 * 
 *
 */
public class Tile {

	private int posX;
	private int posY;
	private Object data;

	/**
	 * Constructor for the tile object
	 * 
	 * @param posX x-axis
	 * @param posY y-axis
	 * @param data data from the object being sent over
	 */
	public Tile(int posX, int posY, Object data) {
		this.posX = posX;
		this.posY = posY;
		this.data = data;
	}

	/**
	 * Gets the x-axis position
	 * 
	 * @return x-axis
	 */
	public int getPosX() {
		return posX;
	}

	/**
	 * Sets the x-axis position
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}

	/**
	 * Gets the y-axis position
	 * 
	 * @return y-axis
	 */
	public int getPosY() {
		return posY;
	}

	/**
	 * Sets the y-axis position
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}

	/**
	 * Gets object used for data
	 * 
	 * @return data object
	 */
	public Object getData() {
		return data;
	}

	/**
	 * Sets object used for data
	 * 
	 * @param data object used for data
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * Gets boolean value of data being equal to " "
	 * 
	 * @return true if tile is " "
	 */
	public boolean isTileOccupied() {
		return !data.equals(" ");
	}

	/**
	 * Gets boolean value of data being equal to "X"
	 * 
	 * @return true if data is X
	 */
	public boolean isExit() {
		return data.equals("X");
	}

}