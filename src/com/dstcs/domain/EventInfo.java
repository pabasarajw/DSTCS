package com.dstcs.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="eventinfo")
public class EventInfo {

	@Id
    private String id;
	
	private String eventName;
	private String eventDescription;
	private Date eventFrom;
	private Date eventTo;
	private double eLatitude;
	private double eLongitude;
	private String eAddress;
	private double fLongitude;
	private double fLatitude;
	private double tLongitude;
	private double tLatitude;
	private String fAddress;
	private String tAddress;
	private double distance;
	private String level;
	private Date date;
	private User user;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventDescription() {
		return eventDescription;
	}
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	public Date getEventFrom() {
		return eventFrom;
	}
	public void setEventFrom(Date eventFrom) {
		this.eventFrom = eventFrom;
	}
	public Date getEventTo() {
		return eventTo;
	}
	public void setEventTo(Date eventTo) {
		this.eventTo = eventTo;
	}
	public double geteLatitude() {
		return eLatitude;
	}
	public void seteLatitude(double eLatitude) {
		this.eLatitude = eLatitude;
	}
	public double geteLongitude() {
		return eLongitude;
	}
	public void seteLongitude(double eLongitude) {
		this.eLongitude = eLongitude;
	}
	public String geteAddress() {
		return eAddress;
	}
	public void seteAddress(String eAddress) {
		this.eAddress = eAddress;
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
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
