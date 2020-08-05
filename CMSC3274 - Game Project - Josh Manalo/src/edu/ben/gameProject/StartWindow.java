package edu.ben.gameProject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;

/**
 * Creates a start window for the game
 * 
 * @author Ryan
 * @version 1.0
 */
public class StartWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartWindow window = new StartWindow();
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
	public StartWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(Color.BLUE);
		frame.setBounds(100, 100, 1000, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel gameTitle = new JLabel("Mirsky Party!");
		gameTitle.setFont(new Font("Berlin Sans FB Demi", Font.BOLD | Font.ITALIC, 43));
		gameTitle.setHorizontalAlignment(SwingConstants.CENTER);
		gameTitle.setBounds(277, 49, 437, 128);
		frame.getContentPane().add(gameTitle);

		JButton btnPlayGame = new JButton("PLAY GAME");
		btnPlayGame.setFont(new Font("Stencil", Font.PLAIN, 29));
		btnPlayGame.setForeground(Color.BLACK);
		btnPlayGame.setBackground(new Color(0, 255, 0));
		btnPlayGame.setBounds(147, 294, 239, 78);
		btnPlayGame.addActionListener(e -> {
			GameController.startRound();
			frame.dispose();
		});
		frame.getContentPane().add(btnPlayGame);

		JButton btnExit = new JButton("EXIT");
		btnExit.setBackground(Color.RED);
		btnExit.setFont(new Font("Stencil", Font.BOLD, 29));
		btnExit.setForeground(Color.BLACK);
		btnExit.setBounds(583, 294, 239, 78);

		btnExit.addActionListener(e -> {
			System.exit(0);
			;
			System.exit(0);
		});

		frame.getContentPane().add(btnExit);
	}
}
