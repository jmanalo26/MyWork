package edu.ben.labs.lab3;

public class Address {
	private int ID;
	private String street1;
	private String street2;
	private String street3;
	private String city;
	private String state;
	private int postalCode;
	
	public Address(int ID, String street1, String street2, String street3, String city, String state, int postalCode) {
		this.ID = ID;
		this.street1 = street1;
		this.street2 = street2;
		this.street3 = street3;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getStreet3() {
		return street3;
	}

	public void setStreet3(String street3) {
		this.street3 = street3;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	@Override
	public String toString() {
		return "'" + ID + "', '" + street1 + "', '" + street2 + "', '" + street3
				+ "', '" + city + "', '" + state + "', '" + postalCode + "')";
	}
	
	

}
