package com.niit.collaboration.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration.model.Event;

@Repository("eventDAO")

public class EventDAOImpl implements EventDAO{

	@Autowired
	private SessionFactory sessionfactory;
	public EventDAOImpl(SessionFactory sessionfactory)
	{
		this.sessionfactory=sessionfactory;
	}
	@Transactional
	public boolean save(Event event) {
		// TODO Auto-generated method stub
try {
			
			sessionfactory.getCurrentSession().save(event);
			
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean update(Event event) {
		// TODO Auto-generated method stub
try {
			
			sessionfactory.getCurrentSession().update(event);
			
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(Event event) {
		// TODO Auto-generated method stub
try {
			
			sessionfactory.getCurrentSession().delete(event);
			
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
