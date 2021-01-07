package me.owenralbovsky.users;

import java.util.ArrayList;

import me.owenralbovsky.DateTime.Date;

public class Customer extends Person{

	public static ArrayList<Customer> customer = new ArrayList<>();
	
	public final boolean isAdmin = false;

	/**
	 * @param name for the Customer's name
	 * @param gender for the Customer's gender
	 * @param email for the Customer's email
	 * @param password for the Customer's password
	 * @param dob for the Customer's date of birth
	 * @param created for the Customer's date of account creation.
	 */
	public Customer(String name, String gender, String email, byte[] password, Date dob, Date created) {
		super(name, gender, email, password, dob);
		customer.add(this);
	}
	
}
