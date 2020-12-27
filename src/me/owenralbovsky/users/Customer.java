package me.owenralbovsky.users;

import java.util.ArrayList;

import me.owenralbovsky.DateTime.Date;

public class Customer extends Person{

	public static ArrayList<Customer> customer = new ArrayList<>();
	
	public final boolean isAdmin = false;

	public Customer(String name, String gender, String email, byte[] password, Date dob, Date created) {
		super(name, gender, email, password, dob);
		customer.add(this);
	}
	
}
