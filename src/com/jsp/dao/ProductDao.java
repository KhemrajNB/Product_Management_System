package com.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jsp.configuration.HelperClass;
import com.jsp.dto.Product;

public class ProductDao {
	HelperClass helperclass = new HelperClass();
	Connection connection = null;
	
	public Product saveProduct(Product product) {
		connection = helperclass.getConnection();
		String sql = "INSERT INTO product VALUES(?,?,?,?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, product.getId());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setDouble(3, product.getPrice());
			preparedStatement.setInt(4, product.getStock());
			
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
		
		return product;
	}
	
	
	public boolean deleteProductById(int ID) {
		connection = helperclass.getConnection();
		String sql = "DELETE FROM product where id = ?";
		
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
	
	
	public int updateProductById(Product product) {
		connection = helperclass.getConnection();
		String sql = "UPDATE product set name = ?,price = ?, stock = ? where id = ? ";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, product.getName());
			preparedStatement.setDouble(2, product.getPrice());
			preparedStatement.setInt(3, product.getStock());
			preparedStatement.setInt(4, product.getId());
			
			if(preparedStatement.executeUpdate() > 0) {
				return product.getId();
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
	
	
	public void getProductALL() {
		connection = helperclass.getConnection();
		String sql = "SELECT * FROM product";
		ResultSet resultSet = null;
		try {
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " " +resultSet.getString(2) + " "+ resultSet.getInt(3) + " " + resultSet.getInt(4));
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
	
	
	public Product getProductById(int id) {
		connection = helperclass.getConnection();
		String sql = "SELECT * FROM product where id="+id;
		Product product = new Product();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				product.setId(resultSet.getInt(1));
				product.setName(resultSet.getString(2));
				product.setPrice(resultSet.getInt(3));
				product.setStock(resultSet.getInt(4));
			}
			if(product.getName()==null) {
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
		
		return product;
	}
}
