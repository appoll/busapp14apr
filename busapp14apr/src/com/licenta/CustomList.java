package com.licenta;

import java.util.LinkedList;
import java.util.List;

import com.converters.AgencyConverter;
import com.converters.CalendarConverter;
import com.converters.FrequencyConverter;
import com.converters.RouteConverter;
import com.converters.ShapeConverter;
import com.converters.StopConverter;
import com.converters.StopTimeConverter;
import com.converters.TripConverter;

public class CustomList <T> {

	
	public List <T> list;
/*	
	public List <RouteConverter> routes;
	public List <AgencyConverter> agencies;
	public List <CalendarConverter> calendars;
	public List <FrequencyConverter> frequencies;
	public List <ShapeConverter> shapes;
	public List <StopConverter> stops;
	public List <StopTimeConverter> stoptimes;
	public List <TripConverter> trips;
*/	
	public CustomList(){};
	
	public CustomList(List <T> list)
	{
		this.list =(list != null) ? new LinkedList<T>(list) : null;
	}
}
