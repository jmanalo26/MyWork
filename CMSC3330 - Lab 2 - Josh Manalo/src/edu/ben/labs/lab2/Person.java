package edu.ben.labs.lab2;

public class Person {
	public String name, phoneNum, email, street, city, zip, region, major;
	public int gpa;

	public Person(String name, String phoneNum, String email, String street, String city, String zip, String region,
			int gpa, String major) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.email = email;
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.region = region;
		this.gpa = gpa;
		this.major = major;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getZip() {
		return zip;
	}

	public String getRegion() {
		return region;
	}

	public int getGpa() {
		return gpa;
	}

	public String getMajor() {
		return major;
	}

	@Override
	public String toString() {
		return "'" + name + "', '" + phoneNum + "', '" + email + "', '" + street + "', '" + city + "', '" + zip + "', '"
				+ region + "', " + gpa + ", '" + major + "')";
	}

}
