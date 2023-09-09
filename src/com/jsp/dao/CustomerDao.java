package com.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jsp.configuration.HelperClass;
import com.jsp.dto.Customer;


public class CustomerDao {
	HelperClass helperclass = new HelperClass();
	Connection connection = null;
	
	public Customer saveCustomer(Customer customer) {
		connection = helperclass.getConnection();
		String sql = "INSERT INTO customer VALUES(?,?,?,?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, customer.getId());
			preparedStatement.setString(2, customer.getName());
			preparedStatement.setString(3, customer.getEmail());
			preparedStatement.setLong(4, customer.getPh_no());
			
			preparedStatement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return customer;
	}
	
	
	public boolean deleteCustomerById(int ID) {
		connection = helperclass.getConnection();
		String sql = "DELETE FROM customer where id = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, ID);
			
			int i = preparedStatement.executeUpdate();
			if(i>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
	}
	
	
	public int updateCustomerById(Customer customer) {
		connection = helperclass.getConnection();
		String sql = "UPDATE customer set name = ?,email = ?, phone_number= ? where id = ? ";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getEmail());
			preparedStatement.setLong(2, customer.getPh_no());
			preparedStatement.setInt(4, customer.getId());
			
			if(preparedStatement.executeUpdate() > 0) {
				return customer.getId();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return 0;
	}
	
	
	public void getCustomerALL() {
		connection = helperclass.getConnection();
		String sql = "SELECT * FROM customer";
		ResultSet resultSet = null;
		try {
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " " +resultSet.getString(2) + " "+ resultSet.getString(3) + " " + resultSet.getLong(4));
				System.out.println("===================================");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public Customer getCustomerById(int id) {
		connection = helperclass.getConnection();
		String sql = "SELECT * FROM customer where id="+id;
		Customer customer = new Customer();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				customer.setId(resultSet.getInt(1));
				customer.setName(resultSet.getString(2));
				customer.setEmail(resultSet.getString(3));
				customer.setPh_no(resultSet.getLong(4));
			}
			if(customer.getName()==null) {
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return customer;
	}
	
}
