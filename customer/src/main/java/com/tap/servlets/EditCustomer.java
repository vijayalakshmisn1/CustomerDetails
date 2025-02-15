package com.tap.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.customer.Customer;
import com.tap.daoimpl.CustomerDAOImpl;

public class EditCustomer extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		Customer c = new Customer(id,req.getParameter("name"),req.getParameter("email"),
				req.getParameter("phone"),req.getParameter("city"));
		
		CustomerDAOImpl cdimpl = new CustomerDAOImpl();
		
		int x=cdimpl.edit(c);
		if(x!=0) {
			resp.sendRedirect("FetchAll");
		}
		else {
			resp.sendRedirect("failure");
		}
	}
}
