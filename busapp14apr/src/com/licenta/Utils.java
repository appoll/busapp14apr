package com.licenta;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Utils {
	public static long secondsToArrival (String time)
	{
		Calendar current = Calendar.getInstance();
		Calendar random = new GregorianCalendar(current.get(Calendar.YEAR),
												current.get(Calendar.MONTH),
												current.get(Calendar.DAY_OF_MONTH));
		String [] tokens = time.split(":");
		random.set(Calendar.HOUR, current.get(Calendar.HOUR_OF_DAY));
		random.set(Calendar.MINUTE, Integer.parseInt(tokens[1]));
		random.set(Calendar.SECOND, Integer.parseInt(tokens[2]));
		
		Date d1 = current.getTime();
		Date d2 = random.getTime();
		
		long seconds = (d2.getTime()-d1.getTime())/1000;
		
		return seconds;	
	}
	
	public static long secondsToArrivalNextHour (String time)
	{
		Calendar current = Calendar.getInstance();

		Calendar random = new GregorianCalendar(current.get(Calendar.YEAR),
												current.get(Calendar.MONTH),
												current.get(Calendar.DAY_OF_MONTH));
		String [] tokens = time.split(":");
		random.set(Calendar.HOUR, current.get(Calendar.HOUR_OF_DAY)+1);
		random.set(Calendar.MINUTE, Integer.parseInt(tokens[1]));
		random.set(Calendar.SECOND, Integer.parseInt(tokens[2]));
		
		Date d1 = current.getTime();
		Date d2 = random.getTime();

		long seconds = (d2.getTime()-d1.getTime())/1000;
		return seconds;	
	}
}