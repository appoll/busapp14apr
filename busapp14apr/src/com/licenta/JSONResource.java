package com.licenta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.converters.AgencyConverter;
import com.converters.RouteConverter;
import com.converters.StopConverter;
import com.converters.TripConverter;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.models.Agency;
import com.models.Prediction;
import com.models.Route;
import com.models.Stop;
import com.models.Trip;



@Path("/getJSON/")
public class JSONResource {

			//List of agencies
	@GET
	@Path ("agencies.json")
	@Produces ({MediaType.APPLICATION_JSON})
	public CustomList getAgencies ()
	{
		System.out.println("da frate");
		List retag = new ArrayList ();
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query q = new Query ("Agentii");
		PreparedQuery pq = datastore.prepare(q);  
		
		for (Entity entity : pq.asIterable()) {   
			
			Agency agency = new Agency (entity.getProperty("agency_id").toString(),
						entity.getProperty("agency_name").toString(),
						entity.getProperty("agency_url").toString(),
						entity.getProperty("agency_timezone").toString(),
						entity.getProperty("agency_lang").toString(),
						entity.getProperty("agency_phone").toString(),
						entity.getProperty("agency_fare_url").toString()
						);
		       AgencyConverter converter =  new AgencyConverter(agency);
	           retag.add(converter);    
		}
		
		CustomList ret = new CustomList (retag);
		return ret;
	}
	
			//Properties of a specific agency
	@GET 
	@Path ("agencies/{id}.json")
	@Produces({ MediaType.APPLICATION_JSON})
	public AgencyConverter getAgencyById (@PathParam("id") String id)
	{
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Key key = KeyFactory.createKey("Agentii", id);
		Entity entity = null;
		try {
			entity = datastore.get(key);
			
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Agency agency = new Agency (entity.getProperty("agency_id").toString(),
				entity.getProperty("agency_name").toString(),
				entity.getProperty("agency_url").toString(),
				entity.getProperty("agency_timezone").toString(),
				entity.getProperty("agency_lang").toString(),
				entity.getProperty("agency_phone").toString(),
				entity.getProperty("agency_fare_url").toString()
				);
       AgencyConverter converter =  new AgencyConverter(agency);
       return converter;
		
		
	}
				// List of routes for an agency
	@GET
	@Path ("agencies/{id}/routes.json")
	@Produces({ MediaType.APPLICATION_JSON})
	public CustomList getAgencyRoutes (@PathParam ("id") String id)
	{
		List retroutes = new ArrayList ();
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query q = new Query ("Rute");
		PreparedQuery pq = datastore.prepare(q);  
		
		for (Entity entity : pq.asIterable()) {   
		       
			if (entity.getProperty("agency_id").toString().equals(id))
			{
			   Route route = new Route (entity.getProperty("route_id").toString(),
						entity.getProperty("agency_id").toString(),
						entity.getProperty("route_short_name").toString(),
						entity.getProperty("route_long_name").toString(),
						entity.getProperty("route_desc").toString(),
						entity.getProperty("route_type").toString(),
						entity.getProperty("route_color").toString(),
						entity.getProperty("route_text_color").toString()
						);
		       RouteConverter converter =  new RouteConverter(route);
	           retroutes.add(converter);
			}
		}
		
		CustomList ret = new CustomList (retroutes);
		return ret;
	}
	
	/*
	@GET
	@Path ("routes.json")
	@Produces ({MediaType.APPLICATION_JSON})
	public CustomList getAllRoutes ()
	//public List<RouteConverter> getAll ()
	{
		List retroutes = new ArrayList ();
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query q = new Query ("Rute");
		PreparedQuery pq = datastore.prepare(q);  
		
		for (Entity entity : pq.asIterable()) {   
		       Route route = new Route (entity.getProperty("route_id").toString(),
						entity.getProperty("agency_id").toString(),
						entity.getProperty("route_short_name").toString(),
						entity.getProperty("route_long_name").toString(),
						entity.getProperty("route_desc").toString(),
						entity.getProperty("route_type").toString(),
						entity.getProperty("route_color").toString(),
						entity.getProperty("route_text_color").toString()
						);
		       RouteConverter converter =  new RouteConverter(route);
	           retroutes.add(converter);    
		}
		
		CustomList ret = new CustomList (retroutes);
		return ret;
	}
	*/
			//Properties of a specific route
	@GET 
	@Path ("agencies/{agency_id}/routes/{id}.json")			// agency_id nu e relevant
	@Produces({ MediaType.APPLICATION_JSON})
	public RouteConverter getAgencyRouteById (@PathParam("id") String id)
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
		RouteConverter converter = new RouteConverter(route);
		return converter;
	}
	
			//List of stops on a route
	@GET 
	@Path ("agencies/{agency_id}/routes/{route_id}/stops.json")			// agency_id nu e relevant
	@Produces({ MediaType.APPLICATION_JSON})
	public CustomList getAgencyRouteStops (@PathParam("route_id") String route_id) throws EntityNotFoundException
	{
		
		List retstops = new ArrayList ();
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		
		Query tripsQ = new Query ("Curse");
		PreparedQuery tripsPQ = datastore.prepare(tripsQ);  
		
		Query stoptimesQ = new Query ("StopTimes");
		PreparedQuery stoptimesPQ = datastore.prepare(stoptimesQ);
		
		Query stopsQ = new Query ("Statii");
		PreparedQuery stopsPQ = datastore.prepare(stopsQ);
		
		for (Entity trip : tripsPQ.asIterable()) 
		{   
			if (Utils.checkService (trip.getProperty("service_id").toString()))
			{
			if (trip.getProperty("route_id").toString().equals(route_id))
			{
				for (Entity stoptime : stoptimesPQ.asIterable())
				{
					if (stoptime.getProperty("trip_id").toString().equals(
							trip.getProperty("trip_id").toString()))
					{
						for (Entity stop : stopsPQ.asIterable())
						{
							if (stop.getProperty("stop_id").toString().equals(
									stoptime.getProperty("stop_id").toString()))
							{
								Stop s = new Stop (stop.getProperty("stop_id").toString(),
											stop.getProperty("stop_name").toString(),
											stop.getProperty("stop_desc").toString(),
											stop.getProperty("stop_lat").toString(),
											stop.getProperty("stop_lon").toString(),
											stop.getProperty("zone_id").toString(),
											stop.getProperty("location_type").toString(),
											stop.getProperty("parent_station").toString());
								StopConverter converter = new StopConverter (s);
								retstops.add(converter);
							}
						}
					}
				}
			}	
			}
		}
	CustomList ret = new CustomList (retstops);
	return ret;
	}
	
		
			// List of trips for a route
	
	@GET 
	@Path ("agencies/{agency_id}/routes/{route_id}/trips.json")			// agency_id nu e relevant
	@Produces({ MediaType.APPLICATION_JSON})
	public CustomList getAgencyRouteTrips (@PathParam("route_id") String route_id) throws EntityNotFoundException
	{
		
		List rettrips = new ArrayList ();
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		
		Query tripsQ = new Query ("Curse");
		PreparedQuery tripsPQ = datastore.prepare(tripsQ);  
		
		for (Entity trip : tripsPQ.asIterable())
		{
			if (Utils.checkService (trip.getProperty("service_id").toString()))
			{
			if (trip.getProperty("route_id").toString().equals(route_id))
			{
				Trip t = new Trip (trip.getProperty("route_id").toString(),
						trip.getProperty("service_id").toString(),
						trip.getProperty("trip_id").toString(),
						trip.getProperty("trip_headsign").toString(),
						trip.getProperty("direction_id").toString(),
						trip.getProperty("wheelchair_accessible").toString(),
						trip.getProperty("shape_id").toString());
				
				TripConverter converter = new TripConverter (t);
				rettrips.add(converter);
			}
			}
		}
		
		CustomList ret = new CustomList (rettrips);
		return ret;
	}
	
	
				//Properties of a specific trip
	@GET 
	@Path ("agencies/{agency_id}/routes/{route_id}/trips/{trip_id}.json")
	@Produces({ MediaType.APPLICATION_JSON})
	public TripConverter getAgencyRouteTripById (@PathParam("route_id") String route_id, @PathParam("trip_id")String trip_id)
	{
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		
		Query tripsQ = new Query ("Curse");
		PreparedQuery tripsPQ = datastore.prepare(tripsQ);
		
		TripConverter converter = null;
		
		for (Entity trip : tripsPQ.asIterable())
			if (Utils.checkService (trip.getProperty("service_id").toString()))
			{
			if (trip.getProperty("route_id").toString().equals(route_id) &&
				trip.getProperty("trip_id").toString().equals(trip_id))
			{
				Trip t = new Trip (trip.getProperty("route_id").toString(),
						trip.getProperty("service_id").toString(),
						trip.getProperty("trip_id").toString(),
						trip.getProperty("trip_headsign").toString(),
						trip.getProperty("direction_id").toString(),
						trip.getProperty("wheelchair_accessible").toString(),
						trip.getProperty("shape_id").toString());
				converter = new TripConverter (t); 
			}
			}
		return converter;
	}
								// trebuie ordonate dupá stop_sequence
	//List of stops for a trip
	@GET 
	@Path ("agencies/{agency_id}/routes/{route_id}/trips/{trip_id}/stops.json")
	@Produces({ MediaType.APPLICATION_JSON})
	public CustomList getAgencyRouteTripStops (@PathParam("route_id") String route_id, @PathParam("trip_id") String trip_id)
	{
		List retstops = new ArrayList ();
		
		for (int i=0; i<30; i++)				// not nice
			retstops.add("NULL");
		
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		
		Query tripsQ = new Query ("Curse");
		PreparedQuery tripsPQ = datastore.prepare(tripsQ);  
		
		Query stoptimesQ = new Query ("StopTimes");
		PreparedQuery stoptimesPQ = datastore.prepare(stoptimesQ);
		
		Query stopsQ = new Query ("Statii");
		PreparedQuery stopsPQ = datastore.prepare(stopsQ);
	
		for (Entity trip : tripsPQ.asIterable())
		{
			if (Utils.checkService (trip.getProperty("service_id").toString()))
			{
			if (trip.getProperty("route_id").toString().equals(route_id) 
				&& trip.getProperty("trip_id").toString().equals(trip_id))
			{
				for (Entity stoptime : stoptimesPQ.asIterable())
					{
						if (stoptime.getProperty("trip_id").equals(trip.getProperty("trip_id")))
						{
						int stop_seq = Integer.parseInt(stoptime.getProperty("stop_sequence").toString());
						for (Entity stop : stopsPQ.asIterable())
							if (stop.getProperty("stop_id").equals(stoptime.getProperty("stop_id")))
							{
								Stop s = new Stop (stop.getProperty("stop_id").toString(),
										stop.getProperty("stop_name").toString(),
										stop.getProperty("stop_desc").toString(),
										stop.getProperty("stop_lat").toString(),
										stop.getProperty("stop_lon").toString(),
										stop.getProperty("zone_id").toString(),
										stop.getProperty("location_type").toString(),
										stop.getProperty("parent_station").toString());
										
							StopConverter converter = new StopConverter (s);
							retstops.set(stop_seq,converter);
							}
						}
					}
				
			}
			}
		}
		
		for (int i=0; i<retstops.size(); i++)
			if (retstops.get(i)=="NULL")			// trebuie eliminate elementele nule
				retstops.remove(i);
		
		CustomList ret = new CustomList (retstops);
		return ret;
	}
	
			//Properties of a specific stop
	@GET 
	@Path ("agencies/{agency_id}/stops/{id}.json")			// agency_id nu e relevant
	@Produces({ MediaType.APPLICATION_JSON})
	public StopConverter getAgencyStopById (@PathParam("id") String id)
	{
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Key key = KeyFactory.createKey("Statii", id);
		Entity entity = null;
		try {
			entity = datastore.get(key);
			
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Stop stop = new Stop (entity.getProperty("stop_id").toString(),
				entity.getProperty("stop_name").toString(),
				entity.getProperty("stop_desc").toString(),
				entity.getProperty("stop_lat").toString(),
				entity.getProperty("stop_lon").toString(),
				entity.getProperty("zone_id").toString(),
				entity.getProperty("location_type").toString(),
				entity.getProperty("parent_station").toString()
				);
		StopConverter converter = new StopConverter(stop);
		return converter;
	}
	
				//List of routes that serve a specific stop		
						// duplicate
	@GET 
	@Path ("agencies/{agency_id}/stops/{stop_id}/routes.json")			// agency_id nu e relevant
	@Produces({ MediaType.APPLICATION_JSON})
	public CustomList getAgencyStopRoutes (@PathParam ("stop_id") String stop_id)
	{
		List retroutes = new ArrayList ();
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		
		Query routesQ = new Query ("Rute");
		PreparedQuery routesPQ = datastore.prepare(routesQ);  
		
		Query tripsQ = new Query ("Curse");
		PreparedQuery tripsPQ = datastore.prepare(tripsQ);  
		
		Query stoptimesQ = new Query ("StopTimes");
		PreparedQuery stoptimesPQ = datastore.prepare(stoptimesQ);
		
		for (Entity stoptime : stoptimesPQ.asIterable()) {   
		       
			if (stoptime.getProperty("stop_id").toString().equals(stop_id))
			{
				for (Entity trip : tripsPQ.asIterable())
					if (Utils.checkService (trip.getProperty("service_id").toString()))
					{
					if (stoptime.getProperty("trip_id").equals(trip.getProperty("trip_id")))
						for (Entity r : routesPQ.asIterable())
							if (r.getProperty("route_id").equals(trip.getProperty("route_id")))
							{
								Route route = new Route (r.getProperty("route_id").toString(),
										r.getProperty("agency_id").toString(),
										r.getProperty("route_short_name").toString(),
										r.getProperty("route_long_name").toString(),
										r.getProperty("route_desc").toString(),
										r.getProperty("route_type").toString(),
										r.getProperty("route_color").toString(),
										r.getProperty("route_text_color").toString()
										);
						       RouteConverter converter =  new RouteConverter(route);
						       	// elimina duplicatele
						    	   retroutes.add(converter);
							}
					}
			}
		}
		
		CustomList ret = new CustomList (retroutes);
		return ret;
	}
	
						//List of predicted arrivals for a specific stop
	@GET 
	@Path ("agencies/{agency_id}/stops/{stop_id}/predictions.json")			
	@Produces({ MediaType.APPLICATION_JSON})
	public CustomList getAgencyStopPredictions (@PathParam("stop_id") String stop_id)
	{
		List retpredictions = new ArrayList ();
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		
		Query tripsQ = new Query ("Curse");
		PreparedQuery tripsPQ = datastore.prepare(tripsQ);  
		
		Query stoptimesQ = new Query ("StopTimes");
		PreparedQuery stoptimesPQ = datastore.prepare(stoptimesQ);
		
		for (Entity stoptime : stoptimesPQ.asIterable())
		{
			if (stoptime.getProperty("stop_id").toString().equals(stop_id))
			{
				for (Entity trip : tripsPQ.asIterable())
				{
					if (trip.getProperty("trip_id").equals(stoptime.getProperty("trip_id")))
					{
						
						if (Utils.checkService (trip.getProperty("service_id").toString()))
						{
							
							
						Prediction p = new Prediction (trip.getProperty("trip_id").toString(),
													Utils.getNextArrival(trip.getProperty("trip_id").toString(),stoptime.getProperty("arrival_time").toString()),
													trip.getProperty("route_id").toString(),
													Utils.getHeadway(trip.getProperty("trip_id").toString()),
													stoptime.getProperty("arrival_time").toString());
					//	if (p.getSeconds() > 0)
							retpredictions.add(p);
						}
					}
				}
			}
		}
		
		Collections.sort(retpredictions);
		CustomList ret = new CustomList (retpredictions);
		return ret;
	}
	
	
						//List of predicted arrivals for a specific route at specific stop
	@GET 
	@Path ("agencies/{agency_id}/stops/{stop_id}/predictions/by-route/{route_id}.json")			
	@Produces({ MediaType.APPLICATION_JSON})
	public CustomList getAgencyStopRoutePredictions (@PathParam("stop_id") String stop_id, @PathParam("route_id") String route_id)
	{
		List retpredictions = new ArrayList ();
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		
		Query tripsQ = new Query ("Curse");
		PreparedQuery tripsPQ = datastore.prepare(tripsQ);  
		
		Query stoptimesQ = new Query ("StopTimes");
		PreparedQuery stoptimesPQ = datastore.prepare(stoptimesQ);
		
		for (Entity stoptime : stoptimesPQ.asIterable())
			if (stoptime.getProperty("stop_id").toString().equals(stop_id))
				for (Entity trip : tripsPQ.asIterable())
					if (trip.getProperty("trip_id").equals(stoptime.getProperty("trip_id"))
						&& trip.getProperty("route_id").toString().equals(route_id))
					{
						if (Utils.checkService (trip.getProperty("service_id").toString()))
						{
						Prediction p = new Prediction (trip.getProperty("trip_id").toString(), 
													//Utils.secondsToArrival(stoptime.getProperty("arrival_time").toString()),
													Utils.getNextArrival(trip.getProperty("trip_id").toString(), stoptime.getProperty("arrival_time").toString()),
													trip.getProperty("route_id").toString(),
													Utils.getHeadway(trip.getProperty("trip_id").toString()),
													stoptime.getProperty("arrival_time").toString()
													);
						retpredictions.add(p);
						}
					}
		
		Collections.sort(retpredictions);
		CustomList ret = new CustomList (retpredictions);
		return ret;
	}
}
