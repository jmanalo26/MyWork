package edu.ben.gameProject.characters;

/**
 * Factory for creating enemies
 * 
 * @author Anunay
 * @version 1.0
 */
public class EnemyFactory {
	private final static int compilerEnemy = 0;

	/**
	 * Creates enemies
	 * 
	 * @param typeOfEnemy type of enemy
	 * @param xPosition   x-axis
	 * @param yPosition   y-axis
	 * @return returns new enemy
	 */
	public CompilerEnemies createNewEnemy(int typeOfEnemy, int xPosition, int yPosition) {
		CompilerEnemies newEnemy = null;

		if (typeOfEnemy == compilerEnemy) {
			return new CompilerEnemies(xPosition, yPosition);
		}

		return newEnemy;

	}
}
