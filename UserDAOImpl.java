package com.tap.DAOImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import com.tap.DAO.UserDAO;
import com.tap.model.User;
import com.tap.utility.DBConnection;

public class UserDAOImpl implements UserDAO{

	@Override
	public void addUser(User user) {
		Connection connection = DBConnection.getConnection();
		String insertQuery = "insert into user (username, email, password, address, role, createdDate, lastLoginDate)"
				+"values (?, ?, ?, ?, ?, ?, ?)"; 

		try {
            PreparedStatement prepStatement = connection.prepareStatement(insertQuery);

            prepStatement.setString(1, user.getUsername());
            prepStatement.setString(2, user.getEmail());
            prepStatement.setString(3, user.getPassword());
            prepStatement.setString(4, user.getAddress());
            prepStatement.setString(5, user.getRole());
            prepStatement.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            prepStatement.setTimestamp(7, new Timestamp(System.currentTimeMillis()));

            int rowsAffected = prepStatement.executeUpdate();
            System.out.println(rowsAffected);
            

        }  catch(SQLException e) {
    			e.printStackTrace();
    		}
	}
	public User getUserByUsername(String username) {
	    User user = null;

	    try {
	        Connection connection = DBConnection.getConnection();

	        String query = "select * from user where username = ?";
	        PreparedStatement ps = connection.prepareStatement(query);
	        ps.setString(1, username);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            user = new User();
	            user.setUserId(rs.getInt("userId"));
	            user.setUsername(rs.getString("username"));
	            user.setEmail(rs.getString("email"));
	            user.setPassword(rs.getString("password"));
	            user.setAddress(rs.getString("address"));
	            user.setRole(rs.getString("role"));
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return user;
	}
	

	@Override
	public User getUser(int userId) {
		
		Connection connection = DBConnection.getConnection();

	    String selectQuery = "select * from user where userId = ?";

	    User user = null;

	    try {
	        PreparedStatement prepStatement = connection.prepareStatement(selectQuery);
	        prepStatement.setInt(1, userId);

	        ResultSet resultSet = prepStatement.executeQuery();

	        if (resultSet.next()) {
	            user = new User();
	            user.setUserId(resultSet.getInt("userId"));
	            user.setUsername(resultSet.getString("userName"));
	            user.setEmail(resultSet.getString("email"));
	            user.setPassword(resultSet.getString("password"));
	            user.setAddress(resultSet.getString("address"));
	            user.setRole(resultSet.getString("role"));
	            user.setCreatedDate(resultSet.getTimestamp("createdDate"));
	            user.setLastLoginDate(resultSet.getTimestamp("lastLoginDate"));
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return user;
	}

	@Override
	public void updateUser(User user) {
		Connection connection = DBConnection.getConnection();

	    String updateQuery = "update user set userName = ?, email = ?, password = ?, address = ?, "
	            + "role = ?, lastLoginDate = ? where userId = ?";

	    try {
	        PreparedStatement prepStatement = connection.prepareStatement(updateQuery);

	        prepStatement.setString(1, user.getUsername());
	        prepStatement.setString(2, user.getEmail());
	        prepStatement.setString(3, user.getPassword());
	        prepStatement.setString(4, user.getAddress());
	        prepStatement.setString(5, user.getRole());
	        prepStatement.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
	        prepStatement.setInt(7, user.getUserId());

	        int rowsAffected = prepStatement.executeUpdate();
	        System.out.println(rowsAffected);
	        System.out.println("User updated");

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}

	@Override
	public void deleteUser(int userId) {
		  Connection connection = DBConnection.getConnection();

	        String deleteQuery = "delete from user where userId = ?";

	        try {
	            PreparedStatement prepStatement = connection.prepareStatement(deleteQuery);
	            prepStatement.setInt(1, userId);

	            int rowsAffected = prepStatement.executeUpdate();
	            System.out.println(rowsAffected);
	            System.out.println("User deleted");

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
		

	@Override
	public List<User> getAllUser() {
		Connection connection = DBConnection.getConnection();

	    String selectAllQuery = "select * from user";

	    List<User> userList = new ArrayList<>();

	    try {
	        PreparedStatement prepStatement = connection.prepareStatement(selectAllQuery);

	        ResultSet resultSet = prepStatement.executeQuery();

	        while (resultSet.next()) {
	            User user = new User();
	            user.setUserId(resultSet.getInt("userId"));
	            user.setUsername(resultSet.getString("userName"));
	            user.setEmail(resultSet.getString("email"));
	            user.setPassword(resultSet.getString("password"));
	            user.setAddress(resultSet.getString("address"));
	            user.setRole(resultSet.getString("role"));
	            user.setCreatedDate(resultSet.getTimestamp("createdDate"));
	            user.setLastLoginDate(resultSet.getTimestamp("lastLoginDate"));

	            userList.add(user);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return userList;
	}
	
	 
	

}
