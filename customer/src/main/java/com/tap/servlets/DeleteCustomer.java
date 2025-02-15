package com.tap.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.customer.Customer;
import com.tap.daoimpl.CustomerDAOImpl;

public class DeleteCustomer extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("sid"));
		CustomerDAOImpl cdimpl = new CustomerDAOImpl();
		
		int x = cdimpl.delete(id);

		if(x!=0) {
			resp.sendRedirect("FetchAll");
		}
		else {
			resp.sendRedirect("failure.jsp");
		}
	}	
}
