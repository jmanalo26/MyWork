package edu.ben.gameProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * This class uses a hash map in order to save values of questions and their
 * answers
 * 
 * @author Mirsky Party Crew
 * @version 1.0
 */
public class Questions {

	// Store Question number and answer boolean
	private static HashMap<Integer, Boolean> questions;
	// counts the amount of questions
	private static int counter;

	// string array of questions
	static ArrayList<String> questionString = new ArrayList<String>();

	public static ArrayList<String> getQuestionString() {
		return questionString;
	}

	/**
	 * Reads questions and answers from files and inputs them into a hash map and an
	 * ArrayList String Returns Hash map with the question as a key and the answer
	 * as a Boolean Value
	 * 
	 * @param questionFile file for question input
	 * @param answersFile  file for question answers
	 * @return HashMap enemyScreen
	 * @throws FileNotFoundException
	 */
	public static HashMap<String, Boolean> fileReader(File questionFile, File answersFile)
			throws FileNotFoundException {

		// Question number and Boolean answer
		questions = new HashMap<Integer, Boolean>();
		// Questions
		questionString = new ArrayList<String>();

		// Imports questions into String Array
		Scanner question;
		question = new Scanner(questionFile);

		while (question.hasNextLine()) {
			getQuestionString().add(question.nextLine());
		}
		question.close();

		// Imports answers and question number into hash map
		Scanner answer;
		answer = new Scanner(answersFile);

		// changes answer to boolean and checks for valid input!
		counter = 0;
		while (answer.hasNextLine()) {
			boolean ans = false;
			String bool = answer.nextLine();
			if (bool.equalsIgnoreCase("true")) {
				ans = true;
			} else if (bool.equalsIgnoreCase("false")) {
				ans = false;

			} else {
				System.out.println("Invalid Answer Input!");
			}
			questions.put(counter, ans);
			counter++;
		}
		answer.close();

		// Random question number
		int index = randIndex();

		// question and answer for enemy to use
		HashMap<String, Boolean> enemyScreen = new HashMap<String, Boolean>();

		enemyScreen.put(getQuestionString().get(index), questions.get(index));

		return enemyScreen;

	}

	/**
	 * Randomizer for the question index value Returns random in for the question
	 * array length to choose a random question
	 * 
	 * @return returns a random index for the question
	 */
	private static int randIndex() {

		Random rand = new Random();

		return rand.nextInt(getQuestionString().size() - 1);

	}

}
