package com.converters;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.models.Shape;

@XmlRootElement (name = "shape")
public class ShapeConverter {
	private Shape entity = null;

	public ShapeConverter(Shape entity) {
		this.entity = entity;
	}
	
	public ShapeConverter() {
		this.entity = new Shape();
	}
	
	@XmlElement (name = "shape_id")
	public String getShape_id() {
		return entity.getShape_id();
	}
	public void setShape_id(String shape_id) {
		entity.setShape_id(shape_id);
	}
	
	@XmlElement (name = "shape_pt_lat")
	public String getShape_pt_lat() {
		return entity.getShape_pt_lat();
	}
	public void setShape_pt_lat(String shape_pt_lat) {
		entity.setShape_pt_lat(shape_pt_lat);
	}
	
	@XmlElement (name = "shape_pt_lon")
	public String getShape_pt_lon() {
		return entity.getShape_pt_lon();
	}
	public void setShape_pt_lon(String shape_pt_lon) {
		entity.setShape_pt_lon(shape_pt_lon);
	}
	
	@XmlElement (name = "shape_pt_sequence")
	public String getShape_pt_sequence() {
		return entity.getShape_pt_sequence();
	}
	public void setShape_pt_sequence(String shape_pt_sequence) {
		entity.setShape_pt_sequence(shape_pt_sequence);
	}
}
