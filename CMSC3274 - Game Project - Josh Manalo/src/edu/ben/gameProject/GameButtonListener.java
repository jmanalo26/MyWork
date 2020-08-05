package edu.ben.gameProject;

import java.awt.Color;
import java.awt.Font;
//import java.awt.Color;
//import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.Random;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
import javax.swing.JOptionPane;
//import javax.swing.JPanel;
import javax.swing.JPanel;

/**
 * 
 * @author Josh Manalo
 * @version 1.0
 */
public class GameButtonListener implements ActionListener {

	private GameController game1;

	/**
	 * The X position of the board
	 */
	private int posX;

	/**
	 * The Y position of the board
	 */
	private int posY;

	/**
	 * The button GUI array to simulate game play
	 */
	private JButton[][] btns;

	/**
	 * ButtonListner Method for each location on the board for each game. This will
	 * simulate the action performed when a spot is clicked.
	 * 
	 * @param posX Position X
	 * @param posY Position Y
	 * @param btns GUI board
	 */
	public GameButtonListener(GameController g1, int posX, int posY, JButton[][] btns) {
		this.game1 = g1;
		this.posX = posX;
		this.posY = posY;
		this.btns = btns;
	}

	/**
	 * Method to simulate action of placement by updating the board via the
	 * character array and the GUI
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		// if board spot is occupied, it's either an exit, or an enemy.
		if (GameController.isTileOccupied(posX, posY)) {
			if (game1.isExitTile(posX, posY) && game1.movePlayerTo(posX, posY)) {
				JOptionPane.showMessageDialog(null, "You have found the exit!");
				GameController.closeFrame();
				GameController.startRound();
			} else if (!game1.isPlayerTile(posX, posY)) {
				if (game1.movePlayerTo(posX, posY)) {
					updateButton(btns);
					// create a new frame to store text field and button

					// Decrease player health
					game1.generateQuestions();
					// create a panel
					JPanel p = new JPanel();
					// add textfield to panel

					// set color background of panel
					Random rand = new Random();
					float r = (float) (rand.nextFloat() / 2f + 0.5);
					float g = (float) (rand.nextFloat() / 2f + 0.5);
					float b = (float) (rand.nextFloat() / 2f + 0.5);
					Color randomColor = new Color(r, g, b);
					p.setBackground(randomColor);
					updateButton(btns);
				} else {
					JOptionPane.showMessageDialog(null, "Invalid input!");
				}
			}
		} else {
			if (game1.movePlayerTo(posX, posY)) {
				updateButton(btns);
			} else {
				JOptionPane.showMessageDialog(null, "Invalid input!");
			}
		}
	}

	/**
	 * Updates the button to a different piece of text
	 * 
	 * @param btns JButton
	 */
	public void updateButton(JButton[][] btns) {

			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (!GameController.isTileOccupied(i, j)) {
						btns[i][j].setIcon(null);
					} else {
						if (game1.isPlayerTile(i, j)) {
							btns[posX][posY].setIcon((new ImageIcon(((new ImageIcon("newPlayer.png")).getImage())
									.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH))));
						}
					}

				}
			}
		}
	
}
