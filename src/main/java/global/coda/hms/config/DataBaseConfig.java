package global.coda.hms.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import global.coda.hms.constant.DbConstants;

/**
 *
 * @author Vishal Periyasamy R
 */
public final class DataBaseConfig {

	/**
	 * Instantiates a new data base config.
	 */
	private DataBaseConfig() {
	}

	/**
	 * Gets the connection.
	 *
	 * @return Connection of the database
	 * @throws SQLException if connection fails
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DbConstants.URL, DbConstants.USER, DbConstants.PASSWORD);
	}
}
