package com.pkt.rest.client.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.pkt.rest.client.helper.RestHelper;
import com.pkt.rest.client.pojo.Account;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.representation.Form;

public class BaseService {

	protected static BaseService instance;

	public static BaseService getInstance() {
		if (instance == null)
			instance = new BaseService();

		return instance;
	}

	/**
	 * - Phương thức GET - Sử dụng ClientResponse (dùng cho ứng dụng android)
	 * 
	 * @param path
	 * @return
	 */
	public String getJsonStringUsingClientResponse(String path) {
		String strJson = "";

		try {
			WebResource resource = RestHelper.getInstance().CreateWebResource();

			ClientResponse response = resource.path(path).get(
					ClientResponse.class);

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					response.getEntityInputStream()));
			StringBuilder sb = new StringBuilder();
			String line = null;

			while ((line = reader.readLine()) != null) {
				sb.append(line + "");
			}

			strJson = sb.toString();
			reader.close();
			response.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return strJson;
	}

	/*public void post() {
		try {
			WebResource resource;

			ClientConfig config = new DefaultClientConfig();
			Client client = Client.create(config);

			URI uri = UriBuilder.fromUri(
					"http://192.168.0.102:8080/RestServices/accounts/add")
					.build();
			resource = client.resource(uri);
			resource.accept("application/json");
			// resource.type("application/json");

			Account a = new Account();
			a.setEmail("email");
			a.setId(100);
			a.setPassword("sdflsdk");
			a.setUserName("usi");
			resource.queryParam("id", "1000");
			resource.queryParam("username", "username");
			resource.queryParam("password", "1212");
			resource.queryParam("email", "email");
			resource.entity(a);
			ClientResponse response = resource.post(ClientResponse.class);

			if (response.getStatus() != 200) {
				// System.out.println(response.getEntity(String.class));
				response.close();
			}
			// System.out.println(response.getEntity(String.class));
			response.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}*/

	/**
	 * - Phương thức GET - Sử dụng ClientResponse (dùng cho ứng dụng android)
	 * 
	 * @param path
	 * @param id
	 * @return
	 */
	public String getJsonStringUsingClientResponse(String path, int id) {
		String strJson = "";

		try {
			WebResource resource = RestHelper.getInstance().CreateWebResource();

			ClientResponse response = resource.path(path)
					.path(String.valueOf(id)).get(ClientResponse.class);

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					response.getEntityInputStream()));
			StringBuilder sb = new StringBuilder();
			String line = null;

			while ((line = reader.readLine()) != null) {
				sb.append(line + "");
			}

			strJson = sb.toString();
			reader.close();
			response.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return strJson;
	}

	public boolean post(Object object) {
		try {
			String path = "accounts/add/";
			WebResource resource = RestHelper.getInstance().CreateWebResource();
			path += "1000/pkt/123456a@/pkt@gmail.com";
			ClientResponse response = resource.path(path)
					.accept(MediaType.TEXT_PLAIN).post(ClientResponse.class);

			if (response.getStatus() != 200) {
				response.close();
				return false;
			}

			response.close();
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	/**
	 * 
	 * @param a
	 * @param paths
	 *            : list path - example: "accounts/add"
	 */
	public boolean post(Object object, String... paths) {
		try {
			String path = "";
			for (int i = 0; i < paths.length; i++) {
				path += "/" + paths[i];
			}

			WebResource resource = RestHelper.getInstance().CreateWebResource();
			resource.entity("{sflaksdfj}");
			ClientResponse response = resource.path(path)
					.accept(MediaType.APPLICATION_JSON)
					.type(MediaType.APPLICATION_JSON)
					.post(ClientResponse.class, object);

			if (response.getStatus() != 200) {
				response.close();
				return false;
			}

			response.close();
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	/**
	 * - Using Form to post server
	 * 
	 * @param paths
	 * @param formsData
	 * @param formsId
	 * @return
	 */
	public boolean post(String[] paths, String[] formsData, String[] formsId) {
		try {
			String path = "";
			for (int i = 0; i < paths.length; i++) {
				path += "/" + paths[i];
			}
			WebResource resource = RestHelper.getInstance().CreateWebResource();
			Form form = new Form();
			for (int i = 0; i < formsId.length; i++) {
				form.add(formsId[i], formsData[i]);
			}
			ClientResponse response = resource.path(path)
					.type(MediaType.APPLICATION_FORM_URLENCODED)
					.post(ClientResponse.class, form);

			if (response.getStatus() != 200) {
				System.out.println(response.getEntity(String.class));
				response.close();
				return false;
			}
			response.close();
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	public boolean put(Object object, String... paths) {
		try {
			String path = "";
			for (int i = 0; i < paths.length; i++) {
				path += "/" + paths[i];
			}
			WebResource resource = RestHelper.getInstance().CreateWebResource();
			ClientResponse response = resource.path(path)
					.accept(MediaType.APPLICATION_JSON)
					.type(MediaType.APPLICATION_JSON)
					.put(ClientResponse.class, object);

			if (response.getStatus() != 200) {
				System.out.println(response.getEntity(String.class));
				response.close();
				return false;
			}
			response.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

		return true;
	}

	// Get all account
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

	// Get account by id
	public String getJsonString(String path, int id) {
		String strJson = "";

		WebResource serResource = RestHelper.getInstance().CreateWebResource();
		strJson = serResource.path(path).path(String.valueOf(id))
				.accept(MediaType.APPLICATION_JSON).get(String.class);

		return strJson;
	}

}
