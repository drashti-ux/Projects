package com.controller.transactionController;

import java.io.IOException;
import java.time.LocalDate;

import com.Dao.TransDao;
import com.model.Transn;
import com.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/view/transaction")
public class AddTransactionController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String type = req.getParameter("type");
		double amount = Double.parseDouble(req.getParameter("amount"));
		String category = req.getParameter("cat");
		LocalDate date = LocalDate.parse(req.getParameter("date"));
		String note = req.getParameter("note");
		HttpSession sn = req.getSession();
		
		User u = (User) sn.getAttribute("username");
		Transn tr = new Transn();
		
		
		tr.setType(type);
		tr.setAmount(amount);
		tr.setCategory(category);
		tr.setDate(date);
		tr.setNote(note);
		tr.setUser(u);
		
		TransDao dao = new TransDao();
		int i = dao.addTransaction(tr);
		if(i>0) {
//			req.setAttribute(note, dao);
			req.getRequestDispatcher("/view/dashbord").forward(req, resp);
		}else {
			System.out.println("failed");
		}
		
	}
}
