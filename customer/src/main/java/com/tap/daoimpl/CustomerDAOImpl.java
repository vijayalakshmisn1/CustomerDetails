package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tap.Security.Decrypt;
import com.tap.customer.Customer;
import com.tap.dao.CustomerDAO;
import com.tap.dbconnection.MyConnection;

public class CustomerDAOImpl implements CustomerDAO {

	ArrayList<Customer> customerList = new ArrayList<Customer>();
	
	private Connection con;
	private Statement stmt;
	private String fetch="select * from customer";
	private ResultSet res;
	private String insert="insert into customer(cname,cemail,cphone,city) values(?,?,?,?)";
	private PreparedStatement pstmt;
	private int status;
	private String fetchID="select * from customer where cid=?";
	private String edit="update customer set cname=?,cphone=?,city=? where cid=?";

	private String delete="delete from customer where cid=?";

	public CustomerDAOImpl() {
		con = MyConnection.connection();
	}
	
	ArrayList<Customer> resultSet(ResultSet res){
		try {
			while(res.next()) {
				customerList.add(new Customer(res.getInt("cid"),res.getString("cname"),Decrypt.decrypt(res.getString("cemail")),
						res.getString("cphone"),res.getString("city")));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return customerList;
	}

	@Override
	public ArrayList<Customer> fetchAll() {
		try {
			stmt = con.createStatement();
			res = stmt.executeQuery(fetch);
			customerList = resultSet(res);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return customerList;
	}

	@Override
	public int insert(Customer c) {
		try {
			pstmt = con.prepareStatement(insert);
			pstmt.setString(1, c.getName());
			pstmt.setString(2, c.getEmail());
			pstmt.setString(3, c.getPhone());
			pstmt.setString(4, c.getCity());
			
			status = pstmt.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Customer fetchID(int id) {
		try {
			pstmt = con.prepareStatement(fetchID);
			pstmt.setInt(1, id);
			res=pstmt.executeQuery();
			customerList = resultSet(res);
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return customerList.get(0);
	}
	
	@Override
	public int edit(Customer c) {
		try {
			pstmt=con.prepareStatement(edit);
			pstmt.setString(1, c.getName());
			pstmt.setString(2, c.getPhone());
			pstmt.setString(3, c.getCity());
			pstmt.setInt(4, c.getId());
			
			status=pstmt.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int delete(int id) {
		try {
			pstmt=con.prepareStatement(delete);
			pstmt.setInt(1, id);
			
			status=pstmt.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	
	

}
