package edu.ben.labs.lab3;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Test;

import edu.ben.labs.lab2.DBConnector;
import edu.ben.labs.lab2.Lab2;
import edu.ben.labs.lab2.Major;
import edu.ben.labs.lab2.Person;

/**
 * Lab 3 - Test Cases for Lab2 2
 * @author Josh Manalo
 * @version 1.0
 */
public class Lab3_Lab2_Test {

	/**
	 * Select Test for Student
	 * @throws SQLException
	 * @throws FileNotFoundException
	 */
	@Test
	public void daoTest1() throws SQLException, FileNotFoundException {
		Lab2.main(null);
		DBConnector db = new DBConnector();
		String ID = "PL12582750481069026967512197";
		String SQL = "SELECT * FROM student WHERE (Student_ID = '" + ID + "')";
		Statement ps = db.getConnection().prepareStatement(SQL);
		ResultSet rs = ps.executeQuery(SQL);
		boolean check = false;
		if (rs.next()) {
			check = true;
		}
		assertTrue(check);
		db.closeConnection();
	}
	/**
	 * Select Test for Major
	 * @throws SQLException
	 * @throws FileNotFoundException
	 */
	@Test
	public void daoTest1Major() throws SQLException, FileNotFoundException {
		Lab2.main(null);
		DBConnector db = new DBConnector();
		String ID = "Accountancy";
		String SQL = "SELECT * FROM major WHERE (Major_Name = '" + ID + "')";
		Statement ps = db.getConnection().prepareStatement(SQL);
		ResultSet rs = ps.executeQuery(SQL);
		boolean check = false;
		if (rs.next()) {
			check = true;
		}
		assertTrue(check);
		db.closeConnection();
	}
	
	/**
	 * Invalid Select Test
	 * @throws SQLException
	 */
	@Test
	public void daoTest2() throws SQLException {
		DBConnector db = new DBConnector();
		String ID = "TOTALLYnotANid";
		String SQL = "SELECT * FROM student WHERE (Student_ID = '" + ID + "')";
		Statement ps = db.getConnection().prepareStatement(SQL);
		ResultSet rs = ps.executeQuery(SQL);
		boolean check = false;
		if (rs.next()) {
			check = true;
		}
		assertFalse(check);
		db.closeConnection();
	}
	
	/**
	 * Insert Test for Student Import Method
	 * @throws SQLException
	 * @throws FileNotFoundException
	 */
	@Test
	public void daoTest3() throws SQLException, FileNotFoundException {
		DBConnector db = new DBConnector();
		String ID = "b2377412";
		Person me = new Person("Josh Manalo", "630-631-4045", "b2377412@ben.edu", "374 Clubhouse St.", "Bolingbrook",
				"60490", "IL", 4, "Computer Science");
		
		//Check if in DB, add if not
		String SQL = "SELECT * FROM student WHERE (Student_ID = '" + ID + "')";
		Statement ps = db.getConnection().prepareStatement(SQL);
		ResultSet rs = ps.executeQuery(SQL);
		Lab2.people.put(ID, me);
		Lab2.main(null);
		String fName = null;
		if (rs.next()) {
			fName = rs.getString("Student_Name");
		}
		assertEquals("Josh Manalo", fName);
		db.closeConnection();
	}
	
	/**
	 * Insert Test for Major Import Test
	 * @throws SQLException
	 * @throws FileNotFoundException
	 */
	@Test
	public void daoTest4() throws SQLException, FileNotFoundException {
		DBConnector db = new DBConnector();
		String ID = "NewMajor";
		ArrayList<String> college = new ArrayList<String>();
		college.add("College of Stuff");
		ArrayList<String> classif = new ArrayList<String>();
		classif.add("Graduate");
		ArrayList<String> degree = new ArrayList<String>();
		degree.add("B.A.");
		Major m = new Major(college, classif, degree);
		Lab2.majors.put(ID, m);
		
		//Check if in DB, add if not
		String SQL = "SELECT * FROM major WHERE (Major_Name = '" + ID + "')";
		Statement ps = db.getConnection().prepareStatement(SQL);
		ResultSet rs = ps.executeQuery(SQL);
		Lab2.main(null);
		String cName = null;
		if (rs.next()) {
			cName = rs.getString("Major_College");
		}
		assertEquals("[" + college.get(0).toString() + "]", cName);
		db.closeConnection();
	}
	
	/**
	 * Invalid Statement Test
	 * @throws FileNotFoundException
	 * @throws SQLException
	 */
	@Test(expected = SQLException.class)
	public void sqlExceptionTest() throws FileNotFoundException, SQLException {
		DBConnector db = new DBConnector();
		String ID = "PL12582750481069026967512197";
		String SQL = "NotASQLStatement * FROM student WHERE (Student_ID = '" + ID + "')";
		Statement ps = db.getConnection().prepareStatement(SQL);
		ResultSet rs = ps.executeQuery(SQL);
		rs.close();
		db.closeConnection();
	}
	
	/**
	 * Invalid File Test
	 * @throws FileNotFoundException
	 * @throws SQLException
	 */
	@Test(expected = FileNotFoundException.class)
	public void fileExceptionTest() throws FileNotFoundException, SQLException {
		File notAFile = new File("notAFile.txt");
		Lab2.fileReader(notAFile, notAFile);
	}
	
	/**
	 * Test for new student
	 */
	@Test
	public void storeTestStudent() {
		String[] me = {"a","b","c","d","e","f","g","h","0", "i"};
		Lab2.storePerson(me);
		Person result = Lab2.people.get("d");
		assertEquals(result.getGpa(), 0);
	}
	
	/**
	 * Test for new major
	 */
	@Test
	public void storeTestMajor() {
		String[] me = {"a","b","c","d"};
		Lab2.storeMajor(me);
		Major result = Lab2.majors.get("a");
		assertEquals(result.getCollege().get(0), "d");
	}

}
