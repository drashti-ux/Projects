package com.controller.userController;

import java.io.IOException;

import com.Dao.TransDao;
import com.Dao.UserDao;
import com.model.Transn;
import com.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/view/loginUser")
public class LoginController extends HttpServlet{
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String email = req.getParameter("email");
			String pass = req.getParameter("pass");
			
			UserDao dao = new UserDao();
			User u = dao.loginUser(email, pass);
			
		
			
			if(u!= null) {
				System.out.println(u);
				HttpSession seson = req.getSession();
				seson.setAttribute("username", u);
				
				req.getRequestDispatcher("/view/dashbord").forward(req, resp);
			}else {
				req.setAttribute("msg", "Invalid Credential!!");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
		}
}	
