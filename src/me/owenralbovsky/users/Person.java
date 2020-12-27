package me.owenralbovsky.users;

import me.owenralbovsky.DateTime.Date;

public abstract class Person {

	String name, gender, email;
	byte[] password;
	Date dob, created;

	public Person(String name, String gender, String email, byte[] password, Date dob) {
		setName(name);
		setGender(gender);
		setEmail(email);
		setPassword(password);
		setDob(dob);
		created = Date.today;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * @return the gender
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public byte[] getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(byte[] password) {
		this.password = password;
	}

	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
}
