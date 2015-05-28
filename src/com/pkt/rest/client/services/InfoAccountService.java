package com.pkt.rest.client.services;

public class InfoAccountService extends BaseService {

	public static String _PATH = "infoAccounts";

	protected static InfoAccountService instance;

	public static InfoAccountService getInstance() {
		if (instance == null)
			instance = new InfoAccountService();

		return instance;
	}

}
