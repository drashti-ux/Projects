package com;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
//
//import com.model.Budget;
//import com.model.Categories;
//import com.model.Expense;
//import com.model.Income;
import com.model.User;

public class addController {
	
	public static void main(String[] args) {
		User usr = new User();
		usr.setUname("drashti");
		usr.setEmail("drashti@gmail.com");
		usr.setPassword("134");
//		usr.setDate(LocalDate.now());
		
//		Categories cat = new Categories();
//		cat.setC_name("food");
//		cat.setUser(usr);
//		
//		Expense exp = new Expense();
//		exp.setE_name("pizza");
//		exp.setE_amount(700.50);
//		exp.setNote("Birthday party");
//		exp.setCategory(cat);
//		exp.setUser(usr);
//		exp.setE_date(LocalDate.of(2025, 01, 20));
//		exp.setCreated_at(LocalDate.now());
//		
//		Income incm = new Income();
//		incm.setIn_amount(25000);
//		incm.setSource("job");
//		incm.setDate(LocalDate.of(2025, 11, 01));
//		incm.setCreated_at(LocalDate.now());
//		incm.setUser(usr);
//		
//		Budget budg = new Budget();
//		budg.setB_amount(5000.00);
//		budg.setMonth(02);
//		budg.setYear(2025);
//		budg.setUser(usr);
//		
//		usr.addBudget(budg);
//		usr.addCategory(cat);
//		usr.addExpense(exp);
//		usr.addIncome(incm);
		
//		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).addAnnotatedClass(Categories.class).addAnnotatedClass(Expense.class).addAnnotatedClass(Income.class).addAnnotatedClass(Budget.class).buildSessionFactory();
//		Session session = sf.openSession();
//		Transaction tr = session.beginTransaction();
//		session.persist(usr);
//		session.persist(cat);
//		session.persist(exp);
//		session.persist(incm);
//		session.persist(budg);
//		tr.commit();
	}
}
