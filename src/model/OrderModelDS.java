package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class OrderModelDS  {
	
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
                                    
	private static final String TABLE_NAME = "costumecharacter.order";

	public int nextId() throws SQLException {
		
		ArrayList<OrderBean> orders = this.doRetrieveAll();
		if(orders.size()==0)
			return 1;
		int next = (orders.get(orders.size()-1).getIdOrder())+1;
		
		return next;

	}
	
	public void doSave(Object bean) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		OrderBean order = (OrderBean) bean;
		String insertSQL = "INSERT INTO " + OrderModelDS.TABLE_NAME
				+ " (IDORDER, PAYMENTMETHOD, DATE, STATUS, TOTALPRICE, SHIPPINGCOSTS, USER, ADDRESS) "
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, this.nextId());
			preparedStatement.setString(2, order.getPaymentMethod());
			preparedStatement.setDate(3, order.getDate());
			preparedStatement.setString(4, order.getStatus());
			preparedStatement.setDouble(5, order.getTotalPrice() + order.getShippingCosts() );
			preparedStatement.setDouble(6, order.getShippingCosts());
			preparedStatement.setString(7,order.getUser());
			preparedStatement.setInt(8, order.getAddress());
			System.out.println(preparedStatement.toString());
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

	
	public synchronized OrderBean doRetrieveByKey(int idOrder) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		OrderBean bean = new OrderBean();

		String selectSQL = "SELECT * FROM " + OrderModelDS.TABLE_NAME + " WHERE IDORDER = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, idOrder);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setIdOrder(rs.getInt("IDORDER"));
				bean.setPaymentMethod(rs.getString("PAYMENTMETHOD"));
				bean.setDate(rs.getDate("DATE"));
				bean.setStatus(rs.getString("STATUS"));
				bean.setTotalPrice(rs.getDouble("TOTALPRICE"));
				bean.setShippingCosts(rs.getDouble("SHIPPINGCOSTS"));
				bean.setUser(rs.getString("USER"));
				bean.setAddress(rs.getInt("ADDRESS"));
				
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

	
	public synchronized boolean doDelete(int idOrder) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + OrderModelDS.TABLE_NAME + " WHERE IDORDER = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, idOrder);

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

	
	public synchronized ArrayList<OrderBean> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<OrderBean> orders = new ArrayList<OrderBean>();

		String selectSQL = "SELECT * FROM " + OrderModelDS.TABLE_NAME;

		
		

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				OrderBean bean = new OrderBean();

				bean.setIdOrder(rs.getInt("IDORDER"));
				bean.setPaymentMethod(rs.getString("PAYMENTMETHOD"));
				bean.setDate(rs.getDate("DATE"));
				bean.setStatus(rs.getString("STATUS"));
				bean.setTotalPrice(rs.getDouble("TOTALPRICE"));
				bean.setShippingCosts(rs.getDouble("SHIPPINGCOSTS"));
				bean.setUser(rs.getString("USER"));
				bean.setAddress(rs.getInt("ADDRESS"));
				orders.add(bean);
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
		return orders;
	}
	
	public synchronized ArrayList doRetrieveAllByUser(String username) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<OrderBean> orders = new ArrayList<OrderBean>();

		String selectSQL = "SELECT * FROM " + OrderModelDS.TABLE_NAME + " WHERE USERNAME = ?";

		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, username);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				OrderBean bean = new OrderBean();

				bean.setIdOrder(rs.getInt("IDORDER"));
				bean.setPaymentMethod(rs.getString("PAYMENTMETHOD"));
				bean.setDate(rs.getDate("DATE"));
				bean.setStatus(rs.getString("STATUS"));
				bean.setTotalPrice(rs.getDouble("TOTALPRICE"));
				bean.setShippingCosts(rs.getDouble("SHIPPINGCOSTS"));
				bean.setUser(rs.getString("USER"));
				bean.setAddress(rs.getInt("ADDRESS"));	
				orders.add(bean);
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
		
		
		
		
		return orders;
	
	}


}
