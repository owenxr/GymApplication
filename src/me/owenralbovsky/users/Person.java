package me.owenralbovsky.users;

import me.owenralbovsky.DateTime.Date;

public abstract class Person {

	//Variables storing user info
	String name, gender, email;
	byte[] password;
	Date dob, created;

	/**
	 * @param name for the Person's name
	 * @param gender for the Person's gender
	 * @param email for the Person's email
	 * @param password for the Person's password
	 * @param dob for the Person's date of birth
	 */
	public Person(String name, String gender, String email, byte[] password, Date dob) {
		setName(name);
		setGender(gender);
		setEmail(email);
		setPassword(password);
		setDob(dob);
		created = Date.today;
	}
	
	/**
	 * @return the Person's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name to set the Person's name to
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the Person's gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender to set to Person
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * @return the Person's email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email to set for Person
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the Person's password
	 */
	public byte[] getPassword() {
		return password;
	}

	/**
	 * @param the password to set to the Password
	 */
	public void setPassword(byte[] password) {
		this.password = password;
	}

	/**
	 * @return the date of birth of the person
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * @param set the Date of birth for the Person
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
}
