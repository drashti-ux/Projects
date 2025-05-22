package com.controller.userController;

import java.io.IOException;

import com.model.User;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/view/varifyOtp")
public class VarifyOtp extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String otp = req.getParameter("otp");
		ServletContext ctx = getServletContext();
		String or_otp = (String) ctx.getAttribute("otp_or");
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("username");
		if(or_otp.equals(otp)) {
					session.setAttribute("username", user);	
					req.getRequestDispatcher("/view/dashbord").forward(req, resp);
		}else {
			req.setAttribute("msg", "Invalid Otp");
			req.getRequestDispatcher("/Expense_Tracker/view/otp.jsp").forward(req, resp);
		}
	}
}
