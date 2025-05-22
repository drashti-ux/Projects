package com.controller.userController;

import java.io.IOException;
import java.io.PrintWriter;

import com.Dao.UserDao;
import com.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/isEmailExist")
public class IsEmailExist extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		
		UserDao dao = new UserDao();
		User user =  dao.isEmail(email);
		PrintWriter out = resp.getWriter();
		if(user==null) {
			out.append("false");
		}else {
			out.print("true");
		}
	}
}
