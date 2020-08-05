package edu.ben.gameProject;

import javax.swing.*;

/**
 * Used to create a splash screen
 * 
 * @author Liam Clancy
 * @version 1.0
 */

public class SplashScreen {
	private JFrame rules;

	/**
	 * creates a splash screen based on the number inputed
	 * 
	 * @param x type of splash screen being created
	 */
	public SplashScreen(int x) {
		if (x == 1) {
			rules = new JFrame("Thems The Rules");
			rules.add(new JLabel(new ImageIcon("SplashScreen1.png")));
			rules.setSize(1000, 1000);
			rules.setBounds(750, 50, 500, 500);
		}
		if (x == 2) {
			rules = new JFrame("Thems The Rules 2");
			rules.add(new JLabel(new ImageIcon("SplashScreen2.png")));
			rules.setSize(1000, 1000);
			rules.setBounds(750, 50, 500, 500);
		}
		if (x == 3) {
			rules = new JFrame("Thems The Rules 3");
			rules.add(new JLabel(new ImageIcon("SplashScreen3.png")));
			rules.setSize(1000, 1000);
			rules.setBounds(750, 50, 500, 500);
		}
	}

	/**
	 * Makes the splash screen visible
	 */
	public void show() {
		rules.setVisible(true);
	}

	/**
	 * Makes the splash screen invisable
	 */
	public void hide() {
		rules.setVisible(false);
	}

	/**
	 * Creates a splash screen
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SplashScreen splash = new SplashScreen(1);
		splash.show();
	}
}
