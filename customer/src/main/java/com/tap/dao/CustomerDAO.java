package com.tap.dao;

import java.util.ArrayList;
import com.tap.customer.Customer;

public interface CustomerDAO {
	ArrayList<Customer> fetchAll();
	int insert(Customer c);
	Customer fetchID(int id);
	int edit(Customer c);
	int delete(int id);
}
