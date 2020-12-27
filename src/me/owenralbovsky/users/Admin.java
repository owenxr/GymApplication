package me.owenralbovsky.users;

import java.util.ArrayList;
import java.util.Scanner;

import me.owenralbovsky.DateTime.Date;
import me.owenralbovsky.password.PasswordManager.pm;

public class Admin extends Person {

	public static ArrayList<Admin> admins = new ArrayList<>();
	
	public final boolean isAdmin = true;

	public int level;

	public Admin(String name, String gender, String email, byte[] password, Date dob, int level) {
		super(name, gender, email, password, dob);
		this.level = level;
		admins.add(this);
	}

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
