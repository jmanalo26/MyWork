package edu.ben.labs.lab3;

public class Customer {
	private int ID;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNum;
	private String dateOfBirth;
	private String entryDate;
	private int covidPositive;
	private int addressID;
	private int restaurantID;

	public Customer(int ID, String firstName, String lastName, String email, String phoneNum, String dateOfBirth,
			String entryDate, int covidPositive, int addressID, int restaurantID) {
		this.ID = ID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNum = phoneNum;
		this.dateOfBirth = dateOfBirth;
		this.entryDate = entryDate;
		this.covidPositive = covidPositive;
		this.addressID = addressID;
		this.restaurantID = restaurantID;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	public int getCovidPositive() {
		return covidPositive;
	}

	public void setCovidPositive(int covidPositive) {
		this.covidPositive = covidPositive;
	}

	public int getAddressID() {
		return addressID;
	}

	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}
	

	public int getRestaurantID() {
		return restaurantID;
	}

	public void setRestaurantID(int restaurantID) {
		this.restaurantID = restaurantID;
	}

	@Override
	public String toString() {
		return "'" + ID + "', '" + firstName + "', '" + lastName + "', '" + email + "', '" + phoneNum + "', '"
				+ dateOfBirth + "', '" + entryDate + "', '" + covidPositive + "', '" + addressID + "', '" + restaurantID + "')";
	}

}
