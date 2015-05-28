package com.pkt.rest.client.pojo;
import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@XmlRootElement
public class Car implements Serializable{
	private int idCar;
	private String nameCar;
	private String timeSale;
	private int idCarline;
	private int idModel;
	private int idAcc;
	private int idDetal;
	private int idCity;
//	private List<Images> images = new ArrayList<Images>();
//	private List<Comment> comment = new ArrayList<Comment>();
//	private Account account = new Account();
//	private DetailCar detailCar = new DetailCar();
//	private Model model = new Model();
//	private Location location = new Location();
//	private CarLine carline = new CarLine();
//	private City city = new City();
//
//	private Producer producer = new Producer();
//	private Domain domain = new Domain();
	private DetailCar detailCar;
	private List<Image> arrImage;
	private String lat;
	private String lon;
	private List<Comment> arrComment;
	public int getIdCar() {
		return idCar;
	}
	public void setIdCar(int idCar) {
		this.idCar = idCar;
	}
	public String getNameCar() {
		return nameCar;
	}
	public void setNameCar(String nameCar) {
		this.nameCar = nameCar;
	}
	public String getTimeSale() {
		return timeSale;
	}
	public void setTimeSale(String timeSale) {
		this.timeSale = timeSale;
	}
	public int getIdCarline() {
		return idCarline;
	}
	public void setIdCarline(int idCarline) {
		this.idCarline = idCarline;
	}
	public int getIdModel() {
		return idModel;
	}
	public void setIdModel(int idModel) {
		this.idModel = idModel;
	}
	public int getIdAcc() {
		return idAcc;
	}
	public void setIdAcc(int idAcc) {
		this.idAcc = idAcc;
	}
	public int getIdDetal() {
		return idDetal;
	}
	public void setIdDetal(int idDetal) {
		this.idDetal = idDetal;
	}
	public int getIdCity() {
		return idCity;
	}
	public void setIdCity(int idCity) {
		this.idCity = idCity;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	public DetailCar getDetailCar() {
		return detailCar;
	}
	public void setDetailCar(DetailCar detailCar) {
		this.detailCar = detailCar;
	}
	public List<Image> getArrImage() {
		return arrImage;
	}
	public void setArrImage(List<Image> arrImage) {
		this.arrImage = arrImage;
	}
	public int getNumberOfPages() {
		// TODO Auto-generated method stub
		return 0;
	}
	public List<Comment> getArrComment() {
		return arrComment;
	}
	public void setArrComment(List<Comment> arrComment) {
		this.arrComment = arrComment;
	}
	
	
}
