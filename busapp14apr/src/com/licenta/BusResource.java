package com.licenta;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.converters.RouteConverter;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.models.Obiect;
import com.models.Route;



@Path("/hr/")
public class BusResource {

	@GET
	 @Produces("text/plain")
	 @Path("/employee") 
	 public String getEmployee() {
	        return "Hello You filthy filthy animal!";
	    }
	
	
	@GET 
	@Path ("/hai")
	@Produces(MediaType.APPLICATION_JSON)
	
	public Obiect getme ()
	{
		Obiect a = new Obiect ("anton","ap");
		return a;
	}
	
	@GET 
	@Path ("routes/{id}.json")
	@Produces({ MediaType.APPLICATION_JSON})
	public RouteConverter getRouteById (@PathParam("id") String id)
	{
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Key key = KeyFactory.createKey("Rute", id);
		Entity entity = null;
		try {
			entity = datastore.get(key);
			
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Route route = new Route (entity.getProperty("route_id").toString(),
				entity.getProperty("agency_id").toString(),
				entity.getProperty("route_short_name").toString(),
				entity.getProperty("route_long_name").toString(),
				entity.getProperty("route_desc").toString(),
				entity.getProperty("route_type").toString(),
				entity.getProperty("route_color").toString(),
				entity.getProperty("route_text_color").toString()
				);
		RouteConverter ret = new RouteConverter(route);
		return ret;
	}
	
	
	
	@GET
	 @Path("/hellojson")
	 @Produces({ MediaType.APPLICATION_JSON})
	public RouteConverter simplejson() {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Key ruta = KeyFactory.createKey("Rute", "782");
		Entity entity = null;
		try {
			entity = datastore.get(ruta);
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Route route = new Route (entity.getProperty("route_id").toString(),
				entity.getProperty("agency_id").toString(),
				entity.getProperty("route_short_name").toString(),
				entity.getProperty("route_long_name").toString(),
				entity.getProperty("route_desc").toString(),
				entity.getProperty("route_type").toString(),
				entity.getProperty("route_color").toString(),
				entity.getProperty("route_text_color").toString()
				);
		RouteConverter ret = new RouteConverter(route);
		return ret;
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
