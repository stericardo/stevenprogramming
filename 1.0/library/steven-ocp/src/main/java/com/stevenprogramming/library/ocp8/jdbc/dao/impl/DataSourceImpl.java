package com.stevenprogramming.library.ocp8.jdbc.dao.impl;

import com.stevenprogramming.library.ocp8.jdbc.dao.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Steven Ricardo Mendez Brenes
 * @since Mar 21 2019
 * @version 1.0
 */
public class DataSourceImpl implements DataSource{
    
    private static DataSourceImpl dataSourceImpl = new DataSourceImpl();
    private DataSourceImpl(){
    }
    
    public static DataSourceImpl getInstance(){
        return dataSourceImpl;
    }
    
    @Override
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/steven", "steven", "steven");
    }

}