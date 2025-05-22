package com.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.model.Transn;
import com.model.User;
import com.util.HibernateUtility;

public class TransDao {
SessionFactory sf = HibernateUtility.getsf();
	
	public int addTransaction(Transn tn) {
		int i = 0;
		try {
			Session session = sf.openSession();
			Transaction tr = session.beginTransaction();
			session.saveOrUpdate(tn);
			tr.commit();
			i = 1;
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return i;
	}
	
	public int DeleteTransaction(int id) {
		int i = 0;
		try {
			Session session = sf.openSession();
			Transaction tr = session.beginTransaction();
			session.remove(getTransaction(id));
			tr.commit();
			i = 1;
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return i;
	}
	
	public Transn getTransaction(int id) {
		Transn t = null;
			try {
				Session session = sf.openSession();
				Transaction tr = session.beginTransaction();
				t = session.get(Transn.class,id);
				tr.commit();
			} catch (Exception e) {
				// TODO: handle exception
			}
		return t;
	}
	
	public double getIncome(User u) {
		double inc = 0; 
		// TODO Auto-generated method stub
		try {
			Session session = sf.openSession();
			Transaction tr = session.beginTransaction();
			String q = "SELECT SUM(t.amount) FROM Transn t WHERE t.user = :u AND t.type = 'income'";
			Query query = session.createQuery(q);
			query.setParameter("u", u);
			inc = (double) query.uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return inc;
	}

	public double getExpense(User u) {
		double inc = 0; 
		// TODO Auto-generated method stub
		try {
			Session session = sf.openSession();
			Transaction tr = session.beginTransaction();
			String q = "SELECT SUM(t.amount) FROM Transn t WHERE t.user = :u AND t.type = 'expense'";
			Query query = session.createQuery(q);
			query.setParameter("u", u);
			inc = (double) query.uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return inc;
	}

	public List<Transn> getTrans(User u) {
		List<Transn>  trs = null;
		try {
			Session session = sf.openSession();
			Transaction tr = session.beginTransaction();
			Query query = session.createQuery("FROM Transn t WHERE t.user =:u ORDER BY t.date DESC");
			query.setParameter("u", u);
			query.setMaxResults(7);
			trs = query.list();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return trs;
	}

	public List<Transn> allTransactions(User u) {
		// TODO Auto-generated method stub
		List<Transn>  trs = null;
		try {
			Session session = sf.openSession();
			Transaction tr = session.beginTransaction();
			Query query = session.createQuery("FROM Transn t WHERE t.user =:u ORDER BY t.date DESC");
			query.setParameter("u", u);
			trs = query.list();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return trs;
	}

	public List<Transn> searchTransactions(String keyword,User u) {
		// TODO Auto-generated method stub
		List<Transn>  trs = null;
		try {
			Session session = sf.openSession();
			Transaction tr = session.beginTransaction();
			String hql = "FROM Transn t WHERE t.user = :u AND (" +
		             "t.category LIKE :cat OR " +
		             "t.note LIKE :n OR " +
		             "t.type LIKE :tp OR " +
		             "str(t.amount) LIKE :am OR " +
		             "str(t.date) LIKE :dt)";
			Query query = session.createQuery(hql);
			query.setParameter("u", u);
			query.setParameter("cat", "%" + keyword + "%");
			query.setParameter("n", "%" + keyword + "%");
			query.setParameter("tp", "%" + keyword + "%");
			query.setParameter("am", "%" + keyword + "%");
			query.setParameter("dt", "%" + keyword + "%");
			trs = query.list();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return trs;
	}
	
	
}
