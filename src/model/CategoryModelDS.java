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

public class CategoryModelDS  {

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
                                    
	private static final String TABLE_NAME = "category";
	
	public synchronized void doSave(Object bean) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		CategoryBean category = (CategoryBean) bean;
		String insertSQL = "INSERT INTO " + CategoryModelDS.TABLE_NAME
				+ " (IDCLASS, NAME, DESCRIPTION) VALUES (?, ?, ?)";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, category.getIdClass());
			preparedStatement.setString(2, category.getName());
			preparedStatement.setString(3, category.getDescription());
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
	
	public synchronized CategoryBean doRetrieveByKey(String idClass) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

	
		
		CategoryBean bean = new CategoryBean();

		String selectSQL = "SELECT * FROM " + CategoryModelDS.TABLE_NAME + " WHERE IDCLASS = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, idClass);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setIdClass(rs.getString("IDCLASS"));
				bean.setName(rs.getString("NAME"));
				bean.setDescription(rs.getString("DESCRIPTION"));
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
	
	
	public synchronized boolean doDelete(String idClass) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
         
		int result = 0;

		String deleteSQL = "DELETE FROM " + CategoryModelDS.TABLE_NAME + " WHERE IDCLASS = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, idClass);

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
	
	public synchronized Collection<?> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<CategoryBean> categories = new LinkedList<CategoryBean>();

		String selectSQL = "SELECT * FROM " + CategoryModelDS.TABLE_NAME;

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				CategoryBean bean = new CategoryBean();

				bean.setIdClass(rs.getString("IDCLASS"));
				bean.setName(rs.getString("NAME"));
				bean.setDescription(rs.getString("DESCRIPTION"));
				
				categories.add(bean);
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
		return categories;
	}

}
	
			
	


