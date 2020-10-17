package edu.ben.labs.lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * This code will import CSV data into our MySQL database.
 * @author Josh Manalo
 *
 */
public class Lab3 {
	public static HashMap<Integer, Customer> customerList = new HashMap<Integer, Customer>();
	public static HashMap<Integer, Employee> employeeList = new HashMap<Integer, Employee>();
	public static HashMap<Integer, Address> addressList = new HashMap<Integer, Address>();
	public static HashMap<Integer, Restaurant> restaurantList = new HashMap<Integer, Restaurant>();

	public static ArrayList<Integer> duplicateCustomers = new ArrayList<Integer>();
	public static ArrayList<Integer> duplicateEmployees = new ArrayList<Integer>();
	public static ArrayList<Integer> duplicateAddresses = new ArrayList<Integer>();
	public static ArrayList<Integer> duplicateRestaurants = new ArrayList<Integer>();
	
	public static void main(String[] args) throws FileNotFoundException, SQLException {
		File csvFile = new File("Customer.csv");
		File csvFile2 = new File("Employee.csv");
		File csvFile3 = new File("Address.csv");
		File csvFile4 = new File("Restaurant.csv");
		fileReader(csvFile, csvFile2, csvFile3, csvFile4);
	}

	public static void fileReader(File customerFile, File employeeFile, File addressFile, File restaurantFile)
			throws FileNotFoundException, SQLException {
		DBConnector db = new DBConnector();
		Statement line = db.getConnection().createStatement();

		// Scan Item files
		Scanner fileInput = new Scanner(customerFile);
		Scanner fileInput2 = new Scanner(employeeFile);
		Scanner fileInput3 = new Scanner(addressFile);
		Scanner fileInput4 = new Scanner(restaurantFile);
		fileInput.nextLine();

		// Store Item data
		while (fileInput.hasNext()) {
			String words = fileInput.nextLine();
			String[] row = words.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
			createCustomer(row);
		}

		fileInput2.nextLine();
		while (fileInput2.hasNext()) {
			String words = fileInput2.nextLine();
			String[] row = words.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
			createEmployee(row);
		}

		fileInput3.nextLine();
		while (fileInput3.hasNext()) {
			String words = fileInput3.nextLine();
			String[] row = words.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
			createAddress(row);
		}

		fileInput4.nextLine();
		while (fileInput4.hasNext()) {
			String words = fileInput4.nextLine();
			String[] row = words.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
			createRestaurant(row);
		}

		fileInput.close();
		fileInput2.close();
		fileInput3.close();
		fileInput4.close();

		// Check if entry already in table
		for (Map.Entry<Integer, Customer> entry : customerList.entrySet()) {
			String sql = "SELECT * FROM customer where customerID = '" + entry.getKey() + "'";
			ResultSet rs = line.executeQuery(sql);
			if (rs.next()) {
				duplicateCustomers.add(entry.getKey());
			}
		}

		// Check if entry already in table
		for (Map.Entry<Integer, Employee> entry : employeeList.entrySet()) {
			String sql = "SELECT * FROM employee where employeeID = '" + entry.getKey() + "'";
			ResultSet rs = line.executeQuery(sql);
			if (rs.next()) {
				duplicateEmployees.add(entry.getKey());
			}
		}

		// Check if entry already in table
		for (Map.Entry<Integer, Address> entry : addressList.entrySet()) {
			String sql = "SELECT * FROM address where addressID = '" + entry.getKey() + "'";
			ResultSet rs = line.executeQuery(sql);
			if (rs.next()) {
				duplicateAddresses.add(entry.getKey());
			}
		}

		// Check if entry already in table
		for (Map.Entry<Integer, Restaurant> entry : restaurantList.entrySet()) {
			String sql = "SELECT * FROM restaurant where restaurantID = '" + entry.getKey() + "'";
			ResultSet rs = line.executeQuery(sql);
			if (rs.next()) {
				duplicateRestaurants.add(entry.getKey());
			}
		}

		// Remove from Map if entry in table
		for (Integer s : duplicateCustomers) {
			if (customerList.containsKey(s)) {
				customerList.remove(s);
			}
		}

		for (Integer s : duplicateEmployees) {
			if (employeeList.containsKey(s)) {
				employeeList.remove(s);
			}
		}

		for (Integer s : duplicateAddresses) {
			if (addressList.containsKey(s)) {
				addressList.remove(s);
			}
		}
		
		for (Integer s : duplicateRestaurants) {
			if (restaurantList.containsKey(s)) {
				restaurantList.remove(s);
			}
		}

		customerImport(line);
		employeeImport(line);
		addressImport(line);
		restaurantImport(line);

		line.close();

	}

	public static void createCustomer(String[] item) {
		Customer newCustomer = new Customer(0, null, null, null, null, null, null, 0, 0, 0);
		newCustomer.setID(Integer.parseInt(item[0]));
		newCustomer.setFirstName(item[1]);
		newCustomer.setLastName(item[2]);
		newCustomer.setEmail(item[3]);
		newCustomer.setPhoneNum(item[4]);
		newCustomer.setDateOfBirth(item[5]);
		newCustomer.setEntryDate(item[6]);
		if (item[7].contains("x")) {
			item[7] = "1";
		} else {
			item[7] = "0";
		}
		newCustomer.setCovidPositive(Integer.parseInt(item[7]));
		newCustomer.setAddressID(Integer.parseInt(item[8]));
		newCustomer.setRestaurantID(Integer.parseInt(item[9]));
		customerList.put(newCustomer.getID(), newCustomer);
	}

	public static void createEmployee(String[] item) {
		Employee newEmployee = new Employee(0, null, null, null, null, null, null, 0, 0, 0);
		newEmployee.setID(Integer.parseInt(item[0]));
		newEmployee.setFirstName(item[1]);
		newEmployee.setLastName(item[2]);
		newEmployee.setEmail(item[3]);
		newEmployee.setPhoneNum(item[4]);
		newEmployee.setDateOfBirth(item[5]);
		newEmployee.setEntryDate(item[6]);
		if (item[7].contains("x")) {
			item[7] = "1";
		} else {
			item[7] = "0";
		}
		newEmployee.setCovidPositive(Integer.parseInt(item[7]));
		newEmployee.setAddressID(Integer.parseInt(item[8]));
		newEmployee.setRestaurantID(Integer.parseInt(item[9]));
		employeeList.put(newEmployee.getID(), newEmployee);
	}

	public static void createAddress(String[] item) {
		Address newAddress = new Address(0, null, null, null, null, null, 0);
		newAddress.setID(Integer.parseInt(item[0]));
		newAddress.setStreet1(item[1]);
		newAddress.setStreet2(item[2]);
		newAddress.setStreet3(item[3]);
		newAddress.setCity(item[4]);
		newAddress.setState(item[5]);
		newAddress.setPostalCode(Integer.parseInt(item[6]));
		addressList.put(newAddress.getID(), newAddress);
	}

	public static void createRestaurant(String[] item) {
		Restaurant place = new Restaurant(0, null, null, null, 0);
		place.setID(Integer.parseInt(item[0]));
		place.setName(item[1]);
		place.setEmail(item[2]);
		place.setPhoneNum(item[3]);
		place.setAddressID(Integer.parseInt(item[4]));
		restaurantList.put(place.getID(), place);
	}

	public static void customerImport(Statement line) throws SQLException {
		for (Map.Entry<Integer, Customer> entry : customerList.entrySet()) {
			String sql = "INSERT INTO customer " + "VALUES (";
			sql += entry.getValue().toString();
			line.execute(sql);
			System.out.println("Table Updated: " + entry.getKey());
		}
	}

	public static void employeeImport(Statement line) throws SQLException {
		for (Map.Entry<Integer, Employee> entry : employeeList.entrySet()) {
			String sql = "INSERT INTO employee " + "VALUES (";
			sql += entry.getValue().toString();
			line.execute(sql);
			System.out.println("Table Updated: " + entry.getKey());

		}
	}

	public static void addressImport(Statement line) throws SQLException {
		for (Map.Entry<Integer, Address> entry : addressList.entrySet()) {
			String sql = "INSERT INTO address " + "VALUES (";
			sql += entry.getValue().toString();
			line.execute(sql);
			System.out.println("Table Updated: " + entry.getKey());
		}
	}
	
	public static void restaurantImport(Statement line) throws SQLException {
		for (Map.Entry<Integer, Restaurant> entry : restaurantList.entrySet()) {
			String sql = "INSERT INTO restaurant " + "VALUES (";
			sql += entry.getValue().toString();
			line.execute(sql);
			System.out.println("Table Updated: " + entry.getKey());
		}
	}

}
