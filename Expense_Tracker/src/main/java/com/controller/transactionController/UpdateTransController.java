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

@WebServlet("/view/updateTr")
public class UpdateTransController extends HttpServlet{
	
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			int id = Integer.parseInt(req.getParameter("tr_id"));
			String dt = req.getParameter("date"); 
			LocalDate date = LocalDate.parse(dt);
			String type = req.getParameter("type");
			String category = req.getParameter("category");
			double amount = Double.parseDouble(req.getParameter("amount"));
			String note = req.getParameter("note");
			
			HttpSession sn = req.getSession();
			User u = (User) sn.getAttribute("username");
			
			Transn t = new Transn();
			t.setTr_id(id);
			t.setDate(date);
			t.setType(type);
			t.setCategory(category);
			t.setAmount(amount);
			t.setNote(note);
			t.setUser(u);
			
			TransDao dao = new TransDao();
			int i = dao.addTransaction(t);
			
			if(i>0) {
				req.getRequestDispatcher("/view/transactions").forward(req, resp);
			}
			
		}
}
