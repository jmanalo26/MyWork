package edu.ben.labs.lab3;

public class Restaurant {
	private int ID;
	private String name;
	private String email;
	private String phoneNum;
	private int addressID;
	
	public Restaurant(int ID, String name, String email, String phoneNum, int addressID) {
		this.ID = ID;
		this.name = name;
		this.email = email;
		this.phoneNum = phoneNum;
		this.addressID = addressID;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getAddressID() {
		return addressID;
	}

	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}

	@Override
	public String toString() {
		return "'" + ID + "', '" + name + "', '" + email + "', '" + phoneNum
				+ "', '" + addressID + "')";
	}
	
	

}
