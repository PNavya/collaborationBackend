package com.niit.collaboration.dao;

import com.niit.collaboration.model.Job;

public interface JobDAO {
	
	public boolean save(Job job);
	public boolean update(Job job);
	public boolean delete(Job job);

}
