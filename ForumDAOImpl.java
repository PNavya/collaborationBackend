package com.niit.collaboration.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration.model.Forum;

@Repository("forumDAO")
public class ForumDAOImpl implements ForumDAO{

	@Autowired
	private SessionFactory sessionfactory;
	public ForumDAOImpl(SessionFactory sessionfactory)
	{
		this.sessionfactory=sessionfactory;
	}
	@Transactional
	public boolean save(Forum forum) {
		// TODO Auto-generated method stub
		try {
			
			sessionfactory.getCurrentSession().save(forum);
			
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public boolean update(Forum forum) {
		// TODO Auto-generated method stub
		try {
			
			sessionfactory.getCurrentSession().update(forum);
			
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean delete(Forum forum) {
		// TODO Auto-generated method stub
		try {
			
			sessionfactory.getCurrentSession().delete(forum);
			
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
}
