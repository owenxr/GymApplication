package me.owenralbovsky.DateTime;

import java.util.ArrayList;

import me.owenralbovsky.activities.Event;

public class Date {

	public static Date today;
	public ArrayList<Event> events = new ArrayList<>();
	public int month, day, year;

	
	/**
	 * @param month to specify Month in Date
	 * @param day to specify Day in Date
	 * @param year to specify Year in Date.
	 * Constructor for Date object.
	 */
	public Date(int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
		Calendar.days.add(this);
	}
	
	/**
	 * @param e for the event to added.
	 * Adds an event to a certain day.
	 */
	public void addEvent(Event e) {
		events.add(e);
	}
	
	/**
	 * @param e for the event to be removed.
	 * Remove's an event from list.
	 */
	public void removeEvent(Event e) {
		events.remove(e);
	}
	
	
	/**
	 * @param name for the name of the event to be removed.
	 * TODO removes event by name.
	 */
	public void removeEvent(String name) {
		
	}
	
	/**
	 * returns toString() information about Date object.
	 */
	public String toString() {
		return month + "/" + day + "/" + year;
	}

}
