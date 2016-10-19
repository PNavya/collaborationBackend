package com.niit.collaboration.dao;

import com.niit.collaboration.model.Blog;

public interface BlogDAO {

	public boolean save(Blog blog);
	public boolean update(Blog blog);
	public boolean delete(Blog blog);
}
