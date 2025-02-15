package com.tap.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.customer.Customer;
import com.tap.daoimpl.CustomerDAOImpl;

public class FetchOne extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("sid"));
		CustomerDAOImpl cdimpl = new CustomerDAOImpl();
		
		Customer customer = cdimpl.fetchID(id);

		req.getSession().setAttribute("customer",customer);
		
		resp.sendRedirect("editCustomer.jsp");
	}	
}
