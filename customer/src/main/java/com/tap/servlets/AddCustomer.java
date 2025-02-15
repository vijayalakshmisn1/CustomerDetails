package com.tap.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.Security.Encrypt;
import com.tap.customer.Customer;
import com.tap.daoimpl.CustomerDAOImpl;


public class AddCustomer extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Customer c = new Customer(req.getParameter("name"),Encrypt.encrypt(req.getParameter("email")),req.getParameter("phone"),req.getParameter("city"));
		
		CustomerDAOImpl cdimpl = new CustomerDAOImpl();
		int status=cdimpl.insert(c);
		if(status!=0) {
			resp.sendRedirect("FetchAll");
		}
		else {
			resp.sendRedirect("failure.jsp");
		}
	}
}
