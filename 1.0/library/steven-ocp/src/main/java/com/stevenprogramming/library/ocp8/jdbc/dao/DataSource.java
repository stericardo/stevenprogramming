package com.stevenprogramming.library.ocp8.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author smendez 
 */
public interface DataSource {
    
    Connection getConnection() throws SQLException;
    
}
