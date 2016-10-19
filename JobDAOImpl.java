package com.niit.collaboration.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration.model.Job;

@Repository("jobDAO")

public class JobDAOImpl implements JobDAO {

	@Autowired
	private SessionFactory sessionfactory;
	public JobDAOImpl(SessionFactory sessionfactory)
	{
		this.sessionfactory=sessionfactory;
	}
	@Transactional
	public boolean save(Job job) {
		// TODO Auto-generated method stub
		try {
			
			sessionfactory.getCurrentSession().save(job);
			
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean update(Job job) {
		// TODO Auto-generated method stub
		try {
			
			sessionfactory.getCurrentSession().update(job);
			
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(Job job) {
		// TODO Auto-generated method stub
		try {
			
			sessionfactory.getCurrentSession().delete(job);
			
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
