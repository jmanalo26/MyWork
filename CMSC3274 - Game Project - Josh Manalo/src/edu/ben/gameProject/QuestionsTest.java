package edu.ben.gameProject;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;

public class QuestionsTest {
	
	File questionFile = new File("questions.txt");
	File answersFile = new File("answers.txt");

	/**
	 * Tests if the method correctly reads the file
	 * @throws FileNotFoundException
	 */
	@Test
	public void printHashtest() throws FileNotFoundException {
		System.out.println(Questions.fileReader(questionFile, answersFile).toString());
	}
	
	/**
	 * Tests if FileNotFoundException is working correctly
	 * @throws FileNotFoundException
	 */
	@Test (expected = Exception.class)
	public void fileExceptionTest() throws FileNotFoundException {
		Questions.fileReader(new File("NOTAFILE.txt"), answersFile);
	}
	
	/**
	 * Tests number of questions put into arraylist for Hashmap
	 * @throws FileNotFoundException
	 */
	@Test
	public void questionStringTest() throws FileNotFoundException {
		Questions.fileReader(questionFile, answersFile);
		int expected = 40;
		int actual = Questions.questionString.size();
		assertEquals(expected, actual);
	}
	
	/**
	 * Tests for all questions being inserted into arraylist properly
	 * @throws FileNotFoundException
	 */
	@Test
	public void questionStringPrintTest() throws FileNotFoundException {
		Questions.fileReader(questionFile, answersFile);
		for (String s: Questions.questionString) {
			System.out.println(s);
		}
	}
	

}
