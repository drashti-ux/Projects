package com.controller.userController;

import java.io.IOException;

import com.Dao.UserDao;
import com.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/view/registerUser")

public class regController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("uname");
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		
		User u = new User();
		u.setUname(uname);
		u.setEmail(email);
		u.setPassword(pass);
		
		UserDao dao = new UserDao();
		int i = dao.addUser(u);
		if(i>0) {
			req.setAttribute("msg", "registered");
			req.getRequestDispatcher("registerUser.jsp").forward(req, resp);
		}
	}
}
