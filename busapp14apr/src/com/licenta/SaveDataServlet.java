package com.licenta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;


@SuppressWarnings("serial")
public class SaveDataServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
	    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	    
	    // citirea datelor din fisiere
	    ServletContext context = this.getServletContext();
	    InputStream inputStream;
	    BufferedReader reader;
	    String strLine;
	    
	    // Rute
	    String routes_filename = "/WEB-INF/GTFS/routes.txt";
	    inputStream = context.getResourceAsStream(routes_filename);
	    reader = new BufferedReader (new InputStreamReader (inputStream));
		
		String route_id;
		String agency_id;
		String route_short_name;
		String route_long_name;
		String route_desc;
		String route_type;
		String route_color;
		String route_text_color;
		
		strLine = reader.readLine();
		while((strLine = reader.readLine())!= null)
		  {
			String delims = "[,]";
			String []tokens = strLine.split(delims);
			
			route_id = tokens[0];
			agency_id = tokens[1];
			route_short_name = tokens[2];
			route_long_name = tokens[3];
			route_desc = tokens[4];
			route_type = tokens[5];
			route_color = "";
			route_text_color = "";
			
			Entity ruta = new Entity ("Rute",route_id);
			ruta.setProperty("route_id", route_id);
			ruta.setProperty("agency_id", agency_id);
			ruta.setProperty("route_short_name", route_short_name);
			ruta.setProperty("route_long_name", route_long_name);
			ruta.setProperty("route_desc", route_desc);
			ruta.setProperty("route_type", route_type);
			ruta.setProperty("route_color", route_color);
			ruta.setProperty("route_text_color", route_text_color);
			
			datastore.put(ruta);
		  }
		
		
		//Agentii
        
		String agency_filename = "/WEB-INF/GTFS/agency.txt";
		inputStream = context.getResourceAsStream(agency_filename);
	    reader = new BufferedReader (new InputStreamReader (inputStream));
		
	    //String agency_id;
	    String agency_name;
	    String agency_url;
	    String agency_timezone;
	    String agency_lang;
	    String agency_phone;
	    String agency_fare_url;
	    
	    strLine = reader.readLine();
		while((strLine = reader.readLine())!= null)
		  {
			String delims = "[,]";
			String []tokens = strLine.split(delims);
			
			
			agency_id = tokens[0];
			agency_name = tokens[1];
			agency_url = tokens[2];
			agency_timezone = tokens[3];
			agency_lang = tokens[4];
			agency_phone = tokens[5];
			agency_fare_url = tokens[6];
			
			
			Entity agentie = new Entity ("Agentii",agency_id);
			agentie.setProperty("agency_id", agency_id);
			agentie.setProperty("agency_name", agency_name);
			agentie.setProperty("agency_url", agency_url);
			agentie.setProperty("agency_timezone", agency_timezone);
			agentie.setProperty("agency_lang", agency_lang);
			agentie.setProperty("agency_phone", agency_phone);
			agentie.setProperty("agency_fare_url", agency_fare_url);
			
			datastore.put(agentie);
		  }
	    
		
		
		//Calendar
		String calendar_filename = "/WEB-INF/GTFS/calendar.txt";
		inputStream = context.getResourceAsStream(calendar_filename);
	    reader = new BufferedReader (new InputStreamReader (inputStream));
		String service_id;
		String monday;
		String tuesday;
		String wednesday;
		String thursday;
		String friday;
		String saturday;
		String sunday;
		String start_date;
		String end_date;
		
		 strLine = reader.readLine();
			while((strLine = reader.readLine())!= null)
			  {
				String delims = "[,]";
				String []tokens = strLine.split(delims);
				
				
				service_id = tokens[0];
				monday = tokens[1];
				tuesday = tokens[2];
				wednesday = tokens[3];
				thursday = tokens[4];
				friday = tokens[5];
				saturday = tokens[6];
				sunday = tokens[7];
				start_date = tokens[8];
				end_date = tokens[9];
				
				
				Entity calendar = new Entity ("Calendar",service_id);
				calendar.setProperty("service_id", service_id);
				calendar.setProperty("monday", monday);
				calendar.setProperty("tuesday", tuesday);
				calendar.setProperty("wednesday", wednesday);
				calendar.setProperty("thursday", thursday);
				calendar.setProperty("friday", friday);
				calendar.setProperty("saturday", saturday);
				calendar.setProperty("sunday", sunday);
				calendar.setProperty("start_date", start_date);
				calendar.setProperty("end_date", end_date);
				
				datastore.put(calendar);
			  }
			
			// Frecvente
			
			String frequencies_filename = "/WEB-INF/GTFS/frequencies.txt";
			inputStream = context.getResourceAsStream(frequencies_filename);
		    reader = new BufferedReader (new InputStreamReader (inputStream));

		    String trip_id;
		    String start_time;
		    String end_time;
		    String headway_secs;
		    String exact_times;
		    
		    strLine = reader.readLine();
			while((strLine = reader.readLine())!= null)
			  {
				String delims = "[,]";
				String []tokens = strLine.split(delims);
				
				
				trip_id = tokens[0];
				start_time = tokens[1];
				end_time = tokens[2];
				headway_secs = tokens[3];
				exact_times = tokens[4];
				
				
				Entity frecventa = new Entity ("Frecvente");
				frecventa.setProperty("trip_id", trip_id);
				frecventa.setProperty("start_time", start_time);
				frecventa.setProperty("end_time", end_time);
				frecventa.setProperty("headway_secs", headway_secs);
				frecventa.setProperty("exact_times", exact_times);
				
				datastore.put(frecventa);
			  }
			
			// Forme
			String shapes_filename = "/WEB-INF/GTFS/shapes.txt";
			inputStream = context.getResourceAsStream(shapes_filename);
		    reader = new BufferedReader (new InputStreamReader (inputStream));
		    
		    String shape_id;
		    String shape_pt_lat;
		    String shape_pt_lon;
		    String shape_pt_sequence;
		    
		    strLine = reader.readLine();
			while((strLine = reader.readLine())!= null)
			  {
				String delims = "[,]";
				String []tokens = strLine.split(delims);
				
				
				shape_id = tokens[0];
				shape_pt_lat = tokens[1];
				shape_pt_lon = tokens[2];
				shape_pt_sequence = tokens[3];
			
				Entity forma = new Entity ("Forme");
				forma.setProperty("shape_id", shape_id);
				forma.setProperty("shape_pt_lat", shape_pt_lat);
				forma.setProperty("shape_pt_lon", shape_pt_lon);
				forma.setProperty("shape_pt_sequence", shape_pt_sequence);
				datastore.put(forma);
			  }
			
			// Stop Times
			String stoptimes_filename = "/WEB-INF/GTFS/stop_times.txt";
			inputStream = context.getResourceAsStream(stoptimes_filename);
		    reader = new BufferedReader (new InputStreamReader (inputStream));
		    
		 //   String trip_id;
		    String arrival_time;
		    String departure_time;
		    String stop_id;
		    String stop_sequence;
		    
		    strLine = reader.readLine();
			while((strLine = reader.readLine())!= null)
			  {
				String delims = "[,]";
				String []tokens = strLine.split(delims);
				
				
				trip_id = tokens[0];
				arrival_time = tokens[1];
				departure_time = tokens[2];
				stop_id = tokens[3];
				stop_sequence = tokens[4];
			
				Entity stoptime = new Entity ("Stop Times");
				stoptime.setProperty("trip_id", trip_id);
				stoptime.setProperty("arrival_time", arrival_time);
				stoptime.setProperty("departure_time", departure_time);
				stoptime.setProperty("stop_sequence", stop_sequence);
				datastore.put(stoptime);
			  }
			
			// Statii
			 String stops_filename = "/WEB-INF/GTFS/stops.txt";
			    inputStream = context.getResourceAsStream(stops_filename);
			    reader = new BufferedReader (new InputStreamReader (inputStream));
				
				//String stop_id;
				String stop_name;
				String stop_desc;
				String stop_lat;
				String stop_lon;
				String zone_id;
				String location_type;
				String parent_station;
				
				strLine = reader.readLine();
				while((strLine = reader.readLine())!= null)
				  {
					String delims = "[,]";
					String []tokens = strLine.split(delims);
					
					stop_id = tokens[0];
					stop_name = tokens[1];
					stop_desc = tokens[2];
					stop_lat = tokens[3];
					stop_lon = tokens[4];
					zone_id = tokens[5];
					location_type = tokens[6];
					parent_station = "";
					
					Entity statie = new Entity ("Statii",stop_id);
					statie.setProperty("stop_id", stop_id);
					statie.setProperty("stop_name", stop_name);
					statie.setProperty("stop_desc", stop_desc);
					statie.setProperty("stop_lat", stop_lat);
					statie.setProperty("stop_lon", stop_lon);
					statie.setProperty("zone_id", zone_id);
					statie.setProperty("location_type", location_type);
					statie.setProperty("parent_station", parent_station);
					
					datastore.put(statie);
				  }
			
				// Curse - Trips
				String trips_filename = "/WEB-INF/GTFS/trips.txt";
			    inputStream = context.getResourceAsStream(trips_filename);
			    reader = new BufferedReader (new InputStreamReader (inputStream));
				
				//String route_id;
				//String service_id;
				//String trip_id;
				String trip_headsign;
				String direction_id;
				String wheelchair_accessible;
				//String shape_id;
				
				strLine = reader.readLine();
				while((strLine = reader.readLine())!= null)
				  {
					String delims = "[,]";
					String []tokens = strLine.split(delims);
					
					route_id = tokens[0];
					service_id = tokens[1];
					trip_id = tokens[2];
					trip_headsign = tokens[3];
					direction_id = tokens[4];
					wheelchair_accessible = tokens[5];
					shape_id = tokens[6];
					
					
					Entity cursa = new Entity ("Curse",trip_id);
					cursa.setProperty("route_id", route_id);
					cursa.setProperty("service_id", service_id);
					cursa.setProperty("trip_id", trip_id);
					cursa.setProperty("trip_headsign", trip_headsign);
					cursa.setProperty("direction_id", direction_id);
					cursa.setProperty("wheelchair_accessible", wheelchair_accessible);
					cursa.setProperty("shape_id", shape_id);
					
					datastore.put(cursa);
				  }
	
		
				
		resp.setContentType("text/plain");
        resp.getWriter().println("Saved data");
    }
	
}
