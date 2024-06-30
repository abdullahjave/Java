package db_objs;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyJDBC {
    private static final String DB_Name = "jdbc:mysql://localhost:3306/Banking_System";
    private static final String DB_Username = "root";
    private static final String DB_Password = "root";

    public static User validatelogin(String username, String password) {
        try {
            Connection con = DriverManager.getConnection(DB_Name, DB_Username, DB_Password);
            PreparedStatement preparedStatement = con.prepareStatement(
                    "SELECT * FROM users WHERE username = ? AND password = ? ");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int userId = resultSet.getInt("users_id");
                BigDecimal currentBalance = resultSet.getBigDecimal("current_balance");
                return new User(userId, username, password, currentBalance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean register(String username, String password) {
        try {
            if (!checkUser(username)) {
                Connection connection = DriverManager.getConnection(DB_Name, DB_Username, DB_Password);
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO users(username, password, current_balance) VALUES(?, ?, ?)");
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                preparedStatement.setBigDecimal(3,  new BigDecimal(0));

                preparedStatement.executeUpdate();
                return true; // Registration successful
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; // Registration failed (username already taken or other error)
    }

    //true user 
    // false user not
    private static boolean checkUser(String username) {
        try {
            Connection connection = DriverManager.getConnection(DB_Name, DB_Username, DB_Password);

            // SQL Query
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM users WHERE username = ? "
            );

            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            // next return true or false
            if (resultSet.next()) {
                // Username found in database, indicating it is taken
                return true;
            } else {
                // Username not found in database, indicating it is available
                return false;
            }
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return true; // Default to true (username not available) in case of error
    }
    
    public static boolean addTransactionToDatabase(Transaction transaction)
    {
    	try {
    		Connection connection = DriverManager.getConnection(DB_Name, DB_Username, DB_Password);
    		
    		PreparedStatement insertTransaction = connection.prepareStatement( 
    				"INSERT transactions(users_id, transaction_type , transaction_amount ,transaction_time )" +
    						"VALUES(?, ?, ?, now())"
    				);
    		
    		insertTransaction.setInt(1, transaction.getUserId());
    		insertTransaction.setString(2, transaction.getTransaction());
    		insertTransaction.setBigDecimal(3, transaction.getTransactionAmount());
    		
    		return true;
    	
    	} 
    	catch (SQLException e) 
    	{
    		e.printStackTrace();
		}
    	return false;
    }
    
    public static boolean updateCurrentBalance(User user)
    {
    	try 
    	{
    		Connection connection = DriverManager.getConnection(DB_Name, DB_Username, DB_Password);
    		
    		PreparedStatement updateBalance = connection.prepareStatement( 
    				"UPDATE users SET current_balance = ? WHERE t_id = ?"
    				);
  
    		updateBalance.setBigDecimal(1, user.getCurrentBalance());
      		updateBalance.setInt(2, user.getId());
      		
      		updateBalance.executeUpdate();
    		return true;
    	
    	} 
    	catch (SQLException e) 
    	{
    		e.printStackTrace();
		}
    	return false;
    }


}

