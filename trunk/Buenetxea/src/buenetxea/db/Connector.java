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
	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	/**
	 * The URL of the server where the database is hosted
	 */
	public static final String DATABASE_URL = "jdbc:mysql://localhost/dbbuenetxea";

	private static String username;
	private static String password;

	private static java.sql.Connection connection;
	private static boolean connectedToDatabase = false;
	private static java.sql.Statement statement;

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
		System.out.println("Driverra Kargatuta");
	}

	/**
	 * @param user
	 * @param pass
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void connect(String user, String pass)
			throws SQLException, ClassNotFoundException {
		Connector.username = user;
		Connector.password = pass;
		Connector.connect();
	}

	/**
	 * 
	 * 
	 * @return Datu basearen konexioa
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
	 * @return
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
	 * 
	 * @return
	 */
	public static boolean isConnectedToDatabase() {
		return Connector.connectedToDatabase;
	}

	/**
	 * 
	 * @throws java.sql.SQLException
	 */
	public static void close() throws SQLException {
		Connector.connection.close();
		Connector.statement.close();
		Connector.connectedToDatabase = false;
	}
}
