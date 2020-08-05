package edu.ben.gameTests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ben.gameProject.GameController;
import edu.ben.gameProject.characters.CompilerEnemies;
import edu.ben.gameProject.characters.Player;
import edu.ben.gameProject.gameBoard.GameBoard;
//
/**
 * 
 * @author Liam Clancy
 * @version 1.0
 */
public class GameTest {

	/**
	 * GameController GC Tests to see if placeOnBoard correctly returns false
	 */
	@Test
	public void GCplaceOnBoard() {

		assertFalse(GameController.placeOnBoard(0, 0, ":)"));
	}

	/**
	 * Tests to see if placeOnBoard correctly returns true
	 */
	@Test
	public void GCplaceOnBoard2() {

		assertTrue(GameController.placeOnBoard(0, 1, ":)"));
	}

	/**
	 * Tests to see if movePlayerTo correctly returns true
	 */
	@Test
	public void GCmovePlayerTo() {

		GameController b = new GameController();

		assertTrue(b.movePlayerTo(0, 0));
	}

	/**
	 * Tests to see if movePlayerTo correctly returns false
	 */
	@Test
	public void GCmovePlayerTo2() {

		GameController b = new GameController();

		assertFalse(b.movePlayerTo(0, 5));
	}
	
	/**
	 * Tests to see if Playere is hit
	 */
	@Test
	public void GCisPlayerHit()
	{

		GameController b = new GameController();
		b.playerHit();
		Player p = new Player(90,0,1);
		p = b.getPlayer();
		double h = p.getRemainingHealth();
		System.out.print(p.getRemainingHealth());
		assertFalse(h == 50.00);
	}

	/**
	 * Tests to see if isTileOccupied correctly returns true
	 */
	@Test
	public void GCisTileOccupied() {

		GameController b = new GameController();
		b.isPlayerTile(0, 0);

		assertTrue(GameController.isTileOccupied(0, 0));
	}

	/**
	 * Tests to see if isTileOccupied correctly returns true
	 */
	@Test
	public void GCisTileOccupied2() {

		GameController b = new GameController();
		b.isPlayerTile(0, 0);

		assertFalse(GameController.isTileOccupied(0, 1));
	}

	/**
	 * Tests to see if isPlayerTile correctly returns true
	 */
	@Test
	public void GCisPlayerTile() {

		GameController b = new GameController();
		b.isPlayerTile(0, 0);

		assertTrue(b.isPlayerTile(0, 0));
	}

	/**
	 * Tests to see if isPlayerTile correctly returns false
	 */
	@Test
	public void GCisPlayerTile2() {

		GameController b = new GameController();
		b.isPlayerTile(0, 0);

		assertFalse(GameController.isTileOccupied(0, 3));
	}
	
	/**
	 * Tests that the enemy correctly takes damage
	 */
	@Test 
	public void CEdamgeDealt()
	{
		CompilerEnemies c = new CompilerEnemies(1,1);
		c.damageDealt(50);
		double x =c.getRemainingHealth();
		assertTrue(x == 50.00);
		
	}
	
	/**
	 * Tests that the Player correctly takes damage
	 */
	@Test 
	public void PdamgeDealt()
	{
		Player c = new Player(100,1,1);
		c.damageDealt(50);
		double x =c.getRemainingHealth();
		assertTrue(x == 50.00);
		
	}
	
	/**
	 * Tests that the Player is not
	 */
	@Test 
	public void PisDead()
	{
		Player c = new Player(100,1,1);
		c.damageDealt(50);
		assertFalse(c.isDead());
		
	}
	
	/**
	 * Tests that the Player is not
	 */
	@Test 
	public void PisDead2()
	{
		Player c = new Player(10,1,1);
		c.damageDealt(50);
		assertTrue(c.isDead());
		
	}
	
	/**
	 * Tests that the Player move is valid
	 */
	@Test 
	public void PismoveValid()
	{
		Player c = new Player(10,1,1);
		assertTrue(c.isValidMove(0,0));
		
	}
	
	/**
	 * Tests that the Player is not valid
	 */
	@Test 
	public void PismoveValid2()
	{
		Player c = new Player(10,1,1);
		assertFalse(c.isValidMove(5,5));
		
	}
	
	/**
	 * Tests to see if tile is occupied
	 */
	@Test
	public void GBisTileOccupied()
	{
		GameBoard b = new GameBoard();
		assertTrue(b.isTileOccupied(0, 0));
	}
	
	/**
	 * Tests to see if tile is not occupied
	 */
	@Test
	public void GBisTileOccupied2()
	{
		GameBoard b = new GameBoard();
		assertFalse(b.isTileOccupied(0, 1));
	}
	
	/**
	 * Tests to see if move is valid
	 */
	@Test
	public void GBisValidPlayerMove()
	{
		GameBoard b = new GameBoard();
		assertTrue(b.isValidPlayerMove(0, 1));
	}
	
	/**
	 * Tests to see if move is not valid
	 */
	@Test
	public void GBisValidPlayerMove2()
	{
		GameBoard b = new GameBoard();
		assertFalse(b.isValidPlayerMove(0, 5));
	}
	
	
	
	
	
	
	
	
	
	
}