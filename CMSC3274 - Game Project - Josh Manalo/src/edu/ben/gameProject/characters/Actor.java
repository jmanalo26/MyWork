package edu.ben.gameProject.characters;

/**
 * 
 * @author Anunay Jujjavarapu
 * @version 12-23-19
 * 
 *          Description: Each character of the game, whether its a player or
 *          enemy must be able to do these actions or have these attributes.
 *
 */
public interface Actor {

	/**
	 * We need to know how much health each character has.
	 * 
	 * @return the total health of the actor
	 */
	public double getTotalHealth();

	/**
	 * We have to know the remaining health of the character.
	 * 
	 * @return how much of the health the actor has left
	 */
	public double getRemainingHealth();

	/**
	 * Given the health of any given character can decrease, we need to reduce it by
	 * a given amount
	 * 
	 * @param damage the amount of damage you want the actor to take
	 */
	public void damageDealt(double damage);

	/**
	 * If it bleeds, we can kill it
	 * 
	 * @return whether the character is currently dead or not
	 */
	public boolean isDead();

	/**
	 * need to know the position of the character at any given time
	 * 
	 * @return the x positon
	 */
	public int getXPosition();

	/**
	 * need to know the position of the character at any given time
	 * 
	 * @return the y positon
	 */
	public int getYPosition();

}
