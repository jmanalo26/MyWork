package edu.ben.gameProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This method is used a button listener for the trivia window
 * 
 * @author Anunay
 * @version 1.0
 */
public class TrivialWindowButtonListener implements ActionListener {

	private static GameController game1;
	private boolean valueOfQuestion;
	private boolean chosenValue;
	private static JFrame frame;

	/**
	 * This is the constructor of the TrivialWindow
	 * 
	 * @param game1           GameController object
	 * @param valueOfQuestion boolean value of question
	 * @param chosenValue     boolean chosen value
	 * @param frame           Jframe
	 */
	public TrivialWindowButtonListener(GameController game1, boolean valueOfQuestion, boolean chosenValue,
			JFrame frame) {
		TrivialWindowButtonListener.game1 = game1;
		this.valueOfQuestion = valueOfQuestion;
		this.chosenValue = chosenValue;
		TrivialWindowButtonListener.frame = frame;
	}

	/**
	 * This method is used when a player answers true or false
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (!checkAnswer(chosenValue, valueOfQuestion)) {
			game1.playerHit();
			JOptionPane.showMessageDialog(null, "Wrong");
		} else {
			JOptionPane.showMessageDialog(null, "Correct!");
		}
		if (!game1.isPlayerDead()) {
			game1.setFrameVisibility(true);
		}

		frame.dispose();

	}

	/**
	 * Used to check if the answer was correct or not
	 * 
	 * @param chosenValue     boolean chosen value
	 * @param valueOfQuestion boolean correct value
	 * @return returns true or flase based on if the user was correct
	 */
	public static boolean checkAnswer(boolean chosenValue, boolean valueOfQuestion) {
		if (chosenValue == valueOfQuestion) {
			return true;
		} else {
			return false;
		}
	}

}
