package com.converters;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.models.Agency;

@XmlRootElement (name = "agency")
public class AgencyConverter {

	private Agency entity = null;

	public AgencyConverter(Agency entity) {
		this.entity = entity;
	}
	
	public AgencyConverter() {
		this.entity = new Agency();
	}
	
	@XmlElement (name = "agency_id")
	 public String getAgency_id() {
			return entity.getAgency_id();
		}
		public void setAgency_id(String agency_id) {
			entity.setAgency_id(agency_id);
		}
		
		@XmlElement (name = "agency_name")
		public String getAgency_name() {
			return entity.getAgency_name();
		}
		public void setAgency_name(String agency_name) {
			entity.setAgency_name(agency_name);
		}
		
		@XmlElement (name = "agency_url")
		public String getAgency_url() {
			return entity.getAgency_url();
		}
		public void setAgency_url(String agency_url) {
			entity.setAgency_url(agency_url);
		}
		
		@XmlElement (name = "agency_timezone")
		public String getAgency_timezone() {
			return entity.getAgency_timezone();
		}
		public void setAgency_timezone(String agency_timezone) {
			entity.setAgency_timezone(agency_timezone);
		}
		
		@XmlElement (name = "agency_lang")
		public String getAgency_lang() {
			return entity.getAgency_lang();
		}
		public void setAgency_lang(String agency_lang) {
			entity.setAgency_lang(agency_lang);
		}
		
		@XmlElement (name = "agency_phone")
		public String getAgency_phone() {
			return entity.getAgency_phone();
		}
		public void setAgency_phone(String agency_phone) {
			entity.setAgency_phone(agency_phone);
		}
		
		@XmlElement (name = "agency_fare_url")
		public String getAgency_fare_url() {
			return entity.getAgency_phone();
		}
		public void setAgency_fare_url(String agency_fare_url) {
			entity.setAgency_fare_url(agency_fare_url);
		}

}
