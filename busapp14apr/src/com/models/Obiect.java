package com.models;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

@XmlRootElement
public class Obiect {

	String nume;
	String id; 
	
	public Obiect (){}
	
 public	Obiect (String nume, String id)
	{
		this.nume = nume;
		this.id = id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	 public String toString() {
	        StringBuilder sb = new StringBuilder();
	        sb.append("First: ").append(getNume());
	        sb.append(" - Last: ").append(getId());
	        return sb.toString();
	    }
	
	public JSONObject toJSON() throws JSONException{
		JSONObject obj = new JSONObject();
		obj.put("id", id);
		obj.put("display_name", nume);
     return obj;
	}
	
	public boolean equals (Object o)
	{
		Obiect another = (Obiect)o;
		return another.id.equals(id);
	}
	
	public int hashCode ()
	{
		return id.hashCode();
	}

}
