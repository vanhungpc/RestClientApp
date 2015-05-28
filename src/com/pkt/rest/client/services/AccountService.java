package com.pkt.rest.client.services;

import java.io.Serializable;

import com.pkt.rest.client.helper.RestHelper;
import com.pkt.rest.client.pojo.Account;

@SuppressWarnings("serial")
public class AccountService extends BaseService implements Serializable {

	public static String _PATH = "accounts";

	protected static AccountService instance;

	public String temp;

	public static AccountService getInstance() {
		if (instance == null)
			instance = new AccountService();

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

	public String getUseAndroid() {
		BaseServiceAndroid service = BaseServiceAndroid.getInstance();
		String path = RestHelper.getInstance().getURI() + "/"
				+ AccountService._PATH;
		String str = service.get(path, null);

		return str;
	}

	public String getUseAndroid(String id) {
		BaseServiceAndroid service = BaseServiceAndroid.getInstance();
		String path = RestHelper.getInstance().getURI() + "/"
				+ AccountService._PATH;
		String str = service.get(path, id);

		return str;
	}

	public String createUserAndroid(Account object) {
		BaseServiceAndroid service = BaseServiceAndroid.getInstance();
		String path = RestHelper.getInstance().getURI() + "/"
				+ AccountService._PATH + "/create";

		return service.postGetId(path, object);
	}
	//check login 
	public String checkLogin(Account object){
		BaseServiceAndroid service = BaseServiceAndroid.getInstance();
		String path = RestHelper.getInstance().getURI() + "/"
				+ AccountService._PATH + "/checklogin";

		return service.postGetId(path, object);
	}

	public boolean updateUserAndroid(Account object) {
		BaseServiceAndroid service = BaseServiceAndroid.getInstance();
		String path = RestHelper.getInstance().getURI() + "/"
				+ AccountService._PATH + "/update";

		return service.post(path, object);
	}

	public boolean deleteUserAndroid(Account object) {
		BaseServiceAndroid service = BaseServiceAndroid.getInstance();
		String path = RestHelper.getInstance().getURI() + "/"
				+ AccountService._PATH + "/delete";

		return service.post(path, object);
	}
}
