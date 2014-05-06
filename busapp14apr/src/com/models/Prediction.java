package com.models;

public class Prediction implements Comparable <Prediction> {

	String trip_id;
	String route_id;
	
	double seconds;
	double minutes;
	
	int headway;

	double sequence;				// difference in time between initial stop and current stop
	
	public Prediction(){}
	
	public Prediction (String trip_id, long seconds, String route_id, int headway, String time)
	{
		this.trip_id = trip_id;
		//this.seconds = seconds;
		this.route_id = route_id;
		this.headway = headway;
		
		String [] tokens = time.split(":");
		this.sequence = Double.parseDouble(tokens[1]);
		
		this.seconds= seconds + (this.sequence*60);
		this.minutes = this.seconds/60;
	}
	
	public int getHeadway() {
		return headway;
	}

	public void setHeadway(int headway) {
		this.headway = headway;
	}
	
	public String getTrip_id() {
		return trip_id;
	}
	public void setTrip_id(String trip_id) {
		this.trip_id = trip_id;
	}
	public String getRoute_id() {
		return route_id;
	}
	public void setRoute_id(String route_id) {
		this.route_id = route_id;
	}
	public double getSeconds() {
		return seconds;
	}
	public void setSeconds(double seconds) {
		this.seconds = seconds;
	}
	public double getMinutes() {
		return minutes;
	}
	public void setMinutes(double minutes) {
		this.minutes = minutes;
	}

	@Override
	public int compareTo(Prediction other) {
		// TODO Auto-generated method stub
		return (int) (this.getSeconds() - other.getSeconds());
	}
	
}
