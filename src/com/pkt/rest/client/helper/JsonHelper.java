package com.pkt.rest.client.helper;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonHelper {
	
protected static JsonHelper instance;
	
	public static JsonHelper GetInstance(){
		if(instance == null)
			instance = new JsonHelper();
		
		return instance;
	}
	
	/**
	 * 
	 * @param strJson
	 * @return
	 */
	public JsonObject GetJsonObject(String strJson){
		JsonParser jsonParser = new JsonParser();
		JsonObject jsonObject = (JsonObject) jsonParser.parse(strJson);
		
		return jsonObject;
	}
	
	/**
	 * 
	 * @param jsonObject
	 * @param memberName
	 * @return
	 */
	public JsonArray GetJsonArray(JsonObject jsonObject, String memberName){
		JsonArray jsonArray = jsonObject.getAsJsonArray(memberName);
		
		return jsonArray;
	}
	
	/**
	 * 
	 * @param strJson
	 * @param typeOfT
	 * @return
	 * 
	 * {"email":"pkt@gmail.com","id":"2","password":"123456a@","userName":"pkt"}
	 * 
	 */
	public Object GetObjectUsingGson(String strJson, Type typeOfT){
		Object object = new Gson().fromJson(strJson, typeOfT);
		
		return object;
	}
	
	/**
	 * @author PHAM KHANH THUAN
	 * @param strJson
	 * @param typeOfT
	 * @param memberName
	 * @return Object
	 * 
	 * {
	 *		"account":
	 *		[
	 *			{"email":"pkt@gmail.com","id":"2","password":"123456a@","userName":"pkt"},
	 *			{"email":"spring@gmail.com","id":"4","password":"123456a@","userName":"spring"}
	 *		]
	 *	}
	 * 
	 */
	public Object GetObjectUsingGson(String strJson, Type typeOfT, String memberName){
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		JsonObject jo = (JsonObject) parser.parse(strJson);
		JsonArray ja = jo.getAsJsonArray(memberName);
		Object object = gson.fromJson(ja, typeOfT);
		
		return object;
	}
	

}
