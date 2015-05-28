package com.pkt.rest.client.services;

import com.pkt.rest.client.helper.RestHelper;
import com.pkt.rest.client.pojo.Image;

public class ImageService extends BaseService {
	
	public static String _PATH = "images";
	public String temp;

	protected static ImageService instance;

	public static ImageService getInstance() {
		if (instance == null)
			instance = new ImageService();

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
	public String getImagesAndroid() {
		BaseServiceAndroid service = BaseServiceAndroid.getInstance();
		String path = RestHelper.getInstance().getURI() + "/"
				+ ImageService._PATH;
		String str = service.get(path, null);

		return str;
	}
	public boolean insertImagesAndroid(Image object) {
		BaseServiceAndroid service = BaseServiceAndroid.getInstance();
		String path = RestHelper.getInstance().getURI() + "/"
				+ ImageService._PATH + "/create";

		return service.post(path, object);
	}
	public String insertImagesCar(Image object) {
		BaseServiceAndroid service = BaseServiceAndroid.getInstance();
		String path = RestHelper.getInstance().getURI() + "/"
				+ ImageService._PATH + "/create";

		return service.postGetId(path, object);
	}
	public boolean updateImagesAndroid(Image object) {
		BaseServiceAndroid service = BaseServiceAndroid.getInstance();
		String path = RestHelper.getInstance().getURI() + "/"
				+ ImageService._PATH + "/update";

		return service.post(path, object);
	}

	public boolean deleteImagesAndroid(Image object) {
		BaseServiceAndroid service = BaseServiceAndroid.getInstance();
		String path = RestHelper.getInstance().getURI() + "/"
				+ ImageService._PATH + "/delete";

		return service.post(path, object);
	}

}
