package com.pkt.rest.client.services;

import com.pkt.rest.client.helper.RestHelper;
import com.pkt.rest.client.pojo.Vehicle;

public class VehicleService extends BaseService {

	public static String _PATH = "vehicles";

	protected static VehicleService instance;

	public String temp;

	public static VehicleService getInstance() {
		if (instance == null)
			instance = new VehicleService();

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
	public boolean insertVehicle(Vehicle object) {
		BaseServiceAndroid service = BaseServiceAndroid.getInstance();
		String path = RestHelper.getInstance().getURI() + "/"
				+ VehicleService._PATH + "/create";

		return service.post(path, object);

	}

	public boolean updateVehicle(Vehicle object) {
		BaseServiceAndroid service = BaseServiceAndroid.getInstance();
		String path = RestHelper.getInstance().getURI() + "/"
				+ VehicleService._PATH + "/update";
		return service.post(path, object);
	}

	public boolean deleteVehicle(Vehicle object) {
		BaseServiceAndroid service = BaseServiceAndroid.getInstance();
		String path = RestHelper.getInstance().getURI() + "/"
				+ VehicleService._PATH + "/delete";
		return service.post(path, object);
	}

}
