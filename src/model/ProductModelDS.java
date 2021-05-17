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

import com.mysql.cj.xdevapi.Result;

import exceptions.*;


public class ProductModelDS  {

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
                                    
	private static final String TABLE_NAME = "product";

		public int nextId() throws SQLException {
			
			ArrayList<ProductBean> products =  this.doRetrieveAll("idProduct");
			int next = (products.get(products.size()-1).getId())+1;
			
			return next;
	
		}
	
	public synchronized void doSave(Object bean) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ProductBean product = (ProductBean) bean;
		String insertSQL = "INSERT INTO " + ProductModelDS.TABLE_NAME
				+ " (IDPRODUCT, NAME, TYPE, DESCRIPTION, AGE, SIZE, NUMBER OF COPIES,"
				+ " IVA, PRICE, WEIGHT, URLIMAGE, CATEGORY) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, this.nextId());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setString(3, product.getType());
			preparedStatement.setString(4, product.getDescription());
			preparedStatement.setString(5, product.getAge());
			preparedStatement.setString(6, product.getSize());
			preparedStatement.setInt(7, product.getNumCopies());
			preparedStatement.setInt(8, product.getIva());
			preparedStatement.setDouble(9, product.getPrice());
			preparedStatement.setDouble(10, product.getWeight());
			preparedStatement.setString(11,product.getCategory());
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

	
	public synchronized ProductBean doRetrieveByKey(int idProduct) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ProductBean bean = new ProductBean();

		String selectSQL = "SELECT * FROM " + ProductModelDS.TABLE_NAME + " WHERE IDPRODUCT = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, idProduct);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
				
				bean.setId(rs.getInt("IDPRODUCT"));
				bean.setName(rs.getString("NAME"));
				bean.setType(rs.getString("TYPE"));
				bean.setDescription(rs.getString("DESCRIPTION"));
				bean.setAge(rs.getString("AGE"));
				bean.setSize(rs.getString("SIZE"));
				bean.setNumCopies(rs.getInt("NUMBERCOPIES"));
				bean.setIva(rs.getInt("IVA"));
				bean.setPrice(rs.getDouble("PRICE"));
				bean.setTotalPrice(); // aggiunta prezzo ivato;
				bean.setWeight(rs.getDouble("WEIGHT"));
				bean.setCategory(rs.getString("CATEGORY"));
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

	
	public synchronized boolean doDelete(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + ProductModelDS.TABLE_NAME + " WHERE IDPRODUCT = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, id);

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

	
	public synchronized ArrayList<ProductBean>  doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<ProductBean> products = new ArrayList<ProductBean>();

		String selectSQL = "SELECT * FROM " + ProductModelDS.TABLE_NAME;

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				ProductBean bean = new ProductBean();

				bean.setId(rs.getInt("IDPRODUCT"));
				bean.setName(rs.getString("NAME"));
				bean.setType(rs.getString("TYPE"));
				bean.setDescription(rs.getString("DESCRIPTION"));
				bean.setAge(rs.getString("AGE"));
				bean.setSize(rs.getString("SIZE"));
				bean.setNumCopies(rs.getInt("NUMBERCOPIES"));
				bean.setIva(rs.getInt("IVA"));
				bean.setPrice(rs.getDouble("PRICE"));
				bean.setTotalPrice(); // aggiunta prezzo ivato;
				bean.setWeight(rs.getDouble("WEIGHT"));
				bean.setCategory(rs.getString("CATEGORY"));
				products.add(bean);
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
		return products;
	}
	
	public synchronized boolean updateCopies(int idProduct, int copies) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		if(copies < 1) {
			 return this.doDelete(idProduct);
		}else {
		ProductBean bean = new ProductBean();

		String selectSQL = "UPDATE " + ProductModelDS.TABLE_NAME + " SET numberCopies = ? " + " WHERE IDPRODUCT = ? ";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, copies);
			preparedStatement.setInt(2, idProduct);

			
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
	
	public synchronized boolean updatePrice(int idProduct, Double price) throws SQLException, InvalidParameterException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		
		if(price < 0) {
			throw new InvalidParameterException ("PRICE not valid : price less then zero ") ;
		}
		else {
		ProductBean bean = new ProductBean();

		String selectSQL = "UPDATE " + ProductModelDS.TABLE_NAME + " SET PRICE = ? " + " WHERE IDPRODUCT = ? ";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setDouble(1, price);
			preparedStatement.setInt(2, idProduct);

			
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
	
	public synchronized boolean updateIva(int idProduct, int iva) throws SQLException, InvalidParameterException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		
		if(iva < 5) {
			throw new InvalidParameterException ("IVA not valid : iva less then 5 % ") ;
		}
		else {
		ProductBean bean = new ProductBean();

		String selectSQL = "UPDATE " + ProductModelDS.TABLE_NAME + " SET PRICE = ? " + " WHERE IDPRODUCT = ? ";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setDouble(1, iva);
			preparedStatement.setInt(2, idProduct);

			
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
	
	public synchronized boolean updateName(int idProduct, String name) throws SQLException, InvalidParameterException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		
		if(name == null) {
			throw new InvalidParameterException ("NAME not valid : please insert a name ") ;
		}
		else {
		ProductBean bean = new ProductBean();

		String selectSQL = "UPDATE " + ProductModelDS.TABLE_NAME + " SET NAME = ? " + " WHERE IDPRODUCT = ? ";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, idProduct);

			
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
	
	public synchronized boolean updateDescription(int idProduct, String description) throws SQLException, InvalidParameterException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		
		if(description == null) {
			throw new InvalidParameterException ("DESCRIPTION not valid : please insert a description ") ;
		}
		else {
		ProductBean bean = new ProductBean();

		String selectSQL = "UPDATE " + ProductModelDS.TABLE_NAME + " SET DESCRIPTION = ? " + " WHERE IDPRODUCT = ? ";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, description);
			preparedStatement.setInt(2, idProduct);

			
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
	
	public synchronized boolean updateType(int idProduct, String type) throws SQLException, InvalidParameterException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		
		if(type == null) {
			throw new InvalidParameterException ("TYPE not valid : please insert a type ") ;
		}
		else {
		ProductBean bean = new ProductBean();

		String selectSQL = "UPDATE " + ProductModelDS.TABLE_NAME + " SET TYPE = ? " + " WHERE IDPRODUCT = ? ";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, type);
			preparedStatement.setInt(2, idProduct);

			
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
	public synchronized boolean updateAge(int idProduct, String age) throws SQLException, InvalidParameterException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		
		if(age == null) {
			throw new InvalidParameterException ("AGE not valid : please insert an age ") ;
		}
		else {
		ProductBean bean = new ProductBean();

		String selectSQL = "UPDATE " + ProductModelDS.TABLE_NAME + " SET NAME = ? " + " WHERE IDPRODUCT = ? ";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, age);
			preparedStatement.setInt(2, idProduct);

			
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
	public synchronized boolean updateSize(int idProduct, String size) throws SQLException, InvalidParameterException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		
		
		ProductBean bean = new ProductBean();

		String selectSQL = "UPDATE " + ProductModelDS.TABLE_NAME + " SET SIZE = ? " + " WHERE IDPRODUCT = ? ";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, size);
			preparedStatement.setInt(2, idProduct);

			
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
	
	public synchronized boolean updateWeight(int idProduct, Double weight) throws SQLException, InvalidParameterException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		
		if(weight < 0) {
			throw new InvalidParameterException ("WEIGHT not valid : please insert a weight > 0 ") ;
		}
		else {
		ProductBean bean = new ProductBean();

		String selectSQL = "UPDATE " + ProductModelDS.TABLE_NAME + " SET NAME = ? " + " WHERE IDPRODUCT = ? ";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setDouble(1, weight);
			preparedStatement.setInt(2, idProduct);

			
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
	
	public synchronized boolean updateCategory(int idProduct, String category) throws SQLException, InvalidParameterException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		
		
		ProductBean bean = new ProductBean();

		String selectSQL = "UPDATE " + ProductModelDS.TABLE_NAME + " SET CATEGORY = ? " + " WHERE IDPRODUCT = ? ";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, category);
			preparedStatement.setInt(2, idProduct);

			
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



