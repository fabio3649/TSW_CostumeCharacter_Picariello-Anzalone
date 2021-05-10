package model;

import java.sql.SQLException;
import java.util.Collection;

public interface DaoModel {
	public void doSave(Object product) throws SQLException;

	public boolean doDelete(int code) throws SQLException;

	public Object doRetrieveByKey(int code) throws SQLException;
	
	public Collection<?> doRetrieveAll(String order) throws SQLException;
}
