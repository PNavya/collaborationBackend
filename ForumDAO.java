package com.niit.collaboration.dao;

import com.niit.collaboration.model.Forum;

public interface ForumDAO {
	
	public boolean save(Forum forum);
	public boolean update(Forum forum);
	public boolean delete(Forum forum);

}
