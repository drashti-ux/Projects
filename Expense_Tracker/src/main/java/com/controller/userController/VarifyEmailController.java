package com.controller.userController;

import java.io.IOException;
import java.util.Random;

import com.Dao.UserDao;
import com.model.User;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/view/varifyEmail")
public class VarifyEmailController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		
		UserDao dao = new UserDao();
		User user = dao.isEmail(email);
		
		HttpSession sess = req.getSession();
		sess.setAttribute("username", user);
		if(user!=null) {
			Random r = new Random();
			int otp = r.nextInt(1000,9999);
			ServletContext ctx = getServletContext();
			ctx.setAttribute("otp_or", otp+"");
			SendEmail.send(email, "OTP Verification", "Your One Time Password is :\n"+otp);
			req.getRequestDispatcher("/view/otp.jsp").forward(req, resp);
		}else {
			req.setAttribute("msg", "Email Not Found");
			req.getRequestDispatcher("/view/forgotPass.jsp").forward(req, resp);
		}
	}
}
