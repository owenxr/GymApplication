package me.owenralbovsky.Action;

import java.util.Scanner;

import me.owenralbovsky.main.Main;
import me.owenralbovsky.users.Admin;

public class ManagerActions {

	static Scanner input = new Scanner(System.in);

	/**
	 * Functions as the "manager interaction" section.
	 * Redirects user to a specific class based on selected action.
	 */
	public static void actions() {
		
		while(true)
		{
			System.out.println("Enter an action (quit, logout, ct (create trainer), cs (create session): ");
			String action = input.nextLine().trim().toLowerCase();
			
			switch(action) {
			//Only a Manager can quit the app.
			case "quit":
				Main.quit = true;
				return;
			case "logout":
				Main.loggedIn = null;
				return;
			case "ct":
				Admin.createAdmin();
				break;
			case "cs":
				CreateSession.createSession();
			}
		}
		
	}

}
