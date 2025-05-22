package com.controller.transactionController;

import java.io.IOException;
import java.util.List;

import com.Dao.TransDao;
import com.model.Transn;
import com.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/search")
public class SearchTransacion extends HttpServlet {
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // Get the search keyword from the request
	        String keyword = request.getParameter("srch");
	        HttpSession session = request.getSession();
	        User u = (User) session.getAttribute("username");

	        // Call the DAO to get filtered transactions based on the search keyword
	        TransDao dao = new TransDao();
	        List<Transn> filteredTransactions = dao.searchTransactions(keyword,u);

	        // Set the filtered transactions as a request attribute
	        request.setAttribute("trs", filteredTransactions);

	        // Forward the request to the JSP page
	        RequestDispatcher dispatcher = request.getRequestDispatcher("viewTrans.jsp");
	        dispatcher.forward(request, response);
	    }
	}
