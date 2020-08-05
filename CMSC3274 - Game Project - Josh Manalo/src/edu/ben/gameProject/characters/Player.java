package edu.ben.gameProject.characters;

/**
 * This class keeps track of player info.
 * 
 * @author Mirsky Party Crew
 * @version 1.0
 */
public class Player implements Actor {

	private double totalHealth = -1;
	private double currentHealth = -1;
	private int xPosition = -1;
	private int yPosition = -1;

	/**
	 * Player constructor
	 * 
	 * @param totalHealth total player health
	 * @param xPosition   x-axis
	 * @param yPosition   y-axis
	 */
	public Player(double totalHealth, int xPosition, int yPosition) {
		this.totalHealth = totalHealth;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		currentHealth = totalHealth;
	}

	/**
	 * @return total player health
	 */
	@Override
	public double getTotalHealth() {
		// TODO Auto-generated method stub
		return totalHealth;
	}

	/**
	 * @return the remaining health
	 */
	@Override
	public double getRemainingHealth() {
		// TODO Auto-generated method stub
		return currentHealth;
	}

	/**
	 * Player damage being taken
	 * 
	 * @param damage being dealt
	 */
	@Override
	public void damageDealt(double damage) {
		currentHealth -= damage;
	}

	/**
	 * @return true if health is less than 0
	 */
	@Override
	public boolean isDead() {
		return currentHealth <= 0;
	}

	/**
	 * @return x-axis position
	 */
	@Override
	public int getXPosition() {
		// TODO Auto-generated method stub
		return xPosition;
	}

	/**
	 * @return y-axis position
	 */
	@Override
	public int getYPosition() {
		// TODO Auto-generated method stub
		return yPosition;
	}

	/**
	 * sets x-axis
	 * 
	 * @param xPosition x-axis
	 */
	public void setXPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	/**
	 * sets y-axis
	 * 
	 * @param yPosition y-axis
	 */
	public void setYPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	/**
	 * Checks if players move is valid
	 * 
	 * @param posX x-axis
	 * @param posY y-axis
	 * @return returns true of false based on if move was valid
	 */
	public boolean isValidMove(int posX, int posY) {
		if ((posX <= xPosition + 1 && posX >= xPosition - 1) && (posY <= yPosition + 1 && posY >= yPosition - 1)) {
			return true;
		} else {
			return false;
		}
	}

}
