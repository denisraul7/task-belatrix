package com.belatrix.tech.task.data.connection;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

/**
 * Class DataBaseConnection for enable connection database.
 */
public abstract class DataBaseConnection {

	public abstract Statement newConnection(Map parameters) throws SQLException;
}
