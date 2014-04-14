package com.converters;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.models.Trip;

@XmlRootElement (name = "trip")
public class TripConverter {

		private Trip entity = null;
		
		public TripConverter(Trip entity) {
			this.entity = entity;
		}
		public TripConverter() {
			this.entity = new Trip();
		}

	@XmlElement (name = "route_id")
	public String getRoute_id() {
		return entity.getRoute_id();
	}
	public void setRoute_id(String route_id) {
		entity.setRoute_id(route_id);
	}
	
	@XmlElement (name = "service_id")
	public String getService_id() {
		return entity.getService_id();
	}
	public void setService_id(String service_id) {
		entity.setService_id(service_id);
	}
	
	@XmlElement (name = "trip_id")
	public String getTrip_id() {
		return entity.getTrip_id();
	}
	public void setTrip_id(String trip_id) {
		entity.setTrip_id(trip_id);
	}
	
	@XmlElement (name = "trip_headsign")
	public String getTrip_headsign() {
		return entity.getTrip_headsign();
	}
	public void setTrip_headsign(String trip_headsign) {
		entity.setTrip_headsign(trip_headsign);
	}
	
	@XmlElement (name = "direction_id")
	public String getDirection_id() {
		return entity.getDirection_id();
	}
	public void setDirection_id(String direction_id) {
		entity.setDirection_id(direction_id);
	}
	
	@XmlElement (name = "wheelchair_accessible")
	public String getWheelchair_accessible() {
		return entity.getWheelchair_accessible();
	}
	public void setWheelchair_accessible(String wheelchair_accessible) {
		entity.setWheelchair_accessible(wheelchair_accessible);
	}
	
	@XmlElement (name = "shape_id")
	public String getShape_id() {
		return entity.getShape_id();
	}
	public void setShape_id(String shape_id) {
		entity.setShape_id(shape_id);
	}
}
