package com.dstcs.domain;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="roaddevelopmentinfo")
public class RoadDevelopmentInfo {

	@Id
    private String id;
	
	private double fLongitude;
	private double fLatitude;
	private double tLongitude;
	private double tLatitude;
	private String fAddress;
	private String tAddress;
	private double distance;
	private Date fromDate;
	private Date toDate;
	private String level;
	private String description;
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
	public String getfAddress() {
		return fAddress;
	}
	public void setfAddress(String fAddress) {
		this.fAddress = fAddress;
	}
	public String gettAddress() {
		return tAddress;
	}
	public void settAddress(String tAddress) {
		this.tAddress = tAddress;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
