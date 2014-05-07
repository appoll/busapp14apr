package com.licenta;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

public class Utils {
	
	static final long ONE_MINUTE_IN_MILLIS=60000;
	static final long ONE_SECOND_IN_MILLIS=1000;
	
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
	
	public static boolean checkService (String service_id)				// în funcție de zi
	{
		Calendar current = Calendar.getInstance();
		Locale locale = Locale.getDefault();
		
		String day = current.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, locale);
		day = day.toLowerCase();
		
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		
		Query calendarQ = new Query ("Calendar");
		PreparedQuery calendarPQ = datastore.prepare(calendarQ);
		
		for (Entity service : calendarPQ.asIterable())
		{
			if (service.getProperty("service_id").toString().equals(service_id))
			{
				if (service.getProperty(day).toString().equals("1"))
					return true;
			}
		}
		return false;
	}
	
	public static int getHeadway (String trip_id)
	{
		Calendar current = Calendar.getInstance();
		Calendar start = new GregorianCalendar(current.get(Calendar.YEAR),
												current.get(Calendar.MONTH),
												current.get(Calendar.DAY_OF_MONTH));
		
		Calendar end = new GregorianCalendar(current.get(Calendar.YEAR),
											current.get(Calendar.MONTH),
											current.get(Calendar.DAY_OF_MONTH));
		
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query frequencyQ = new Query ("Frecvente");
		PreparedQuery frequencyPQ = datastore.prepare(frequencyQ);
		
		for (Entity freq : frequencyPQ.asIterable())
		{
			if (freq.getProperty("trip_id").toString().equals(trip_id))
			{
				String start_time = freq.getProperty("start_time").toString();
				String end_time = freq.getProperty("end_time").toString();
				String [] tokens_start = start_time.split(":");
				String [] tokens_end = end_time.split(":");
				
				start.set(Calendar.HOUR_OF_DAY, Integer.parseInt(tokens_start[0]));
				start.set(Calendar.MINUTE, Integer.parseInt(tokens_start[1]));
				start.set(Calendar.SECOND, Integer.parseInt(tokens_start[2]));
				
				end.set(Calendar.HOUR_OF_DAY, Integer.parseInt(tokens_end[0]));
				end.set(Calendar.MINUTE, Integer.parseInt(tokens_end[1]));
				end.set(Calendar.SECOND, Integer.parseInt(tokens_end[2]));
				
				Date currentDate = current.getTime();
				Date startDate = start.getTime();
				Date endDate = end.getTime();
				
					if (currentDate.after(startDate) && currentDate.before(endDate))
					{	
							return Integer.parseInt(freq.getProperty("headway_secs").toString());
					}
			}
		}
		return 0;
	}
	
	public static long getNextArrival (String trip_id, String sequence_time)
	{
		String [] tokens  = sequence_time.split(":");
		int sequence = Integer.parseInt(tokens[1])*60;
		
		Calendar current = Calendar.getInstance();
		Calendar start = new GregorianCalendar(current.get(Calendar.YEAR),
												current.get(Calendar.MONTH),
												current.get(Calendar.DAY_OF_MONTH));
		
		Calendar end = new GregorianCalendar(current.get(Calendar.YEAR),
											current.get(Calendar.MONTH),
											current.get(Calendar.DAY_OF_MONTH));
		
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query frequencyQ = new Query ("Frecvente");
		PreparedQuery frequencyPQ = datastore.prepare(frequencyQ);
		
		for (Entity freq : frequencyPQ.asIterable())
		{
			if (freq.getProperty("trip_id").toString().equals(trip_id))
			{
				String start_time = freq.getProperty("start_time").toString();
				String end_time = freq.getProperty("end_time").toString();
				String [] tokens_start = start_time.split(":");
				String [] tokens_end = end_time.split(":");
				
				start.set(Calendar.HOUR_OF_DAY, Integer.parseInt(tokens_start[0]));
				start.set(Calendar.MINUTE, Integer.parseInt(tokens_start[1]));
				start.set(Calendar.SECOND, Integer.parseInt(tokens_start[2]));
				
				end.set(Calendar.HOUR_OF_DAY, Integer.parseInt(tokens_end[0]));
				end.set(Calendar.MINUTE, Integer.parseInt(tokens_end[1]));
				end.set(Calendar.SECOND, Integer.parseInt(tokens_end[2]));
				
				Date currentDate = current.getTime();
				Date startDate = start.getTime();
				Date endDate = end.getTime();
				
				System.out.println("ora curenta: " + currentDate);
				currentDate.setTime (currentDate.getTime() - ONE_SECOND_IN_MILLIS * sequence);
				System.out.println("ora curenta respectand secventa: " + currentDate);
				
					if (currentDate.after(startDate) && currentDate.before(endDate))
					{		
						Date d = startDate;
						System.out.println("________________________________________________________");
						System.out.println("start: "+d);
						int headway = Integer.parseInt(freq.getProperty("headway_secs").toString());
						// sequence = Integer.parseInt(tokens[1])*60;
						
						
						while (d.before(currentDate))
						{
							d.setTime(d.getTime() + ONE_SECOND_IN_MILLIS * headway);
						}
						System.out.println("inainte: "+d);
						System.out.println("curent: "+currentDate);
						System.out.println ((currentDate.getTime()-d.getTime())/1000);
						System.out.println("________________________________________________________");
						
						currentDate.setTime (currentDate.getTime() + ONE_SECOND_IN_MILLIS * sequence);
						return (d.getTime()-currentDate.getTime())/1000;
					}
			}
		}
		return -1;
	}
}