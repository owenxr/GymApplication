package me.owenralbovsky.Action;

import java.util.Scanner;

import me.owenralbovsky.DateTime.Date;
import me.owenralbovsky.DateTime.Time;
import me.owenralbovsky.activities.Session;
import me.owenralbovsky.users.Admin;

public class CreateSession {
	
	static Scanner input = new Scanner(System.in);
	
	public static void createSession() {
		System.out.println("Give the name of the session: ");
		String title = input.nextLine().trim().toUpperCase();
		
		System.out.println("Please give the session date as MM/DD/YYYY: ");
		String[] date = input.nextLine().trim().split("/");
		Date d = new Date(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
		
		System.out.println("Give the start time as HH:MM in 24 hour time: ");
		String[] time = input.nextLine().trim().split(":");
		Time start = new Time(Integer.parseInt(time[0]), Integer.parseInt(time[1]));
		
		System.out.println("Give the duration in minutes: ");
		int endMin = input.nextInt();
		Time end = start.timeAfterDuration(endMin);
		
		System.out.println("Enter capacity for session: ");
		int limit = input.nextInt();

		Admin[] t = new Admin[Admin.admins.size()];
		Admin trainer = null;
		boolean found = false;
		while(!found) {
			System.out.println("Possible Trainers:");
			for(Admin a : Admin.admins) {
				System.out.println(a.getName());
			}
			System.out.println("Enter the trainer's name: ");
			input.nextLine().trim();
			String name = input.nextLine().trim();
			for(Admin a : Admin.admins) {
				if(a.getName().equalsIgnoreCase(name)) {
					if(t.length == 0) t[0] = a;
					else t[t.length - 1] = a;
				}
			}
			if(t.length == 0) {
				System.out.println("Trainer " + name + " was not found.");
			}
			else if(t.length == 1) {
				System.out.println("Trainer " + name + " is signed up for session.");
				trainer = t[0];
				found = true;
			}
			else {
				System.out.println("There are multiple trainer's with that name. Select a number option.");
				for(int i = 0; i < t.length; i++) {
					System.out.println((i + 1) + ") " + t[i].getEmail());
				}
				int option = input.nextInt();
				trainer = t[option-1];
				System.out.println("Trainer " + trainer.getEmail() + " selected.");
				found = true;
			}
		}
		
		d.addEvent(new Session(title, d, start, end, limit, trainer));
		
	}
	
}
