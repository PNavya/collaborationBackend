package com.niit.collaboration.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Event")
@Component
public class Event {
	@Id
	private String Eventid;
	private String Event_name;
	private String userid;
	private Date Event_Date;
	private String place;
	private String Event_Time;
	private String status;
	public String getEventid() {
		return Eventid;
	}
	public void setEventid(String eventid) {
		Eventid = eventid;
	}
	public String getEvent_name() {
		return Event_name;
	}
	public void setEvent_name(String event_name) {
		Event_name = event_name;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Date getEvent_Date() {
		return Event_Date;
	}
	public void setEvent_Date(Date event_Date) {
		Event_Date = event_Date;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getEvent_Time() {
		return Event_Time;
	}
	public void setEvent_Time(String event_Time) {
		Event_Time = event_Time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
