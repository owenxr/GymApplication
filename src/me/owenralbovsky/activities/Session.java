package me.owenralbovsky.activities;

import me.owenralbovsky.DateTime.Date;
import me.owenralbovsky.DateTime.Time;
import me.owenralbovsky.users.Admin;

public class Session extends Event{
	
	public Admin trainer;
	
	/**
	 * @param title for the name of the session
	 * @param d for the Date the session is occurring.
	 * @param start for the Time 
	 * @param end
	 * @param peopleLimit
	 * @param trainer
	 * Constructor for Session object.
	 */
	public Session(String title, Date d, Time start, Time end, int peopleLimit, Admin trainer) {
		super(title, d, start, end, peopleLimit);
		this.trainer = trainer;
	}

	/**
	 * Returns toString() information on a Session.
	 */
	public String toString() {
		String str = title + " with Trainer " + trainer.getName();
		str +=  "\nThe event will take place on " + d + " at " + start;
		str += "\nThere are " + d.events.size() + " people attending.";
		return str;
	}

}
