package com.licenta;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;



@Path("/hr/")
public class BusResource {

	@GET
	 @Produces("text/plain")
	 @Path("/employee") 
	 public String getEmployee() {
	        return "Hello You filthy filthy animal!";
	    }
	
	@GET
	 @Path("/hellojson")
	 @Produces("text/plain")
	public String simplejson() {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Key ruta = KeyFactory.createKey("Rute", "782");
		Entity entity = null;
		try {
			entity = datastore.get(ruta);
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 return entity.toString();
	 }
	
	
	@GET
	@Produces ("text/plain")
	@Path("/ruta")
	public String getRuta() {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Key ruta = KeyFactory.createKey("Rute", "782");
		Entity entity;
		String ret = "test";
		try {
			entity = datastore.get(ruta);
			ret = (String) entity.getProperty("route_long_name");
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ret;
    }
}
