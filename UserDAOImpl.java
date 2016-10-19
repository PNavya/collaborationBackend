package com.niit.collaboration.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration.model.User;



@Repository("userDAO")
public class UserDAOImpl implements UserDAO{

	@Autowired
	private SessionFactory sessionfactory;
	public UserDAOImpl(SessionFactory sessionfactory)
	{
		this.sessionfactory=sessionfactory;
	}
	@Transactional
	public boolean save(User user) {
		// TODO Auto-generated method stub
		try {
			
			sessionfactory.getCurrentSession().save(user);
			
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public boolean update(User user) {
		try {
			sessionfactory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(User user) {
		// TODO Auto-generated method stub
		try {
			sessionfactory.getCurrentSession().delete(user);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public User get(String userid) {
		// TODO Auto-generated method stub
		Session s=sessionfactory.getCurrentSession();
		Transaction tx=s.beginTransaction();
			String hql = "from User where userid=" + "'" + userid + "'";
			Query query = s.createQuery(hql);
			List<User> list = query.list();
			if (list == null)

				return null;
			else {
				return list.get(0);
			}
	}

	@Transactional
	public List<User> list() {
		// TODO Auto-generated method stub
		String hql = "from User";
		Query query = sessionfactory.getCurrentSession().createQuery(hql);
		return query.list();

	}

}
