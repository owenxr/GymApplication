package me.owenralbovsky.Action;

import java.util.Scanner;

import me.owenralbovsky.DateTime.Date;
import me.owenralbovsky.password.PasswordManager.pm;
import me.owenralbovsky.users.Customer;

public class SignUp {

	static Scanner input = new Scanner(System.in);
	
	public static void signUp()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please Enter Your Name (First Last): ");
		String name = input.nextLine().trim();
		
		System.out.println("Please Enter Your Email: ");
		String email = input.nextLine().trim();
		
		System.out.println("Please Enter Your Gender: ");
		String gender = input.nextLine();
		
		System.out.println("Please Create a Password: ");
		byte[] password = pm.hashPassword(input.nextLine());
		
		System.out.println("Please Enter Your Date Of Birth as Month/Day/Year: ");
		String[] dobStr = input.nextLine().split("/");
		Date dob = new Date(Integer.parseInt(dobStr[0]), Integer.parseInt(dobStr[1]), Integer.parseInt(dobStr[2]));
		
		new Customer(name, gender, email, password, dob, Date.today);
		System.out.println("Alright " + name + "! You're account is ready to go just login");
	}
	
}
