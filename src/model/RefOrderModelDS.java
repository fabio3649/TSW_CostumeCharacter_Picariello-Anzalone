package model;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class RefOrderModelDS {

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
	
	private static final String TABLE_NAME = "orderreference";
	
		public int nextId() throws SQLException {
				
				ArrayList<RefOrderBean> reforders = this.doRetrieveAll();
				int next = (reforders.get(reforders.size()-1).getOrder())+1;
				
				return next;
		
			}
	
	public void doSave(Object bean) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		RefOrderBean reforder = (RefOrderBean) bean;
		String insertSQL = "INSERT INTO " + RefOrderModelDS.TABLE_NAME
				+ " (IDORDER, PRODUCT, QUANTITY, SELLINGPRICE, IVA) "
				+ " VALUES (?, ?, ?, ?, ?)";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, this.nextId());
			preparedStatement.setInt(2, reforder.getProduct());
			preparedStatement.setInt(3, reforder.getQuantity());
			preparedStatement.setDouble(4, reforder.getSellingPrice());
			preparedStatement.setInt(5, reforder.getIva());
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
	
	public synchronized ArrayList<RefOrderBean> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<RefOrderBean> reforders = new ArrayList<RefOrderBean>();

		String selectSQL = "SELECT * FROM " + RefOrderModelDS.TABLE_NAME;

		
		

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				RefOrderBean bean = new RefOrderBean();

				bean.setOrder(rs.getInt("IDORDER"));
				bean.setProduct(rs.getInt("PRODUCT"));
				bean.setQuantity(rs.getInt("QUANTITY"));
				bean.setSellingPrice(rs.getDouble("SELLINGPRICE"));
				bean.setIva(rs.getInt("IVA"));
				reforders.add(bean);
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
		return reforders;
	}

	public synchronized ArrayList doRetrieveAllByKey(int idOrder) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<RefOrderBean> refOrders = new ArrayList<RefOrderBean>();

		String selectSQL = "SELECT * FROM " + RefOrderModelDS.TABLE_NAME + " WHERE ORDER = ?";

		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, idOrder);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				RefOrderBean bean = new RefOrderBean();

				bean.setOrder(rs.getInt("ORDER"));
				bean.setProduct(rs.getInt("PRODUCT"));
				bean.setQuantity(rs.getInt("QUANTITY"));
				bean.setSellingPrice(rs.getDouble("SELLINGPRICE"));
				bean.setIva(rs.getInt("IVA"));
				refOrders.add(bean);
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
	
		
		return refOrders;
	
	}
	
	public synchronized boolean doDeleteAllByKey(int idOrder) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + RefOrderModelDS.TABLE_NAME + " WHERE IDORDER = ?";

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
	
		
	
}



