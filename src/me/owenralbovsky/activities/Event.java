package me.owenralbovsky.activities;

import java.util.ArrayList;

import me.owenralbovsky.DateTime.Date;
import me.owenralbovsky.DateTime.Time;
import me.owenralbovsky.users.Person;

public abstract class Event {

	public ArrayList<Person> attendees = new ArrayList<>();

	public String title;
	public Date d;
	public Time start, end;
	public int peopleLimit;
	
	public Event(String title, Date d, Time start, Time end, int peopleLimit) {
		this.title = title;
		this.d = d;
		this.start = start;
		this.end = end;
		this.peopleLimit = peopleLimit;
	}
	
	public boolean addAttendee(Person p) {
		if(attendees.size() >= peopleLimit) return false;
		else attendees.add(p);
		return true;
	}
	
	public abstract String toString();
	
}
