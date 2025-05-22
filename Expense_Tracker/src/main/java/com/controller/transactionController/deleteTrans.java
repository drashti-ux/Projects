package com.controller.transactionController;

import java.io.IOException;

import com.Dao.TransDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/view/deleteTr")
public class deleteTrans extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("did"));
		TransDao dao = new TransDao();
		int i = dao.DeleteTransaction(id);
		if(i>0) {
			req.getRequestDispatcher("/view/transactions").forward(req, resp);
		}
	}
}
