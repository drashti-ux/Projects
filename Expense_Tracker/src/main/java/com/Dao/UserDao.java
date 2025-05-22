package com.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.model.User;
import com.util.HibernateUtility;

public class UserDao {
	
	SessionFactory sf = HibernateUtility.getsf();
	
	public int addUser(User u) {
		int i = 0;
		try {
			Session session = sf.openSession();
			Transaction tr = session.beginTransaction();
			session.saveOrUpdate(u);
			tr.commit();
			i = 1;
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return i;
	}
	
	public int DeleteUser(int id) {
		int i = 0;
		try {
			Session session = sf.openSession();
			Transaction tr = session.beginTransaction();
			session.remove(getUser(id));
			tr.commit();
			i = 1;
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return i;
	}
	
	public User getUser(int id) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		return session.get(User.class, id);
	}
	
	public User loginUser(String email,String pass) {
		User u = null;
			try {
				Session session = sf.openSession();
				Transaction tr = session.beginTransaction();
				String q = "from User where email =: e and password =: p";
				Query query = session.createQuery(q);
					query.setParameter("e", email);
					query.setParameter("p", pass);
				u = new User();
				u = (User) query.uniqueResult();
				tr.commit();
				session.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		return u;
	}

	public User isEmail(String email) {
		// TODO Auto-generated method stub
		User u = null;
		try {
			Session session = sf.openSession();
			Transaction tr = session.beginTransaction();
			u = new User();
				u =(User)session.createQuery("from User u where u.email =: e").setParameter("e", email).uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return u;
	}

	
}
