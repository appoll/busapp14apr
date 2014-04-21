package com.models;

public class Agency {

	String agency_id;
	String agency_name;
    String agency_url;
    String agency_timezone;
    String agency_lang;
    String agency_phone;
    String agency_fare_url; 
	
    public Agency (){}
    
    
    public Agency(String agency_id, String agency_name, String agency_url,
			String agency_timezone, String agency_lang, String agency_phone,
			String agency_fare_url) {
		this.agency_id = agency_id;
		this.agency_name = agency_name;
		this.agency_url = agency_url;
		this.agency_timezone = agency_timezone;
		this.agency_lang = agency_lang;
		this.agency_phone = agency_phone;
		this.agency_fare_url = agency_fare_url;
	}


	public String getAgency_id() {
		return agency_id;
	}
	public void setAgency_id(String agency_id) {
		this.agency_id = agency_id;
	}
	public String getAgency_name() {
		return agency_name;
	}
	public void setAgency_name(String agency_name) {
		this.agency_name = agency_name;
	}
	public String getAgency_url() {
		return agency_url;
	}
	public void setAgency_url(String agency_url) {
		this.agency_url = agency_url;
	}
	public String getAgency_timezone() {
		return agency_timezone;
	}
	public void setAgency_timezone(String agency_timezone) {
		this.agency_timezone = agency_timezone;
	}
	public String getAgency_lang() {
		return agency_lang;
	}
	public void setAgency_lang(String agency_lang) {
		this.agency_lang = agency_lang;
	}
	public String getAgency_phone() {
		return agency_phone;
	}
	public void setAgency_phone(String agency_phone) {
		this.agency_phone = agency_phone;
	}
	public String getAgency_fare_url() {
		return agency_fare_url;
	}
	public void setAgency_fare_url(String agency_fare_url) {
		this.agency_fare_url = agency_fare_url;
	}
	
	
}
