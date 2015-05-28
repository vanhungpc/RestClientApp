package com.pkt.rest.client.services;

import java.io.Serializable;

import com.pkt.rest.client.helper.RestHelper;
import com.pkt.rest.client.pojo.Account;
import com.pkt.rest.client.pojo.Car;

@SuppressWarnings("serial")
public class CarService extends BaseService implements Serializable{
	public static String _PATH = "addcar";

	protected static CarService instance;

	public String temp;

	public static CarService getInstance() {
		if (instance == null)
			instance = new CarService();

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

	public String getCarAndroid() {
		BaseServiceAndroid service = BaseServiceAndroid.getInstance();
		String path = RestHelper.getInstance().getURI() + "/"
				+ CarService._PATH;
		String str = service.get(path, null);

		return str;
	}
	public String getCarAndroidByAccount(String idAcc){
		BaseServiceAndroid service = BaseServiceAndroid.getInstance();
		String path = RestHelper.getInstance().getURI() + "/"
				+ CarService._PATH;
		String str = service.get(path, idAcc);

		return str;
	}

	public String getCarAndroid(String id) {
		BaseServiceAndroid service = BaseServiceAndroid.getInstance();
		String path = RestHelper.getInstance().getURI() + "/"
				+ CarService._PATH;
		String str = service.get(path, id);

		return str;
	}

	public String insertCar(Car object) {
		BaseServiceAndroid service = BaseServiceAndroid.getInstance();
		String path = RestHelper.getInstance().getURI() + "/"
				+ CarService._PATH + "/create";

		return service.postGetId(path, object);
	}
	public boolean updateCarAndroid(Account object) {
		BaseServiceAndroid service = BaseServiceAndroid.getInstance();
		String path = RestHelper.getInstance().getURI() + "/"
				+ CarService._PATH + "/update";

		return service.post(path, object);
	}

	public boolean deleteCarAndroid(Account object) {
		BaseServiceAndroid service = BaseServiceAndroid.getInstance();
		String path = RestHelper.getInstance().getURI() + "/"
				+ CarService._PATH + "/delete";

		return service.post(path, object);
	}
}
