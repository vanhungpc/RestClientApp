package com.pkt.rest.client.pojo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class DetailCar implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1838907677488441289L;
	private int id;
	private String nameDetail;
	private String price;
	private String bodyType;
	private String doors;
	private String exteriorColor;
	private String fuel;
	private String engine;
	private String transmission;
	private String origin;
	private String milliage;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameDetail() {
		return nameDetail;
	}
	public void setNameDetail(String nameDetail) {
		this.nameDetail = nameDetail;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getBodyType() {
		return bodyType;
	}
	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}
	public String getDoors() {
		return doors;
	}
	public void setDoors(String doors) {
		this.doors = doors;
	}
	public String getExteriorColor() {
		return exteriorColor;
	}
	public void setExteriorColor(String exteriorColor) {
		this.exteriorColor = exteriorColor;
	}
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	public String getEngine() {
		return engine;
	}
	public void setEngine(String engine) {
		this.engine = engine;
	}
	public String getTransmission() {
		return transmission;
	}
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getMilliage() {
		return milliage;
	}
	public void setMilliage(String milliage) {
		this.milliage = milliage;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
