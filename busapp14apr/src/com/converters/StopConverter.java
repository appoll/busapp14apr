package com.converters;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.models.Stop;

@XmlRootElement (name = "stop")
public class StopConverter {
private Stop entity = null;
	
	public StopConverter(Stop entity) {
		this.entity = entity;
	}
	public StopConverter() {
		this.entity = new Stop();
	}
	
	@XmlElement (name = "stop_id")
	public String getStop_id() {
		return entity.getStop_id();
	}
	public void setStop_id(String stop_id) {
		entity.setStop_id(stop_id);
	}
	
	@XmlElement (name = "stop_name")
	public String getStop_name() {
		return entity.getStop_name();
	}
	public void setStop_name(String stop_name) {
		entity.setStop_name(stop_name);
	}
	
	@XmlElement (name = "stop_desc")
	public String getStop_desc() {
		return entity.getStop_desc();
	}
	public void setStop_desc(String stop_desc) {
		entity.setStop_desc(stop_desc);
	}
	
	@XmlElement (name = "stop_lat")
	public String getStop_lat() {
		return entity.getStop_lat();
	}
	public void setStop_lat(String stop_lat) {
		entity.setStop_lat(stop_lat);
	}
	
	@XmlElement (name = "stop_lon")
	public String getStop_lon() {
		return entity.getStop_lon();
	}
	public void setStop_lon(String stop_lon) {
		entity.setStop_lon(stop_lon);
	}
	
	@XmlElement (name = "zone_id")
	public String getZone_id() {
		return entity.getZone_id();
	}
	public void setZone_id(String zone_id) {
		entity.setZone_id(zone_id);
	}
	
	@XmlElement (name = "location_type")
	public String getLocation_type() {
		return entity.getLocation_type();
	}
	public void setLocation_type(String location_type) {
		entity.setLocation_type(location_type);
	}
	
	@XmlElement (name = "parent_station")
	public String getParent_station() {
		return entity.getParent_station();
	}
	public void setParent_station(String parent_station) {
		entity.setParent_station(parent_station);
	}
}
