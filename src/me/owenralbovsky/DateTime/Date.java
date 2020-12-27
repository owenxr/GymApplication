package me.owenralbovsky.DateTime;

import java.util.ArrayList;

import me.owenralbovsky.activities.Event;

public class Date {

	public static Date today;
	
	public ArrayList<Event> events = new ArrayList<>();
	
	public int month, day, year;
	
	public Date(int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
		Calendar.days.add(this);
	}
	
	public void addEvent(Event e) {
		events.add(e);
	}
	
	public String toString() {
		return month + "/" + day + "/" + year;
	}

}
