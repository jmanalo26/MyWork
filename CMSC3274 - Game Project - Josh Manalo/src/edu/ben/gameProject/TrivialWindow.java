package edu.ben.gameProject;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * This class creates a window that is used for the player to answer questions
 * taken in from the hash map.
 * 
 * @author Ryan
 * @version 1.0
 */
public class TrivialWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrivialWindow window = new TrivialWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TrivialWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Mirsky's Party");
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 1000, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}

	/**
	 * Generates questions from 2 text files
	 * 
	 * @param gameController gameController object
	 */
	public void generateQuestion(GameController gameController) {
		File questionFile = new File("questions.txt");
		File answersFile = new File("answers.txt");

		HashMap<String, Boolean> enemyScreen = new HashMap<String, Boolean>();

		try {
			enemyScreen = Questions.fileReader(questionFile, answersFile);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		Iterator<Entry<String, Boolean>> quest = enemyScreen.entrySet().iterator();

		Entry<String, Boolean> entry = null;

		while (quest.hasNext()) {
			entry = quest.next();
		}

		frame = new JFrame("Mirsky's Party");
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 1000, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTextArea gameTitle = new JTextArea(entry.getKey());
		gameTitle.setTabSize(12);
		gameTitle.setWrapStyleWord(true);
		gameTitle.setLineWrap(true);
		gameTitle.setOpaque(false);
		gameTitle.setEditable(false);
		gameTitle.setFocusable(false);
		gameTitle.setFont(new Font("Microsoft YaHei", Font.PLAIN, 28));

		gameTitle.setSize(60, 200);
		gameTitle.setBounds(21, 16, 932, 257);
		frame.getContentPane().add(gameTitle);

		Boolean valueOfQuestion = entry.getValue();

		JButton btnPlayGame = new JButton("True");
		btnPlayGame.setFont(new Font("Stencil", Font.PLAIN, 29));
		btnPlayGame.setForeground(Color.BLACK);
		btnPlayGame.setBackground(new Color(0, 255, 0));
		btnPlayGame.setBounds(147, 294, 239, 78);
		ActionListener trueAction = new TrivialWindowButtonListener(gameController, valueOfQuestion, true, frame);
		ActionListener falseAction = new TrivialWindowButtonListener(gameController, valueOfQuestion, false, frame);
		btnPlayGame.addActionListener(trueAction);
		frame.getContentPane().add(btnPlayGame);

		JButton btnExit = new JButton("False");
		btnExit.setBackground(Color.RED);
		btnExit.setFont(new Font("Stencil", Font.BOLD, 29));
		btnExit.setForeground(Color.BLACK);
		btnExit.setBounds(583, 294, 239, 78);
		btnExit.addActionListener(falseAction);
		frame.getContentPane().add(btnExit);
		frame.setVisible(true);
	}
}
