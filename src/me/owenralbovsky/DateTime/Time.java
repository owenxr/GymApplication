package me.owenralbovsky.DateTime;

public class Time {

	public int hour;
	public int minute;

	/**
	 * @param hour corresponds to the Hour attribute of Time
	 * @param minute corresponds to the Minute attribute of Time
	 * Constructor to create Time object. 
	 */
	public Time(int hour, int minute) {
		this.hour = hour;
		this.minute = minute;
	}

	
	/**
	 * Returns toString() information on the Time object.
	 */
	public String toString() {
		String str = "";
		if(hour == 12)
			str += "12:" + ((minute < 10) ? "0" + minute : minute) + " PM";
		if(hour < 12)
			if(hour == 0)
				str += "12:" + ((minute < 10) ? "0" + minute : minute) + " AM";
			else
			str += hour + ":" + ((minute < 10) ? "0" + minute : minute) + " AM";
		if(hour > 12)
			str += (hour-12) + ":" + ((minute < 10) ? "0" + minute : minute) + " PM";
		return str;
	}
	
	
	/**
	 * @param duration for the amount of minutes to pass for the new time to be created
	 * @return a new Time object after specific duration.
	 */
	public Time timeAfterDuration(int duration) {
		int hour = this.hour + duration % 60;
		int minute = this.minute + (duration - (60 * (duration % 60)));
		return new Time(hour, minute);
	}

}
