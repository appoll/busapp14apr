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

	
	
	@XmlElement (name = "cucu")
	public String getRoute_id() {
		return entity.getRoute_id();
	}
	public void setRoute_id(String route_id) {
		entity.setRoute_id(route_id);
	}
	
	@XmlElement (name = "cucu")
	public String getAgency_id() {
		return entity.getAgency_id();
	}
	public void setAgency_id(String agency_id) {
		entity.setAgency_id(agency_id);;
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
		this.route_long_name = route_long_name;
	}
	public String getRoute_desc() {
		return route_desc;
	}
	public void setRoute_desc(String route_desc) {
		this.route_desc = route_desc;
	}
	public String getRoute_type() {
		return route_type;
	}
	public void setRoute_type(String route_type) {
		this.route_type = route_type;
	}
	public String getRoute_color() {
		return route_color;
	}
	public void setRoute_color(String route_color) {
		this.route_color = route_color;
	}
	public String getRoute_text_color() {
		return route_text_color;
	}
	public void setRoute_text_color(String route_text_color) {
		this.route_text_color = route_text_color;
	}

}
