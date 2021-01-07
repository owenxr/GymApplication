package me.owenralbovsky.Action;

import java.util.Scanner;

import me.owenralbovsky.main.Main;
import me.owenralbovsky.password.PasswordManager.pm;
import me.owenralbovsky.users.Admin;
import me.owenralbovsky.users.Customer;
import me.owenralbovsky.users.Person;

public class Login {

	static Scanner input = new Scanner(System.in);

	/**
	 * Login function. Takes in an email and password and checks to see if current account exists and is valid.
	 */
	public static void login() {

		boolean found = false;

		Person person = null;

		while (!found) {
			System.out.println("Please enter your email or type exit to exit login: ");
			String email = input.nextLine();

			if (email.equalsIgnoreCase("exit"))
				return;

			for (Person p : Customer.customer) {
				if (p.getEmail().equals(email)) {
					person = p;
					found = true;
					break;
				}
			}

			for (Person p : Admin.admins) {
				if (p.getEmail().equals(email)) {
					person = p;
					found = true;
					break;
				}
			}

			if (person == null) {
				System.out.println("Account does not exit. Please use the create action to create an account.");
			}

		}

		found = false;
		while (!found) {
			System.out.println("Please enter your password: ");
			String password = input.nextLine();

			if (password.equalsIgnoreCase("exit"))
				return;

			if (pm.checkPassword(person, password)) {
				System.out.println("Success. Hello " + person.getName());
				found = true;
				Main.loggedIn = person;
			} else {
				System.out.println("Password incorrect try again or type exit to exit.");
			}
		}

	}

}
