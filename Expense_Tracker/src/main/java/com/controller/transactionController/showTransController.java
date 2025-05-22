package com.controller.transactionController;

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

@WebServlet("/view/transactions")
public class showTransController extends HttpServlet{
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			HttpSession session = req.getSession();
			User u = (User) session.getAttribute("username");
			TransDao dao = new TransDao();
			List<Transn> allTr = dao.allTransactions(u);
			
			req.setAttribute("trs", allTr);
			req.getRequestDispatcher("viewTrans.jsp").forward(req, resp);
		}
}
