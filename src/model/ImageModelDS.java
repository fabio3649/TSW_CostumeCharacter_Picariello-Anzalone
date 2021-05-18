package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ImageModelDS {
	
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
                                    
	private static final String TABLE_NAME = "costumecharacter.image";

	
	public void doSave(Object bean, boolean main) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ImageBean image = (ImageBean) bean;
		String insertSQL = "INSERT INTO " + ImageModelDS.TABLE_NAME
				+ " (URL, PRODUCT) "
				+ " VALUES (?, ?)";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, image.getUrl());
			preparedStatement.setInt(2, image.getProduct());
			
			if ( main == true ) 
				preparedStatement.setInt(3,1);
				else
					preparedStatement.setInt(3,0);
				
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
	
	
	
	public synchronized ArrayList<ImageBean> doRetrieveAllByProduct(int id ) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<ImageBean> images = new ArrayList<ImageBean>();

		String selectSQL = "SELECT * FROM " + ImageModelDS.TABLE_NAME + " WHERE PRODUCT = ?"; 

		

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);
			
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				ImageBean bean = new ImageBean();
				bean.setUrl(rs.getString("URL"));
				bean.setProduct(rs.getInt("PRODUCT"));
				
				int main = rs.getInt("MAIN");
				if(main == 0)
					bean.setMain(false);
				else
					bean.setMain(true);
					
				images.add(bean);
				}
			
		     } 
				finally {
				try {
					if (preparedStatement != null)
						preparedStatement.close();
				} finally {
					if (connection != null)
						connection.close();
				}
			}
			return images;
		

	
	}
	
}