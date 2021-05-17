package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserModelDS  {
	
private static DataSource ds;
    
	static {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/costumecharacterds");
          
		} catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}
                                    
	private static final String TABLE_NAME = "user";

	
	public void doSave(Object bean) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		UserBean user = (UserBean) bean;
		String insertSQL = "INSERT INTO " + UserModelDS.TABLE_NAME
				+ " (USERNAME, PASSWORD, NAME, SURNAME, TELEPHONENUMBER, EMAIL, BILLINGADDRESS, "
				+ "  BILLINGCAP, BILLINGCITY, BILLINGPROVINCE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getName());
			preparedStatement.setString(4, user.getSurname());
			preparedStatement.setString(5, user.getTelephoneNumber());
			preparedStatement.setString(6, user.getEmail());
			preparedStatement.setString(7, user.getBillingAddress());
			preparedStatement.setInt(8, user.getBillingCAP());
			preparedStatement.setString(9, user.getBillingCity());
			preparedStatement.setString(10, user.getBillingProvince());
			preparedStatement.executeUpdate();
			connection.setAutoCommit(false);
			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
	}
		
	

	
	public boolean doDelete(String username) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
	
         
		int result = 0;

		String deleteSQL = "DELETE FROM " + UserModelDS.TABLE_NAME + " WHERE USERNAME = ?";
        
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, username);

			result = preparedStatement.executeUpdate();

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return (result != 0);
	}
	

	
	public Object doRetrieveByKey(String username) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		
		
		UserBean bean = new UserBean();
        
		String selectSQL = "SELECT * FROM " + UserModelDS.TABLE_NAME + " WHERE USERNAME = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, username);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setUsername(rs.getString("USERNAME"));
				bean.setPassword(rs.getString("PASSWORD"));
				bean.setName(rs.getString("NAME"));
				bean.setSurname(rs.getString("SURNAME"));
			    bean.setTelephoneNumber(rs.getString("TELEPHONENUMBER"));
	            bean.setEmail(rs.getString("EMAIL"));
	            bean.setBillingAddress(rs.getString("BILLINGADDRESS"));
	            bean.setBillingCAP(rs.getInt("BILLINGCAP"));
			    bean.setBillingCity(rs.getString("BILLINGCITY"));
			    bean.setBillingProvince(rs.getString("BILLINGPROVINCE"));
			    
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return bean;
	}
	

	
	public Collection<?> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<UserBean> users = new LinkedList<UserBean>();

		String selectSQL = "SELECT * FROM " + UserModelDS.TABLE_NAME;

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
				UserBean bean = new UserBean();

				bean.setUsername(rs.getString("USERNAME"));
				bean.setPassword(rs.getString("PASSWORD"));
				bean.setName(rs.getString("NAME"));
				bean.setSurname(rs.getString("SURNAME"));
			    bean.setTelephoneNumber(rs.getString("TELEPHONENUMBER"));
	            bean.setEmail(rs.getString("EMAIL"));
	            bean.setBillingAddress(rs.getString("BILLINGADDRESS"));
	            bean.setBillingCAP(rs.getInt("BILLINGCAP"));
			    bean.setBillingCity(rs.getString("BILLINGCITY"));
			    bean.setBillingProvince(rs.getString("BILLINGPROVINCE"));
				
				users.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return users;
	}
	}
	
	
	
	


