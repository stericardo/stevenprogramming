package com.stevenprogramming.library.ocp8.jdbc.dao.account.impl;

import com.stevenprogramming.library.ocp8.jdbc.dao.DataSource;
import com.stevenprogramming.library.ocp8.jdbc.dao.account.AccountDao;
import com.stevenprogramming.library.ocp8.jdbc.dao.impl.DataSourceImpl;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

/**
 * @author Steven Ricardo Mendez Brenes
 * @version 1.0
 * @since Mar 21 2019
 */
public class AccountDaoImpl implements AccountDao
{

    private static AccountDaoImpl accountDaoImpl = new AccountDaoImpl();

    private AccountDaoImpl()
    {
    }

    public static AccountDaoImpl getInstance()
    {
        return accountDaoImpl;
    }

    private DataSource getDataSource()
    {
        return DataSourceImpl.getInstance();
    }

    @Override
    public Optional<ResultSet> getAccounts()
    {
        Optional<ResultSet> resultSet = Optional.empty();
        try
        {
            Connection connection = getDataSource().getConnection();
            Statement statement = connection.createStatement();
            resultSet = Optional.ofNullable( statement.executeQuery( "select * FROM account" ) );
        }
        catch ( Exception e )
        {

        }
        return resultSet;
    }

    @Override
    public void printDatabaseMetaData()
    {
        try
        {
            Connection connection = getDataSource().getConnection();
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            printSupportsResultSetType( databaseMetaData, ResultSet.TYPE_FORWARD_ONLY, "ResultSet.TYPE_FORWARD_ONLY" );
            printSupportsResultSetType( databaseMetaData, ResultSet.TYPE_SCROLL_INSENSITIVE, "ResultSet.TYPE_SCROLL_INSENSITIVE" );
            printSupportsResultSetType( databaseMetaData, ResultSet.TYPE_SCROLL_SENSITIVE, "ResultSet.TYPE_SCROLL_SENSITIVE" );

            printSupportsConcurrency( databaseMetaData, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE, "ResultSet.TYPE_FORWARD_ONLY - CONCUR_UPDATABLE" );
            printSupportsConcurrency( databaseMetaData, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE, "ResultSet.TYPE_SCROLL_INSENSITIVE - CONCUR_UPDATABLE" );
            printSupportsConcurrency( databaseMetaData, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, "ResultSet.TYPE_SCROLL_SENSITIVE - CONCUR_UPDATABLE" );

        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
    }

    private void printSupportsResultSetType( DatabaseMetaData databaseMetaData, int type, String name ) throws SQLException
    {
        if ( databaseMetaData.supportsResultSetType( type ) )
        {
            System.out.println( "Supports " + name + ":" + type );
        }
        else
        {
            System.out.println( "Does not Supports " + name + ":" + type );
        }
    }

    private void printSupportsConcurrency( DatabaseMetaData databaseMetaData, int type, int concurrency, String name ) throws SQLException
    {
        if ( databaseMetaData.supportsResultSetConcurrency( type, concurrency ) )
        {
            System.out.println( "Supports concurrency " + name + ":" + type + ":concurrency=" + concurrency );
        }
        else
        {
            System.out.println( "Does not Supports concurrency " + name + ":" + type + ":concurrency=" + concurrency );
        }
    }

    @Override
    public void createStatementInsentiveUpdatable()
    {
        try
        {
            System.out.println( "\t\t****\tCreateStatementInsentiveUpdatable\t**** " );
            Connection connection = getDataSource().getConnection();
            Statement statement = connection.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
            Optional<ResultSet> resultSetOptional = Optional.empty();
            resultSetOptional = Optional.ofNullable( statement.executeQuery( "select * FROM account" ) );
            if ( resultSetOptional.isPresent() )
            {
                ResultSet resultSet = resultSetOptional.get();
                // Returns: true if the cursor is on a valid row; false if there are no rows in the result set
                if ( resultSet.last() )
                {
                    int rowCount = ( resultSet.getRow() );
                    System.out.println( "Row Number " + rowCount );
                    System.out.printf( "%-30.30s  %-30.30s%n", resultSet.getString( "email" ), resultSet.getString( "username" ) );
                    resultSet.beforeFirst();
                    try
                    {
                        System.out.printf( "%-30.30s  %-30.30s%n", resultSet.getString( "email" ), resultSet.getString( "username" ) );
                    }
                    catch ( SQLException e )
                    {
                        System.out.println( " Intentionally when we have only 2 rows " + e.toString() );
                    }
                    //After printException move to first Row
                    resultSet.next();
                    System.out.printf( "%-30.30s  %-30.30s%n", resultSet.getString( "email" ), resultSet.getString( "username" ) );
                    resultSet.next();
                    resultSet.previous();
                    //Print again the first Row
                    System.out.printf( "%-30.30s  %-30.30s%n", resultSet.getString( "email" ), resultSet.getString( "username" ) );

                    //Move to end record + 1 = NO data, then relative -1 back to last record  
                    resultSet.afterLast();
                    resultSet.relative( -1 );
                    System.out.printf( "%-30.30s  %-30.30s%n", resultSet.getString( "email" ), resultSet.getString( "username" ) );

                    System.out.println( " resultSet.absolute(0) returns: " + resultSet.absolute( 0 ) );

                }
            }
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
    }

    @Override
    public void runQueries( String query, int option )
    {
        try
        {
            Connection connection = getDataSource().getConnection();
            Statement statement = connection.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
            // Using next you will receive: Operation requires a scrollable ResultSet, but this ResultSet is FORWARD_ONLY.
            //Statement statement = connection.createStatement(  );
            run( statement, query, option );
        }
        catch ( SQLException e )
        {

        }
    }

    private void run( Statement statement, String query, int option )
    {
        switch ( option )
        {
            case 1:
                try
                {
                    boolean result = statement.execute( query );
                    System.out.println( "****\n\nresult execute " + result );
                    if ( result )
                    {
                        ResultSet resultSet = statement.getResultSet();
                        if ( resultSet.last() )
                        {
                            System.out.println( "Rows count " + resultSet.getRow() );
                            System.out.println( "result execute modified Elements " + statement.getUpdateCount() );
                        }
                    }
                    else
                    {
                        System.out.println( "result execute modified Elements " + statement.getUpdateCount() + " ResultSet " + statement.getResultSet());
                    }
                }
                catch ( SQLException e )
                {
                    System.out.println( "Error execute " + query + " e " + e.getMessage() );
                }
                break;
            case 2:
                try
                {
                    int rowsAffected = statement.executeUpdate( query );
                    System.out.println( "executeUpdate rowsAffected ::: " + rowsAffected );
                }
                catch ( SQLException e )
                {
                    System.out.println( "Error executeUpdate " + query + " e " + e.getMessage() );
                }
                break;
            case 3:
                try
                {
                    statement.executeQuery( query );
                }
                catch ( SQLException e )
                {
                    System.out.println( "Error executeQuery " + query + " e " + e.getMessage() );
                }
                break;
            case 4:
                try
                {
                    ResultSet resultSet = statement.executeQuery( query );
                    System.out.println(resultSet);
                    resultSet.next();
                    System.out.println(resultSet.getInt( 1 ));

                }
                catch ( SQLException e )
                {
                    System.out.println( "Error executeQuery POINT 6 * 6 " + query + " e " + e.getMessage() );
                }
                break;

            case 5:
                try
                {
                    ResultSet resultSet = statement.executeQuery( query );
                    System.out.println(resultSet);
                    resultSet.next();
                    System.out.println(resultSet.getInt( 1 ));

                }
                catch ( SQLException e )
                {
                    System.out.println( "Error executeQuery POINT 4 " + query + " e " + e.getMessage() );
                }
                break;
            case 6:
                try
                {
                    Connection connection = getDataSource().getConnection();
                    statement = connection.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );
                    ResultSet resultSet = statement.executeQuery( query );
                    System.out.println(resultSet);
                    resultSet.next();
                    resultSet.absolute( 0 );
                    System.out.println(resultSet.getInt( 1 ));

                }
                catch ( SQLException e )
                {
                    System.out.println( "Error executeQuery POINT 4 " + query + " e " + e.getMessage() );
                }
                break;

        }
    }
}
