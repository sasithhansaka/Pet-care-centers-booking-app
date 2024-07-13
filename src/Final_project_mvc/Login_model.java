package Final_project_mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login_model {
	
    String url = "jdbc:mysql://localhost:3306/pet_care";
    String username = "root";
    String password = "";

    public boolean login(String user_name, String password_) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password); 
            String sql = "SELECT * FROM register WHERE user_name=? AND password=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user_name);
            statement.setString(2, password_);
            ResultSet resultSet = statement.executeQuery();
            boolean found = resultSet.next();
            resultSet.close();
            statement.close();
            connection.close();
            return found;
        } catch (ClassNotFoundException e)  {
            e.printStackTrace();
            return false;
        }
        catch (SQLException e2) {
        	e2.printStackTrace();
        	return false;
		}
        catch (Exception e) {
        	return false;
		}
    }



    public boolean register(String getusername, String getpassword, String getemail, String getpetType, String getpetName) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password) ;
                String checkUsernameQuery = "SELECT *  FROM register WHERE user_name=?";
              PreparedStatement checkStatement = connection.prepareStatement(checkUsernameQuery);
                    checkStatement.setString(1, getusername);
                  ResultSet resultSet = checkStatement.executeQuery();
                        if (resultSet.next()) {
                            return false;
                        } else {
                            String insertQuery = "INSERT INTO register (user_name, password, email, pet_type, pet_height, pet_weight, pet_name) VALUES (?, ?, ?, ?, '0', '0', ?)";
                            try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
                                insertStatement.setString(1, getusername);
                                insertStatement.setString(2, getpassword);
                                insertStatement.setString(3, getemail);
                                insertStatement.setString(4, getpetType);
                                insertStatement.setString(5, getpetName);
                                int rowsAffected = insertStatement.executeUpdate();
                                if (rowsAffected > 0) {
                                    String insert_notifi = "INSERT INTO notification(content,current,username)VALUES (?,?,? )";
                                    try (PreparedStatement statement2 = connection.prepareStatement(insert_notifi)) {
                                        statement2.setString(1,""+getusername+" welcome to the Pet Care System. We're thrilled to have you join our community pets.");
                                        statement2.setString(2, "new");
                                        statement2.setString(3, getusername);
                                        statement2.executeUpdate();
                                        return true;  
                                    }
                                } else {
                                    return false;
                                }
                            }
                        }
                    
                
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}