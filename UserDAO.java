package com.niit.collaboration.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.collaboration.model.User;

@Repository
public interface UserDAO {
	
	public boolean save(User user);
	public boolean update(User user);
	public boolean delete(User user);
	public User get(String userid);
	public List<User> list();
}
