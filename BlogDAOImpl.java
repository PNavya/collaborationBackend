package com.niit.collaboration.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration.model.Blog;

@Repository("blogDAO")
public class BlogDAOImpl implements BlogDAO {

	@Autowired
	private SessionFactory sessionfactory;
	public BlogDAOImpl(SessionFactory sessionfactory)
	{
		this.sessionfactory=sessionfactory;
	}
	@Transactional
	public boolean save(Blog blog) {
		// TODO Auto-generated method stub
				try {
					
					sessionfactory.getCurrentSession().save(blog);
					
					return true;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
	}

	@Override
	public boolean update(Blog blog) {
		// TODO Auto-generated method stub
				try {
					
					sessionfactory.getCurrentSession().update(blog);
					
					return true;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
	}

	@Override
	public boolean delete(Blog blog) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				try {
					
					sessionfactory.getCurrentSession().delete(blog);
					
					return true;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
	}

}
