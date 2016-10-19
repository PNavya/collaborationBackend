package com.niit.collaboration.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Job")
@Component
public class Job {
	
	@Id
	private String jobid;
	private String job_title;
	private String company;
	private String Description;
	private Date Dateofcreation;
	private Date Dateofexpiry;
	private String userid;
	public String getJobid() {
		return jobid;
	}
	public void setJobid(String jobid) {
		this.jobid = jobid;
	}
	public String getJob_title() {
		return job_title;
	}
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Date getDateofcreation() {
		return Dateofcreation;
	}
	public void setDateofcreation(Date dateofcreation) {
		Dateofcreation = dateofcreation;
	}
	public Date getDateofexpiry() {
		return Dateofexpiry;
	}
	public void setDateofexpiry(Date dateofexpiry) {
		Dateofexpiry = dateofexpiry;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	

}
