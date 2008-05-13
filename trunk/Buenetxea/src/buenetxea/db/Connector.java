/*
 * Connector.java
 *
 * Created on 8 de agosto de 2007, 13:19
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package buenetxea.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author Beñat
 */
public class Connector {

	/**
	 * The jdbc driver used to connect to the database
	 */
	public static final String JDBC_DRIVER = ConnectionPref
			.getString("ConnectionPref.JDBC_DRIVER"); //$NON-NLS-1$
	/**
	 * The URL of the server where the database is hosted
	 */
	public static final String DATABASE_URL = ConnectionPref
			.getString("ConnectionPref.DATABASE_URL"); //$NON-NLS-1$

	private static String username;
	private static String password;

	private static java.sql.Connection connection;
	private static java.sql.Statement statement;
	private static boolean connectedToDatabase = false;

	/**
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	private static void connect() throws SQLException, ClassNotFoundException {
		Class.forName(JDBC_DRIVER);
		Connector.connection = DriverManager.getConnection(DATABASE_URL,
				Connector.username, Connector.password);
		Connector.statement = Connector.connection.createStatement();
		Connector.connectedToDatabase = true;
	}

	/**
	 * Datu basera konektatzen da emandako erabiltzaile eta pasahitzarekin.
	 * 
	 * @param user
	 *            konexioa ezartzeko erabiltzaile izena
	 * @param pass
	 *            konexioa ezartzeko erabiltzailearen pasahitza
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void connect(String user, String pass) throws SQLException,
			ClassNotFoundException {
		Connector.username = user;
		Connector.password = pass;
		Connector.connect();
	}

	/**
	 * Datu basera konexioa itzultzen du.
	 * 
	 * @return Datu basera uneko konexioa
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Connection getConnection() throws SQLException,
			ClassNotFoundException {
		if (null == connection || !connectedToDatabase)
			connect();
		return connection;
	}

	/**
	 * Uneko konexioaren statement-a itzultzen du.
	 * 
	 * @return uneko konexioaren statement-a
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Statement getStatement() throws SQLException,
			ClassNotFoundException {
		if (null == statement || !connectedToDatabase)
			connect();
		return statement;
	}

	/**
	 * Datu basera konektatuta dagoen edo ez esaten du.
	 * 
	 * @return Datu basera konexioa badago true itzultzen du, bestela false.
	 */
	public static boolean isConnectedToDatabase() {
		return Connector.connectedToDatabase;
	}

	/**
	 * Datu basera konexioa ixten du.
	 * 
	 * @throws java.sql.SQLException
	 */
	public static void close() throws SQLException {
		Connector.statement.close();
		Connector.connection.close();
		Connector.connectedToDatabase = false;
	}
}
