package com.stevenprogramming.library.ocp8.jdbc.service.impl;

import com.stevenprogramming.library.ocp8.jdbc.dao.account.AccountDao;
import com.stevenprogramming.library.ocp8.jdbc.dao.account.impl.AccountDaoImpl;
import com.stevenprogramming.library.ocp8.jdbc.service.AccountService;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

/**
 *
 * @author Steven Ricardo Mendez Brenes
 * @since Mar 21 2019
 * @version 1.0
 */
public class AccountServiceImpl implements AccountService {

    private static Optional<ResultSet> getOptionalResultSet(){
        AccountDao accountDao = AccountDaoImpl.getInstance();
        Optional<ResultSet> resultSetOptional = Optional.empty();
        if( accountDao != null){
            resultSetOptional = accountDao.getAccounts();
        }
        return resultSetOptional;
    }
    private static void firstMethodNormalResultset(){
        Optional<ResultSet> resultSetOptional = getOptionalResultSet();
        if (resultSetOptional.isPresent()) {
            ResultSet resultSet = resultSetOptional.get();
            try {
                System.out.println("Data");
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt(1));
                    System.out.printf("%-30.30s  %-30.30s%n", resultSet.getString("email"), resultSet.getString("username"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void validateMovementAndConcurrency(){
        AccountDaoImpl.getInstance().printDatabaseMetaData();
    }
    
    public static void testMovementAndConcurrency(){
        AccountDaoImpl.getInstance().createStatementInsentiveUpdatable();
    }
    
    public static void main(String[] args) {
        validateMovementAndConcurrency();
        firstMethodNormalResultset();
        testMovementAndConcurrency();
    }
}
