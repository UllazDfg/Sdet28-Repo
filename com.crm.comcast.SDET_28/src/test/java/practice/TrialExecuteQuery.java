package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class TrialExecuteQuery {

	public static void main(String[] args) throws SQLException {
	Driver driver = new Driver();
	DriverManager.registerDriver(driver);
	
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo", "root","root");
	
	Statement statement = connection.createStatement();
	
	int result = statement.executeUpdate("inset into student values (105, 'Appu' , 'History')");
	if (result==1) {
	
		System.out.println("Updated");
	}
	
	
	
	
	
	
	}
}


