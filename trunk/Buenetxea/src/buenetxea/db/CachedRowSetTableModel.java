package buenetxea.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import com.sun.rowset.CachedRowSetImpl;

/**
 * This is a customized version of AbstractTableModel based on
 * ResultSetTableModel (C) Copyright 1992-2005 by Deitel & Associates, Inc. and
 * Pearson Education, Inc. All Rights Reserved.
 * 
 * 
 * ResultSet instances 'lose' their data when the user gets disconnected from
 * the database. This can lead to trouble when having multiple instances for the
 * same connection, in a singleton database connection environment.
 * 
 * CachedRowSet instances allow the developer to store in the memory all the
 * data contained in a given ResultSet. Thus, the connection becomes irrelevant.
 * However, since CachedRowSets store all the data in the memory instead of
 * using a pointer to read it from the database it is best not to use them with
 * queries that return massive amounts of data, because this might lead to a
 * memory overflow.
 * 
 * ResultSet rows and columns are counted from 1 and JTable rows and columns are
 * counted from 0. When processing ResultSet rows or columns for use in a
 * JTable, it is necessary to add 1 to the row or column number to manipulate
 * the appropriate ResultSet column (i.e., JTable column 0 is ResultSet column 1
 * and JTable row 0 is ResultSet row 1).
 */
public class CachedRowSetTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private Connection connection;

	private Statement statement;

	private CachedRowSetImpl cachedRowSet;

	private ResultSetMetaData metaData;

	private int numberOfRows;

	private String lastQuery;

	/**
	 * 
	 * constructor initializes resultSet and obtains its meta data object
	 * determines number of rows
	 * 
	 * @param query
	 */
	public CachedRowSetTableModel(String query) {
		
		try {
			cachedRowSet = new CachedRowSetImpl();
			connection = Connector.getConnection();
			statement = Connector.getStatement();
			//Set the given query and execute it
			setQuery(query);
		} catch (IllegalStateException ex) {
			ex.printStackTrace();
			JOptionPane jop = new JOptionPane(
					"Error al acceder a la base de datos.",
					JOptionPane.ERROR_MESSAGE);
			jop.createDialog(null, "Error de base de datos").setVisible(true);
		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane jop = new JOptionPane(
					"Error al acceder a la base de datos.",
					JOptionPane.ERROR_MESSAGE);
			jop.createDialog(null, "Error de base de datos").setVisible(true);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	} 

	// Get the Java class that represents the column type
	public Class<?> getColumnClass(int column) {
		// determine Java class of column
		try {
			String className = metaData.getColumnClassName(column + 1);
			// return Class object that represents className
			return Class.forName(className);
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		return Object.class; // if problems occur above, assume type Object
	}

	// get number of columns in ResultSet
	public int getColumnCount() {
		// determine number of columns
		try {
			return metaData.getColumnCount();
		} // end try
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
			JOptionPane jop = new JOptionPane(
					"Error al determinar el número de columnas.\n",
					JOptionPane.ERROR_MESSAGE);
			jop.createDialog(null, "Error de lectura de datos")
					.setVisible(true);
		} // end catch
		return 0; // if problems occur above, return 0 for number of columns
	}

	// get name of a particular column in ResultSet
	@Override
	public String getColumnName(int column) {
		// determine column name
		try {
			return metaData.getColumnLabel(column + 1);
			// return metaData.getColumnName(column + 1);
		}
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
			JOptionPane jop = new JOptionPane(
					"Error al obtener el nombre de columna.\n",
					JOptionPane.ERROR_MESSAGE);
			jop.createDialog(null, "Error de lectura de datos")
					.setVisible(true);
		}
		return ""; // if problems, return empty string for column name
	} 

	// return number of rows in ResultSet
	public int getRowCount() {
		return numberOfRows;
	} 

	// obtain value in particular row and column
	public Object getValueAt(int row, int column) {
		// obtain a value at specified ResultSet row and column
		try {
			cachedRowSet.absolute(row + 1);
			return cachedRowSet.getObject(column + 1);
		}
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
			JOptionPane jop = new JOptionPane("Error al obtener datos.\n",
					JOptionPane.ERROR_MESSAGE);
			jop.createDialog(null, "Error de lectura de datos")
					.setVisible(true);
		}
		return ""; // if problems, return empty string object
	}

	// set new database query string
	public void setQuery(String query) throws SQLException,
			IllegalStateException {
		ResultSet resultSet;
		// ensure database connection is available
		if (!Connector.isConnectedToDatabase())
			throw new IllegalStateException("Not Connected to Database");
		// Execute the given query and store the values in a ResultSet
		resultSet = statement.executeQuery(query);
		// Populate the CachedRowSet with the values of the ResultSet
		cachedRowSet.populate(resultSet);
		// Obtain the metadata of our CachedRowSet
		metaData = cachedRowSet.getMetaData();
		// determine number of rows in CachedRowSet
		cachedRowSet.last();
		// resultSet.last(); // move to last row
		numberOfRows = cachedRowSet.getRow(); // get row number
		// notify JTable that model has changed
		fireTableStructureChanged();
		this.lastQuery = query;
	}

	// close Statement and Connection
	// public void disconnectFromDatabase() {
	// }


	public void refresh() throws SQLException {
		this.setQuery(this.lastQuery);
	}
}
