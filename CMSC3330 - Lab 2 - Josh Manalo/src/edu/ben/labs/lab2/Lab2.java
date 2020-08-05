package edu.ben.labs.lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lab2 {

	/**
	 * Hashmap for Student file
	 */
	public static HashMap<String, Person> people = new HashMap<String, Person>();
	/**
	 * Hashmap for Major file
	 */
	public static HashMap<String, Major> majors = new HashMap<String, Major>();
	/**
	 * ArrayList to remove student row
	 */
	public static ArrayList<String> removeNames = new ArrayList<String>();
	/**
	 * ArrayList to remove major row
	 */
	public static ArrayList<String> removeMajors = new ArrayList<String>();
	
	/**
	 * Main method
	 * @param args
	 * @throws FileNotFoundException
	 * @throws SQLException
	 */
	public static void main(String[] args) throws FileNotFoundException, SQLException {
		File csvFile = new File("Lab 2 - Student Data File.csv");
		File csvFile2 = new File("Lab 2 - Student Data File - Major.csv");
		fileReader(csvFile, csvFile2);
		
		DBConnector db = new DBConnector();
		Statement line = db.getConnection().createStatement();
		
		//Check if entry already in table
		for (Map.Entry<String, Person> entry : people.entrySet()) {
			String sql = "SELECT * FROM student where Student_ID = '" + entry.getKey() + "'";
			ResultSet rs= line.executeQuery(sql);
			if (rs.next()) {
				removeNames.add(entry.getKey());
			}
		}
		
		for (Map.Entry<String, Major> entry : majors.entrySet()) {
			String sql = "SELECT * FROM major where Major_Name = '" + entry.getKey() + "'";
			ResultSet rs= line.executeQuery(sql);
			if (rs.next()) {
				removeMajors.add(entry.getKey());
			}
		}
		
		//Remove from Map if entry in table
		for (String s : removeNames) {
			if (people.containsKey(s)) {
				people.remove(s);
			}
		}
		
		for (String s: removeMajors) {
			if (majors.containsKey(s)) {
				majors.remove(s);
			}
		}
		
		//Run SQL statements and add values into table
		studentImport(line, people);
		
		majorImport(line, majors);
		
		line.close();
	
	}
	
	/**
	 * Import Student to Sql DB
	 * @param line
	 * @param students
	 * @throws SQLException
	 */
	public static void studentImport(Statement line, HashMap<String, Person> students) throws SQLException {
		for (Map.Entry<String,Person> entry : students.entrySet()) {
			String sql = "INSERT INTO student " + "VALUES (";
			String part1 = entry.getKey();
			String part2 = entry.getValue().toString();
			sql += "'" + part1 + "', " + part2;
			System.out.println(sql);
			line.execute(sql);
		}
	}
	
	/**
	 * Import Major to SQL DB
	 * @param line
	 * @param maj
	 * @throws SQLException
	 */
	public static void majorImport(Statement line, HashMap<String, Major> maj) throws SQLException {
		for (Map.Entry<String,Major> entry : maj.entrySet()) {
			String sql = "INSERT INTO major " + "VALUES (";
			String part1 = entry.getKey();
			String part2 = entry.getValue().toString();
			sql += "'" + part1 + "', " + part2;
			System.out.println(sql);
			line.execute(sql);
		}
	}
	
	/**
	 * Read CSV file and extract data
	 * @param csvFile
	 * @param csvFile2
	 * @throws FileNotFoundException
	 */
	public static void fileReader(File csvFile, File csvFile2) throws FileNotFoundException {
		Scanner fileInput = new Scanner(csvFile);
		Scanner fileInput2 = new Scanner(csvFile2);
		
		// Skip 1st line
		fileInput.nextLine();
		//Store Student data
		while (fileInput.hasNext()) {
			String words = fileInput.nextLine().replace("'", "");
			String[] row = words.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
			storePerson(row);
		}

		// Skip 1st line
		fileInput2.nextLine();	
		//Store Major data
		while (fileInput2.hasNext()) {
			String words2 = fileInput2.nextLine();
			String[] row2 = words2.split(",");
			storeMajor(row2);
		}
		fileInput.close();
		fileInput2.close();

	}

	/**
	 * Creates person object and adds to hashmap
	 * @param row
	 */
	public static void storePerson(String[] row) {
		// row[3] = ID of Student
		Person p = new Person(row[0], row[1], row[2], row[4], row[5], row[6], 
				row[7], Integer.parseInt(row[8]), row[9]);
		if (!people.containsKey(row[3])) {
			people.put(row[3], p);
		}
		System.out.println(p.toString());
	}

	/**
	 * Creates major object and stores into map
	 * @param row2
	 */
	public static void storeMajor(String[] row2) {
		if (row2.length == 4) {
			ArrayList<String> collegeList = new ArrayList<String>();
			ArrayList<String> clList = new ArrayList<String>();
			ArrayList<String> dlList = new ArrayList<String>();

			//Case of non-existing Major
			if (!majors.containsKey(row2[0])) {
				collegeList.add(row2[3]);
				clList.add(row2[1]);
				dlList.add(row2[2]);
				Major x = new Major(collegeList, clList, dlList);
				majors.put(row2[0], x);
			} 
			
			//Case of existing major
			else {
				collegeList = majors.get(row2[0]).getCollege();
				clList = majors.get(row2[0]).getClassifications();
				dlList = majors.get(row2[0]).getDegreeLevels();
				
				//Account for Duplication
				if (!collegeList.contains(row2[3])) {
					collegeList.add(row2[3]);
				}
				if (!clList.contains(row2[1])) {
					clList.add(row2[1]);
				}
				if (!dlList.contains(row2[2])) {
					dlList.add(row2[2]);
				}
				Major x = new Major(collegeList, clList, dlList);
				majors.replace(row2[0], x);
			}
		}
	}
}
