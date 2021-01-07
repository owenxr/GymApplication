package me.owenralbovsky.activities;

import java.util.ArrayList;

import me.owenralbovsky.DateTime.Date;
import me.owenralbovsky.DateTime.Time;
import me.owenralbovsky.users.Person;

public abstract class Event {

	//Create variable pertinent to the properties of an Event.
	public ArrayList<Person> attendees = new ArrayList<>();
	public String title;
	public Date d;
	public Time start, end;
	public int peopleLimit;
	
	/**
	 * @param title for the Title of the event
	 * @param d for the Date of the event occurring.
	 * @param start for the Start time of the event.
	 * @param end for the End time of the event.
	 * @param peopleLimit for the number of people allowed at the event
	 * Constructor for Event object
	 */
	public Event(String title, Date d, Time start, Time end, int peopleLimit) {
		this.title = title;
		this.d = d;
		this.start = start;
		this.end = end;
		this.peopleLimit = peopleLimit;
	}
	
	/**
	 * @param p which resembles the Person trying to be added to the event. 
	 * @return boolean true if Person could be added to attendees, otherwise it will return false.
	 */
	public boolean addAttendee(Person p) {
		if(attendees.size() >= peopleLimit) return false;
		else attendees.add(p);
		return true;
	}
	
	public abstract String toString();
	
}
