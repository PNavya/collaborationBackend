package com.niit.collaborations.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaborations.dao.UserDAO;
import com.niit.collaborations.model.User;

@RestController
public class UserController {
	
	private static final Logger logger	= LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers(){
		logger.debug("calling method listAllUsers");
		List<User> user=userDAO.list();
		if(user.isEmpty()){
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(user,HttpStatus.OK);
	}

	@RequestMapping(value="/user/",method=RequestMethod.POST)
	public ResponseEntity<User> createUser(@RequestBody User user){
		logger.debug("calling method createUser" + user.getUserid());
		if(userDAO.save(user)==true){
			return new ResponseEntity<User>(user,HttpStatus.OK);			
		}
		logger.debug("user already exists with id:" + user.getUserid());
		user.setErrormessage("user already exists with id:" + user.getUserid());
		return new ResponseEntity<User>(user,HttpStatus.OK);
			}
	
	@RequestMapping(value="/user/{id}",method=RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@PathVariable("id") String userid,@RequestBody User user){
		logger.debug("calling method updateUser" + user.getUserid());
		if(userDAO.get(userid)==null){
			logger.debug("user does not exists with id:" + user.getUserid());		
			user=new User();
			user.setErrormessage("user does not exists with id:" + user.getUserid());
			return new ResponseEntity<User> (user,HttpStatus.NOT_FOUND);
		}
		userDAO.update(user);
		logger.debug("user updated successfully");
		return new ResponseEntity<User> (user,HttpStatus.OK);		
	}

	@RequestMapping(value="/user/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<User> deleteUser(@PathVariable("id") String userid){
		logger.debug("calling method deleteUser for user id: " + userid);
		User user=userDAO.get(userid);
		if(user==null){
			logger.debug("user does not exists with id:" + userid);
			user=new User();
			user.setErrormessage("user does not exists with id:" + userid);
			return new ResponseEntity<User> (user,HttpStatus.NOT_FOUND);	
		}
		userDAO.delete(user);
		logger.debug("user deleted successfully");
		return new ResponseEntity<User> (user,HttpStatus.OK);		
	}
	
	@RequestMapping(value="/user/{id}",method=RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable("id") String userid){
		logger.debug("calling method getUser for user id: " + userid);
		User user=userDAO.get(userid);
		if(user==null){
			logger.debug("user does not exists with id:" + userid);
			user=new User();
			user.setErrormessage("user does not exists with id:" + userid);
			return new ResponseEntity<User> (user,HttpStatus.NOT_FOUND);
		}
		logger.debug("user exists with id:" + userid);
		return new ResponseEntity<User> (user,HttpStatus.OK);
	}


}


