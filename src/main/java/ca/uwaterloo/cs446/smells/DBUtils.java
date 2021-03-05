package ca.uwaterloo.cs446.smells;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
	// Connection constants. Normally not hardcoded like this, but for the
	// purposes of the quiz, this should be fine.
	private static String hostname = "myhost";
	private static int port = 3306;
	private static String username = "someuser";
	private static String pass = "somepassword";

	private static DBUtils instance = null;

	private Connection dbConnection;

	private DBUtils() throws SQLException {
		Properties connectionProperties = new Properties();
		connectionProperties.put("user", DBUtils.username);
		connectionProperties.put("password", DBUtils.pass);
		
		String connectionString = "jdbc:mysql://" + hostname + ":" +
			port + "/";
		this.dbConnection = DriverManager.getConnection(connectionString, connectionProperties);
	}

	public DBUtils getInstance() throws SQLException {
		if (instance == null) {
			instance = new DBUtils();
		}

		return instance;
	}
}
