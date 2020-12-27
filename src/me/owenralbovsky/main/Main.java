package me.owenralbovsky.main;

import java.time.LocalDateTime;
import java.util.Scanner;

import me.owenralbovsky.Action.CustomerActions;
import me.owenralbovsky.Action.Login;
import me.owenralbovsky.Action.ManagerActions;
import me.owenralbovsky.Action.SignUp;
import me.owenralbovsky.Action.TrainerActions;
import me.owenralbovsky.DateTime.Date;
import me.owenralbovsky.users.Admin;
import me.owenralbovsky.users.Person;

public class Main {

	private static Scanner input = new Scanner(System.in);

	public static Person loggedIn;
	public static boolean quit = false;

	public static void main(String[] args) {
		LocalDateTime today = LocalDateTime.now();
		Date.today = new Date(today.getMonthValue(), today.getDayOfMonth(), today.getYear());

		startApp();

	}

	public static void startApp() {

		if (Admin.admins.size() <= 0)
			Admin.createAdmin();

		while (true) {
			if(quit) return;
			
			if (loggedIn == null) {

				System.out.println("Enter an action (login, sign up): ");
				String action = input.nextLine().trim().toLowerCase();

				switch (action) {
				case "login":
					Login.login();
					break;
				case "sign up":
					SignUp.signUp();
				}

			} else {

				boolean isAdmin = false;

				for (Person p : Admin.admins) {
					if (p.equals(loggedIn)) {
						isAdmin = true;
						break;
					}
				}

				if (isAdmin) {
					if (((Admin) loggedIn).level == 1)
						ManagerActions.actions();
					else
						TrainerActions.actions();
				} else {
					CustomerActions.actions();
				}

			}
		}
	}

}
