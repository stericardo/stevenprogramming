package com.stevenprogramming.library.ocp8.jdbc.dao.account;

import java.sql.ResultSet;
import java.util.Optional;

/**
 *
 * @author Steven Ricardo Mendez Brenes
 * @since Mar 21 2019
 * @version 1.0
 */
public interface AccountDao {

    Optional<ResultSet> getAccounts();
    
    void printDatabaseMetaData();
    
    void createStatementInsentiveUpdatable();

    void runQueries(String query, int option);
    
}
