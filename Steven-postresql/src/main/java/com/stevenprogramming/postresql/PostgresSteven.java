package com.stevenprogramming.postresql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * mvn exec:java -Dexec.mainClass="com.stevenprogramming.postresql.PostgresSteven"
 **/
public class PostgresSteven {
	
	 // 1. Define connection details
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "2rHPwHr0pu2k";

		public static void main(String[] args){
		
			long startTime = System.currentTimeMillis();
			insertDatTransaction();
			long stopTime = System.currentTimeMillis();
			System.out.println(stopTime - startTime  + " ms = " + ( (stopTime - startTime) / 1000));
			
		}
		
		public static void insertDatTransaction(){
			// 3. Establish connection and prepare statements
			try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);) {
					// STEP 1: Disable auto-commit to start the transaction block manually
					connection.setAutoCommit(false); 
					for(int idx=2_000_000; idx < 2_100_000; idx++){
						String insertSql = "INSERT INTO users_jdbc (email, first_name, last_name) VALUES (?, ?, ?)";
						PreparedStatement insertStmt = connection.prepareStatement(insertSql);
						insertStmt.setString(1, "ricardostev"+idx+"@gmail.com");
						insertStmt.setString(2, "Steven " + idx);
						insertStmt.setString(3, "Mendez");
						int rowsInserted = insertStmt.executeUpdate();
						//System.out.println("Rows inserted: " + rowsInserted);
					}
					// STEP 3: Commit the transaction if all operations succeed
					connection.commit();
					
			} catch (SQLException e) {
				System.err.println("Database error occurred:");
				e.printStackTrace();
			}
			
		}
		
		public static void insertData(){
			// 3. Establish connection and prepare statements
			try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);) {
					for(int idx=1_206_000; idx < 1_584_811; idx++){
						String insertSql = "INSERT INTO users_jdbc (email, first_name, last_name) VALUES (?, ?, ?)";
						PreparedStatement insertStmt = connection.prepareStatement(insertSql);
						insertStmt.setString(1, "ricardostev"+idx+"@gmail.com");
						insertStmt.setString(2, "Steven " + idx);
						insertStmt.setString(3, "Mendez");
						int rowsInserted = insertStmt.executeUpdate();
						//System.out.println("Rows inserted: " + rowsInserted);
					}
					
			} catch (SQLException e) {
				System.err.println("Database error occurred:");
				e.printStackTrace();
			}
			
		}
		
		public static void selectData(){
		
		String selectSql = "SELECT id, email, first_name, last_name FROM users_jdbc";

        // 3. Establish connection and prepare statements
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			 //String insertSql = "INSERT INTO users (name, email) VALUES (?, ?)";
			 //PreparedStatement insertStmt = connection.prepareStatement(insertSql);
			 // --- INSERT DATA ---
            //insertStmt.setString(1, "Alice Smith");
            //insertStmt.setString(2, "alice@example.com");
            //int rowsInserted = insertStmt.executeUpdate();
            //System.out.println("Rows inserted: " + rowsInserted);
             
             PreparedStatement selectStmt = connection.prepareStatement(selectSql)) {

            System.out.println("Connected to PostgreSQL successfully!");
            // --- READ DATA ---
            try (ResultSet resultSet = selectStmt.executeQuery()) {
                System.out.println("\n--- User List ---");
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name");
                    String email = resultSet.getString("email");
                    for(int idx = 0; idx < 1000000; idx++){
						System.out.printf("ID: %d | Name: %s | Email: %s | LastName: %s %n", id, firstName, email, lastName);
					}
                }
            }
            

        } catch (SQLException e) {
            System.err.println("Database error occurred:");
            e.printStackTrace();
        }

			
		}
	
}
