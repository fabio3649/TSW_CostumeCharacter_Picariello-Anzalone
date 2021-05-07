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

public class ProductModelDS implements ProductModel {

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

	@Override
	public synchronized void doSave(ProductBean product) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + ProductModelDS.TABLE_NAME
				+ " (IDPRODUCT, NAME, TYPE, DESCRIPTION, AGE, SIZE, NUMBER OF COPIES,"
				+ " IVA, PRICE, WEIGHT) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, product.getId());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setString(3, product.getType());
			preparedStatement.setString(4, product.getDescription());
			preparedStatement.setString(5, product.getAge());
			preparedStatement.setString(6, product.getSize());
			preparedStatement.setInt(7, product.getNumCopies());
			preparedStatement.setInt(8, product.getIva());
			preparedStatement.setDouble(9, product.getPrice());
			preparedStatement.setDouble(10, product.getWeight());
			preparedStatement.setString(11, product.getUrlImage());
			preparedStatement.executeUpdate();

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

	@Override
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
				bean.setWeight(rs.getDouble("WEIGHT"));
				bean.setUrlImage(rs.getString("URLIMAGE"));
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

	@Override
	public synchronized boolean doDelete(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + ProductModelDS.TABLE_NAME + " WHERE ID = ?";

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

	@Override
	public synchronized Collection<ProductBean> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<ProductBean> products = new LinkedList<ProductBean>();

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
				bean.setWeight(rs.getDouble("WEIGHT"));
				bean.setUrlImage(rs.getString("URLIMAGE"));
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

}