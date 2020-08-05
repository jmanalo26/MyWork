package edu.ben.gameProject;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

/**
 * The GUI class for our game
 * 
 * @author Team Mirsky Party
 * @version 1.0
 */
public class Game {

	private JFrame frame;
	public static JButton[][] squares = new JButton[10][10];

	private GameController w2 = new GameController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Have to separate Game object and GUI
					Game window = new Game();
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
	public Game() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(50, 30, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Set 10x10 grid
		frame.setLayout(new GridLayout(10, 10));
		frame.setSize(700, 700);
		frame.setVisible(true);

		// Add buttons per point on grid
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				squares[i][j] = new JButton();
				frame.add(squares[i][j]);

				ActionListener action = new GameButtonListener(w2, i, j, squares);
				squares[i][j].addActionListener(action);
			}
		}

	}

	/**
	 * Sets color of board, lets use this to signify different rounds
	 * 
	 * @param c color of board
	 */
	public void setColor(Color c) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				squares[i][j].setBackground(c);
			}
		}
	}

	/**
	 * Method is used if the game is won. Creates a frame for a Winner with a button
	 * to finish
	 */
	public static void win() {
		JFrame f = new JFrame("WINNER");

		// create a label to display text
		JLabel l = new JLabel("YOU WIN");
		l.setFont(new Font("Berlin Sans FB Demi", Font.BOLD | Font.ITALIC, 49));

		// create a new buttons
		JButton b1 = new JButton("FINISH");
		b1.addActionListener(a -> {
			f.setVisible(false);
			GameController.main(null);
		});

		// create a panel to add buttons
		JPanel p = new JPanel();

		// add buttons and textfield to panel
		p.add(l);
		p.add(new JSeparator());
		p.add(b1);

		// setbackground of panel
		p.setBackground(Color.green);

		// add panel to frame
		f.add(p);

		// set the size of frame
		f.setSize(400, 300);
		f.setVisible(true);

	}

	/**
	 * Creates a frame for if the game is lost. Exits game when button is pressed
	 */
	public static void gameOver() {
		JFrame f = new JFrame("GAME OVER");

		// create a label to display text
		JLabel l = new JLabel("GAME OVER");
		l.setFont(new Font("Berlin Sans FB Demi", Font.BOLD | Font.ITALIC, 49));

		// create a new buttons
		JButton b1 = new JButton("Exit");
		b1.addActionListener(a -> {
			f.setVisible(false);
			System.exit(0);
		});

		// create a panel to add buttons
		JPanel p = new JPanel();

		// add buttons and textfield to panel
		p.add(l);
		p.add(b1);

		// setbackground of panel
		p.setBackground(Color.red);

		// add panel to frame
		f.add(p);

		// set the size of frame
		f.setSize(320, 300);
		f.setVisible(true);

	}

	/**
	 * Used to show the board's current state.
	 */
	public void showBoardState(String professorPng) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (GameController.isTileOccupied(i, j)) {
					if (w2.isPlayerTile(i, j)) {
						squares[i][j].setIcon((new ImageIcon(((new ImageIcon("newPlayer.png")).getImage())
								.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH))));
					} else if (w2.isExitTile(i, j)) {
						squares[i][j].setIcon((new ImageIcon(((new ImageIcon(professorPng)).getImage())
								.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH))));
						int exitXposition;
						int exitYposition;
						exitXposition = i;
						exitYposition = j;
						if (w2.movePlayerTo(i, j)) {
							JButton destination = squares[exitXposition][exitYposition];
							destination.addActionListener(e -> {
								frame.setVisible(false);
							});
						}
					} else {
						squares[i][j].setIcon((new ImageIcon(((new ImageIcon(professorPng)).getImage())
								.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH))));
					}

				}
			}
		}
	}

	/**
	 * Disposes the Jframe
	 */
	public void disposeFrame() {
		frame.dispose();
	}

	/**
	 * Returns the GameContoller object
	 * 
	 * @return GameController object
	 */
	public GameController getController() {
		return w2;
	}

	/**
	 * Sets the visibility of the frame
	 * 
	 * @param frameVisibility true or false sets the frames visibility
	 */
	public void setFrameVisibility(boolean frameVisibility) {
		frame.setVisible(frameVisibility);
	}

}
