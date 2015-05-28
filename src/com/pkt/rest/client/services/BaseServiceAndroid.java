package com.pkt.rest.client.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

import javax.ws.rs.core.MediaType;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;
import com.pkt.rest.client.helper.RestHelper;
import com.sun.jersey.api.client.WebResource;

public class BaseServiceAndroid {

	private static BaseServiceAndroid instance;

	public static BaseServiceAndroid getInstance() {
		if (instance == null)
			instance = new BaseServiceAndroid();
		return instance;
	}

	public boolean post(String path, Object object) {
		try {
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost postRequest = new HttpPost(path);

			Gson gson = new Gson();
			String strJson = gson.toJson(object);
			StringEntity input = new StringEntity(strJson);
			input.setContentType("application/json");
			postRequest.setEntity(input);

			HttpResponse response = httpClient.execute(postRequest);

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatusLine().getStatusCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(response.getEntity().getContent())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			httpClient.getConnectionManager().shutdown();

		} catch (MalformedURLException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	public String postGetId(String path, Object object){
		String result = "";
		try {
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost postRequest = new HttpPost(path);

			Gson gson = new Gson();
			String strJson = gson.toJson(object);
			StringEntity input = new StringEntity(strJson);
			input.setContentType("application/json");
			postRequest.setEntity(input);

			HttpResponse response = httpClient.execute(postRequest);

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatusLine().getStatusCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(response.getEntity().getContent())));

			
			System.out.println("Output from Server .... \n");
			String output;
			while ((output = br.readLine()) != null) {
				result  = output;
				System.out.println(output);
				break;
			}

			httpClient.getConnectionManager().shutdown();

		} catch (MalformedURLException e) {
			e.printStackTrace();
//			return false;
		} catch (IOException e) {
			e.printStackTrace();
//			return false;
		}

		return result;
	}

	public String getJsonString(String path) {
		String strJson = "";

		WebResource service = RestHelper.getInstance().CreateWebResource();
		try {
			strJson = service.path(path).accept(MediaType.APPLICATION_JSON)
					.get(String.class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return strJson;
	}

	public String get(String path, String id) {
		String strJson = "";
		try {

			DefaultHttpClient httpClient = new DefaultHttpClient();
			if (id != null)
				path += "/" + id;
			HttpGet getRequest = new HttpGet(path);
			getRequest.addHeader("accept", "application/json");

			HttpResponse response = httpClient.execute(getRequest);

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatusLine().getStatusCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(response.getEntity().getContent())));

			StringBuilder sb = new StringBuilder();
			String line = null;

			while ((line = br.readLine()) != null) {
				sb.append(line + "");
			}

			httpClient.getConnectionManager().shutdown();
			strJson = sb.toString();

		} catch (ClientProtocolException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}

		return strJson;
	}

}
