package me.owenralbovsky.DateTime;

import java.util.ArrayList;

public class Calendar {

	public static ArrayList<Date> days = new ArrayList<>();
	
	public boolean validDay(int year, int month, int day) {

		if (day <= 0)
			return false;

		switch (month) {
		case 1:
			if (day <= 31)
				return true;
			break;
		case 2:
			if (year % 4 == 0 && year % 100 == 0 && year % 400 == 0) {
				if (day <= 29)
					return true;
			} else {
				if (day <= 28)
					return true;
			}
			break;
		case 3:
			if (day <= 31)
				return true;
			break;
		case 4:
			if (day <= 30)
				return true;
			break;
		case 5:
			if (day <= 31)
				return true;
			break;
		case 6:
			if (day <= 30)
				return true;
			break;
		case 7:
			if (day <= 31)
				return true;
			break;
		case 8:
			if (day <= 31)
				return true;
			break;
		case 9:
			if (day <= 30)
				return true;
			break;
		case 10:
			if (day <= 31)
				return true;
			break;
		case 11:
			if (day <= 30)
				return true;
			break;
		case 12:
			if (day <= 31)
				return true;
			break;
		}

		return false;
	}

	
}
