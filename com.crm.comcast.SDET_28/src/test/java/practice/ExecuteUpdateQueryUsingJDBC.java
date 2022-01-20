package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteUpdateQueryUsingJDBC {

	public static void main(String[] args) throws SQLException {

			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			//Establish the database connection
			
			  Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo", "root", "root");
			
			//issue statement
			
			Statement statement = connection.createStatement();
			
			//execute query
			
			int result = statement.executeUpdate("insert into student values(106, 'Jos', 'computer' )");
			if (result==1) {
				System.out.println("DataBase has been updated");
			}
			
			else 
				{System.out.println("Database not Updated");
		}		
	
		connection.close();


		}

	
}