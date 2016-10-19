package com.niit.collaboration.dao;

import com.niit.collaboration.model.Event;

public interface EventDAO {

	public boolean save(Event event);
	public boolean update(Event event);
	public boolean delete(Event event);

}
