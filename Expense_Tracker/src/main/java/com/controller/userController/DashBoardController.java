package com.controller.userController;

import java.io.IOException;
import java.util.List;

import com.Dao.TransDao;
import com.model.Transn;
import com.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/view/dashbord")
public class DashBoardController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession seson = req.getSession();
		User u = (User) seson.getAttribute("username");
		
		TransDao tdao = new TransDao();
		double income = tdao.getIncome(u);
		double expense = tdao.getExpense(u);
		
		List<Transn> trans = tdao.getTrans(u); 
		
//		for(Transn t : trans) {
//			System.out.println(t.getAmount());
//		}
		
		req.setAttribute("income", income);
		req.setAttribute("expense", expense);
		req.setAttribute("trans", trans);
		req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
	}
}
