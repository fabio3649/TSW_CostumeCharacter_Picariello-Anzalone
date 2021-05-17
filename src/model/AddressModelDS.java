package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class AddressModelDS {
	
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
                                    
	private static final String TABLE_NAME = "costumecharacter.address";

	
	public int nextId() throws SQLException {
		
		ArrayList<AddressBean> addresses =  this.doRetrieveAll();
		int next = (addresses.get(addresses.size()-1).getIdAddress())+1;
		
		return next;

	}
	
	public void doSave(Object bean) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		AddressBean address = (AddressBean) bean;
		String insertSQL = "INSERT INTO " + AddressModelDS.TABLE_NAME
				+ " (IDADDRESS, CITY, ADDRESS, CAP, PROVINCE, USER) "
				+ " VALUES (?, ?, ?, ?, ?, ?)";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, this.nextId());
			preparedStatement.setString(2, address.getCity());
			preparedStatement.setString(3, address.getAddress());
			preparedStatement.setInt(4, address.getCap());
			preparedStatement.setString(5, address.getProvince());
			preparedStatement.setString(6, address.getUser());
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

	
	public synchronized AddressBean doRetrieveByKey(int idAddress) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		AddressBean bean = new AddressBean();


		String selectSQL = "SELECT * FROM " + AddressModelDS.TABLE_NAME + " WHERE IDADDRESS = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, idAddress);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setIdAddress(rs.getInt("IDADDRESS"));
				bean.setCity(rs.getString("CITY"));
				bean.setAddress(rs.getString("ADDRESS"));
				bean.setCap(rs.getInt("CAP"));
				bean.setProvince(rs.getString("PROVINCE"));
				bean.setUser(rs.getString("USER"));
				int visible = rs.getInt("VISIBLE");
				if(visible==0)
					bean.setVisible(false);
				else 
					bean.setVisible(true);
				
			
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

	
	public synchronized boolean doDelete(int idAddress) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + AddressModelDS.TABLE_NAME + " WHERE IDADDRESS = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, idAddress);

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

	public synchronized ArrayList<AddressBean> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<AddressBean> addresses = new ArrayList<AddressBean>();

		String selectSQL = "SELECT * FROM " + AddressModelDS.TABLE_NAME;

		

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				AddressBean bean = new AddressBean();

				bean.setIdAddress(rs.getInt("IDADDRESS"));
				bean.setCity(rs.getString("CITY"));
				bean.setAddress(rs.getString("ADDRESS"));
				bean.setCap(rs.getInt("CAP"));
				bean.setProvince(rs.getString("PROVINCE"));
				bean.setUser(rs.getString("USER"));
				int visible = rs.getInt("VISIBLE");
				if(visible==0)
					bean.setVisible(false);
				else 
					bean.setVisible(true);
				
			
			
				addresses.add(bean);
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
		return addresses;
	}
	
	public synchronized ArrayList<AddressBean> doRetrieveAllByUser(String username) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<AddressBean> addresses = new ArrayList<AddressBean>();

		String selectSQL = "SELECT * FROM " + AddressModelDS.TABLE_NAME + " WHERE USER = ?";

		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, username);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				AddressBean bean = new AddressBean();

				bean.setIdAddress(rs.getInt("IDADDRESS"));
				bean.setCity(rs.getString("CITY"));
				bean.setAddress(rs.getString("ADDRESS"));
				bean.setCap(rs.getInt("CAP"));
				bean.setProvince(rs.getString("PROVINCE"));
				bean.setUser(rs.getString("USER"));
				int visible = rs.getInt("VISIBLE");
				if(visible==0)
					bean.setVisible(false);
				else 
					bean.setVisible(true);
				
			
			
				addresses.add(bean);
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
		
		
		
		return addresses;
	
	}
	


		


	
	
	
}

