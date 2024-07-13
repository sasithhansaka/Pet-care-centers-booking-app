package Final_project_mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Room_book_model {
	
	    String url = "jdbc:mysql://localhost:3306/pet_care";
	    String username = "root";
	    String password = "";
	    
	    public ResultSet getUserProfileResultSet() {
	        ResultSet resultSet = null ;
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection connection = DriverManager.getConnection(url, username, password); 
	            String sqlString="SELECT location FROM petcare_centers ";
	            Statement statement = connection.createStatement();
	            resultSet=statement.executeQuery(sqlString);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return resultSet;
	    }

	}

	
