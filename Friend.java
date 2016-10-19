package com.niit.collaboration.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Friend")
@Component
public class Friend {
	@Id
	private String Friend_id;
	private String Friend_Name;
	private String userid;
	private String status;
	public String getFriend_id() {
		return Friend_id;
	}
	public void setFriend_id(String friend_id) {
		Friend_id = friend_id;
	}
	public String getFriend_Name() {
		return Friend_Name;
	}
	public void setFriend_Name(String friend_Name) {
		Friend_Name = friend_Name;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
