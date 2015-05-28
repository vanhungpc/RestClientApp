package com.pkt.rest.client.helper;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class RestHelper {
	
//	private static String _URI = "http://localhost:8080/RestServices";
	private static String _URI = "http://49.212.156.64:8080/RestService_SFC";
	
	protected static RestHelper instance;
	
	public static RestHelper getInstance(){
		if(instance == null)
			instance = new RestHelper();
		
		return instance;
	}
	
	public URI getBaseURI(){
		URI uri = null;
		
		try {
			uri = UriBuilder.fromUri(_URI).build();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return uri;
	}
	
	public String getURI(){
		return _URI;
	}
	
	public WebResource CreateWebResource(){
		WebResource service = null;
		try {
			ClientConfig config = new DefaultClientConfig();
			Client client = Client.create(config);
			
			service = client.resource(getBaseURI());
			
			return service;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return service;
	}

}












