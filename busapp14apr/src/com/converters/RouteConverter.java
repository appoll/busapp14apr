package com.converters;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.models.Route;

@XmlRootElement (name = "route")
public class RouteConverter {
	private Route entity = null;
	
	public RouteConverter(Route entity) {
		this.entity = entity;
	}
	public RouteConverter() {
		this.entity = new Route();
	}
	
	@XmlElement (name = "route_id")
	public String getRoute_id() {
		return entity.getRoute_id();
	}
	public void setRoute_id(String route_id) {
		entity.setRoute_id(route_id);
	}
	
	@XmlElement (name = "agency_id")
	public String getAgency_id() {
		return entity.getAgency_id();
	}
	public void setAgency_id(String agency_id) {
		entity.setAgency_id(agency_id);
	}
	
	@XmlElement (name = "cucu")
	public String getRoute_short_name() {
		return entity.getRoute_short_name();
	}
	public void setRoute_short_name(String route_short_name) {
		entity.setRoute_short_name(route_short_name);
	}
	
	@XmlElement (name = "cucu")
	public String getRoute_long_name() {
		return entity.getRoute_long_name();
	}
	public void setRoute_long_name(String route_long_name) {
		entity.setRoute_long_name(route_long_name);
	}
	
	@XmlElement (name = "cucu")
	public String getRoute_desc() {
		return entity.getRoute_desc();
	}
	public void setRoute_desc(String route_desc) {
		entity.setRoute_desc(route_desc);
	}
	
	@XmlElement (name = "route_type")
	public String getRoute_type() {
		return entity.getRoute_type();
	}
	public void setRoute_type(String route_type) {
		entity.setRoute_type(route_type);
	}
	
	@XmlElement (name = "route_color")
	public String getRoute_color() {
		return entity.getRoute_color();
	}
	public void setRoute_color(String route_color) {
		entity.setRoute_color(route_color);
	}
	
	@XmlElement (name = "route_text_color")
	public String getRoute_text_color() {
		return entity.getRoute_color();
	}
	public void setRoute_text_color(String route_text_color) {
		entity.setRoute_text_color(route_text_color);
	}
	
}
