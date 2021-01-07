package me.owenralbovsky.users;

import java.util.ArrayList;
import java.util.Scanner;

import me.owenralbovsky.DateTime.Date;
import me.owenralbovsky.password.PasswordManager.pm;

public class Admin extends Person {

	public static ArrayList<Admin> admins = new ArrayList<>();
	
	public final boolean isAdmin = true;

	public int level;

	/**
	 * @param name for the User's name
	 * @param gender for the User's gender
	 * @param email for the User's email
	 * @param password for the User's password
	 * @param dob for the User's Date of Birth
	 * @param level for the User's priority level/rank
	 */
	public Admin(String name, String gender, String email, byte[] password, Date dob, int level) {
		super(name, gender, email, password, dob);
		this.level = level;
		admins.add(this);
	}

	/**
	 * Prompts the Admin for information to create another Admin
	 */
	public static void createAdmin()
	{
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please Enter Admin's Name (First Last): ");
		String name = input.nextLine();
		
		System.out.println("Please Enter Admin's Email: ");
		String email = input.nextLine();
		
		System.out.println("Please Enter Admin's Gender: ");
		String gender = input.nextLine();
		
		System.out.println("Please Create a Password: ");
		byte[] password = pm.hashPassword(input.nextLine());
		
		System.out.println("Please Indicate Admin's priority level 1-2 (1-Manager, 2-Trainer): ");
		int level = Integer.parseInt(input.nextLine().trim().replaceAll(" ", ""));
		
		System.out.println("Please Enter Admin's Date Of Birth as MM/DD/YYYY: ");
		String[] dobStr = input.nextLine().split("/");
		Date dob = new Date(Integer.parseInt(dobStr[0]), Integer.parseInt(dobStr[1]), Integer.parseInt(dobStr[2]));
		
		new Admin(name, gender, email, password, dob, level);
		System.out.println("Admin " + name + " created.");
	}
	
}
