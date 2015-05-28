package com.pkt.rest.client.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Vehicle {
	private int id;
	private int idAccount;
	private String name;
	private float price;
	private String yearProc; //nam san xuat
	
	private List<Image> images = new ArrayList<Image>();
	
	private List<Comment> comments = new ArrayList<Comment>();
	
	private InfoAccount infoAccount = new InfoAccount();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name.trim();
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getYearProc() {
		return yearProc;
	}

	public void setYearProc(String yearProc) {
		this.yearProc = yearProc.trim();
	}

	@XmlElement
	public InfoAccount getInfoAccount() {
		return infoAccount;
	}

	public void setInfoAccount(InfoAccount infoAccount) {
		this.infoAccount = infoAccount;
	}

	@XmlElement
	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	@XmlElement
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
}
