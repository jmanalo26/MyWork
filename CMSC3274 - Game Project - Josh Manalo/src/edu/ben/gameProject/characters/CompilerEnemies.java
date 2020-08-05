package edu.ben.gameProject.characters;

/**
 * This class is used to keep track of the compiler enemy
 * 
 * @author Anunay
 * @version 1.0
 */
public class CompilerEnemies implements Actor {

	private double totalHealth = 100;
	private double currentHealth;
	private int xPosition;
	private int yPosition;

	/**
	 * Complier enemy constructor
	 * 
	 * @param xPosition x-axis
	 * @param yPosition y-axis
	 */
	public CompilerEnemies(int xPosition, int yPosition) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		currentHealth = totalHealth;
	}

	/**
	 * @return total enemy health
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
	 * Enemies damage being taken
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

}
