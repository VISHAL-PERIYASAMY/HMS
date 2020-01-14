package global.coda.hms.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import global.coda.hms.constant.DbConstants;

/**
 * The Class DataBaseConfig.
 *
 * @author Vishal Periyasamy R
 */
public final class DataBaseConfig {

	/**
	 * Instantiates a new data base config.
	 */
	private DataBaseConfig() {
	}

	/** The logger. */
	private final static Logger logger = LogManager.getLogger(DataBaseConfig.class);

	/**
	 * Gets the connection.
	 *
	 * @return Connection of the database
	 * @throws SQLException if connection fails
	 */
	public static Connection getConnection() throws SQLException {
		logger.traceEntry();
		Connection connection = DriverManager.getConnection(DbConstants.URL, DbConstants.USER, DbConstants.PASSWORD);
		logger.traceExit(connection);
		return connection;
	}
}
