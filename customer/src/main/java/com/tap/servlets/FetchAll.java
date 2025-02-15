package com.tap.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.customer.Customer;
import com.tap.daoimpl.CustomerDAOImpl;


public class FetchAll extends HttpServlet {
	
	private ArrayList<Customer> customerList;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CustomerDAOImpl cdimpl = new CustomerDAOImpl();
		
		customerList = cdimpl.fetchAll();
		
		req.getSession().setAttribute("customerList",customerList);
		
		resp.sendRedirect("home.jsp");
	}
}
