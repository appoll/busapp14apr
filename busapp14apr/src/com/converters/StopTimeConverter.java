package com.converters;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.models.StopTime;

@XmlRootElement (name = "stop_time")	// stop_ time sau stop time?
public class StopTimeConverter {

	private StopTime entity = null;
	
	public StopTimeConverter(StopTime entity) {
		this.entity = entity;
	}
	public StopTimeConverter() {
		this.entity = new StopTime();
	}
	
	@XmlElement (name = "trip_id")
	public String getTrip_id() {
		return entity.getTrip_id();
	}
	public void setTrip_id(String trip_id) {
		entity.setTrip_id(trip_id);
	}
	
	@XmlElement (name = "arrival_time")
	public String getArrival_time() {
		return entity.getArrival_time();
	}
	public void setArrival_time(String arrival_time) {
		entity.setArrival_time(arrival_time);
	}
	
	@XmlElement (name = "departure_time")
	public String getDeparture_time() {
		return entity.getDeparture_time();
	}
	public void setDeparture_time(String departure_time) {
		entity.setDeparture_time(departure_time);
	}
	
	@XmlElement (name = "stop_id")
	public String getStop_id() {
		return entity.getStop_id();
	}
	public void setStop_id(String stop_id) {
		entity.setStop_id(stop_id);
	}
	
	@XmlElement (name = "stop_sequence")
	public String getStop_sequence() {
		return entity.getStop_sequence();
	}
	public void setStop_sequence(String stop_sequence) {
		entity.setStop_sequence(stop_sequence);
	}

}
