package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.Transn;
import com.model.User;

public class HibernateUtility {
		
	public static SessionFactory getsf() {
		SessionFactory sf = null;
		try {
			sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).addAnnotatedClass(Transn.class).buildSessionFactory();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return sf;
	};
	
}
