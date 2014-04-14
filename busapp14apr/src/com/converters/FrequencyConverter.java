package com.converters;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.models.Frequency;

@XmlRootElement (name = "frequency")
public class FrequencyConverter {
	private Frequency entity = null;

	public FrequencyConverter(Frequency entity) {
		this.entity = entity;
	}
	
	public FrequencyConverter() {
		this.entity = new Frequency();
	}
	
	@XmlElement (name = "trip_id")
	public String getTrip_id() {
		return entity.getTrip_id();
	}
	public void setTrip_id(String trip_id) {
		entity.setTrip_id(trip_id);
	}
	
	@XmlElement (name = "start_time")
	public String getStart_time() {
		return entity.getStart_time();
	}
	public void setStart_time(String start_time) {
		entity.setStart_time(start_time);
	}
	
	@XmlElement (name = "end_time")
	public String getEnd_time() {
		return entity.getEnd_time();
	}
	public void setEnd_time(String end_time) {
		entity.setEnd_time(end_time);
	}
	
	@XmlElement (name = "headway_secs")
	public String getHeadway_secs() {
		return entity.getHeadway_secs();
	}
	public void setHeadway_secs(String headway_secs) {
		entity.setHeadway_secs(headway_secs);
	}
	
	@XmlElement (name = "exact_times")				// time / times?
	public String getExact_times() {
		return entity.getExact_times();
	}
	public void setExact_times(String exact_times) {
		entity.setExact_times(exact_times);
	}

}
