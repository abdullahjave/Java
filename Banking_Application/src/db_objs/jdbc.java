package db_objs;

import java.sql.*;

public class jdbc {

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		// step 1 Register the Driver 
		Class.forName("com.mysql.jdbc.Driver");
		
		// step 2 Established the Connection 
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Banking_System","root","root");
		Statement stmt = con.createStatement();
		System.out.println("connectiom created");

		
	}

}
