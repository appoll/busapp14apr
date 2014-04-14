package com.converters;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.models.Calendar;


@XmlRootElement (name = "calendar")
public class CalendarConverter {

	private Calendar entity = null;
	
	public CalendarConverter(Calendar entity) {
		this.entity = entity;
	}
	public CalendarConverter() {
		this.entity = new Calendar();
	}

	@XmlElement (name = "service_id")
	public String getService_id() {
		return entity.getService_id();
	}
	public void setService_id(String service_id) {
		entity.setService_id(service_id);
	}
	
	@XmlElement (name = "monday")
	public String getMonday() {
		return entity.getMonday();
	}
	public void setMonday(String monday) {
		entity.setMonday(monday);
	}
	
	@XmlElement (name = "tuesday")
	public String getTuesday() {
		return entity.getTuesday();
	}
	public void setTuesday(String tuesday) {
		entity.setTuesday(tuesday);
	}
	
	@XmlElement (name = "wednesday")
	public String getWednesday() {
		return entity.getWednesday();
	}
	public void setWednesday(String wednesday) {
		entity.setWednesday(wednesday);
	}
	
	@XmlElement (name = "thursday")
	public String getThursday() {
		return entity.getThursday();
	}
	public void setThursday(String thursday) {
		entity.setThursday(thursday);
	}
	
	@XmlElement (name = "friday")
	public String getFriday() {
		return entity.getFriday();
	}
	public void setFriday(String friday) {
		entity.setFriday(friday);
	}
	
	@XmlElement (name = "saturday")
	public String getSaturday() {
		return entity.getSaturday();
	}
	public void setSaturday(String saturday) {
		entity.setSaturday(saturday);
	}
	
	@XmlElement (name = "sunday")
	public String getSunday() {
		return entity.getSunday();
	}
	public void setSunday(String sunday) {
		entity.setSunday(sunday);
	}
	
	@XmlElement (name = "start_date")
	public String getStart_date() {
		return entity.getStart_date();
	}
	public void setStart_date(String start_date) {
		entity.setStart_date(start_date);
	}
	
	@XmlElement (name = "end_date")
	public String getEnd_date() {
		return entity.getEnd_date();
	}
	public void setEnd_date(String end_date) {
		entity.setEnd_date(end_date);
	}

}
