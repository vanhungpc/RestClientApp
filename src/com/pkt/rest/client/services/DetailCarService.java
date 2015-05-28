package com.pkt.rest.client.services;

import java.io.Serializable;

import com.pkt.rest.client.helper.RestHelper;
import com.pkt.rest.client.pojo.DetailCar;

@SuppressWarnings("serial")
public class DetailCarService extends BaseService implements Serializable{
	public static String _PATH = "detailcar";

	protected static DetailCarService instance;

	public String temp;
	public static DetailCarService getInstance() {
		if (instance == null)
			instance = new DetailCarService();

		return instance;
	}

	public String getJsonString() {
		temp = this.getJsonString(_PATH);

		return temp;
	}

	public String getJsonString(int id) {
		temp = this.getJsonString(id);

		return temp;
	}
	
	public boolean insertDetailAndroid(DetailCar object) {
		BaseServiceAndroid service = BaseServiceAndroid.getInstance();
		String path = RestHelper.getInstance().getURI() + "/"
				+ DetailCarService._PATH + "/create";

		return service.post(path, object);
	}
	public String insertDetailCar(DetailCar object) {
		BaseServiceAndroid service = BaseServiceAndroid.getInstance();
		String path = RestHelper.getInstance().getURI() + "/"
				+ DetailCarService._PATH + "/create";

		return service.postGetId(path, object);
	}
	public boolean updateDetailAndroid(DetailCar object) {
		BaseServiceAndroid service = BaseServiceAndroid.getInstance();
		String path = RestHelper.getInstance().getURI() + "/"
				+ DetailCarService._PATH + "/update";

		return service.post(path, object);
	}

	public boolean deleteDetailAndroid(DetailCar object) {
		BaseServiceAndroid service = BaseServiceAndroid.getInstance();
		String path = RestHelper.getInstance().getURI() + "/"
				+ DetailCarService._PATH + "/delete";

		return service.post(path, object);
	}

}
