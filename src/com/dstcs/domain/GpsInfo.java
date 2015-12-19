package com.dstcs.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="gpsinfo")
public class GpsInfo {

	@Id
    private String id;
	
	private double fLongitude;
	private double fLatitude;
	private double tLongitude;
	private double tLatitude;
	private double distance;
	private double speed;
	private String level;
	private String description;
	private String weather;
	private Date date;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getfLongitude() {
		return fLongitude;
	}
	public void setfLongitude(double fLongitude) {
		this.fLongitude = fLongitude;
	}
	public double getfLatitude() {
		return fLatitude;
	}
	public void setfLatitude(double fLatitude) {
		this.fLatitude = fLatitude;
	}
	public double gettLongitude() {
		return tLongitude;
	}
	public void settLongitude(double tLongitude) {
		this.tLongitude = tLongitude;
	}
	public double gettLatitude() {
		return tLatitude;
	}
	public void settLatitude(double tLatitude) {
		this.tLatitude = tLatitude;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
