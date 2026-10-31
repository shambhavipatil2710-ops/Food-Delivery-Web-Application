package com.tap.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.RestaurantDAO;
import com.tap.model.Restaurant;
import com.tap.utility.DBConnection;

public class RestaurantDAOImpl implements RestaurantDAO{
	@Override
	public void addRestaurant(Restaurant restaurant) {
		Connection connection = DBConnection.getConnection();

		String insertQuery = "insert into restaurant (Name, CuisineType, DeliveryTime, Address, AdminUserID, Rating, IsActive)" +" values (?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement prepStatement = connection.prepareStatement(insertQuery);

			prepStatement.setString(1, restaurant.getName());
			prepStatement.setString(2, restaurant.getCuisineType());
			prepStatement.setInt(3, restaurant.getDeliveryTime());
			prepStatement.setString(4, restaurant.getAddress());
			prepStatement.setInt(5, restaurant.getAdminUserID());
			prepStatement.setDouble(6, restaurant.getRating());
			prepStatement.setBoolean(7, restaurant.IsActive());

			int rowsAffected = prepStatement.executeUpdate();
			System.out.println(rowsAffected);
			System.out.println("Restaurant added");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Restaurant getRestaurant(int RestaurantID) {
		Connection connection = DBConnection.getConnection();

		String selectQuery = "select * from restaurant where RestaurantID = ?";

		Restaurant restaurant = null;

		try {
			PreparedStatement prepStatement = connection.prepareStatement(selectQuery);
			prepStatement.setInt(1, RestaurantID);

			ResultSet resultSet = prepStatement.executeQuery();

			if (resultSet.next()) {
				restaurant = new Restaurant();
				restaurant.setRestaurantID(resultSet.getInt("RestaurantID"));
				restaurant.setName(resultSet.getString("Name"));
				restaurant.setCuisineType(resultSet.getString("CuisineType"));
				restaurant.setDeliveryTime(resultSet.getInt("DeliveryTime"));
				restaurant.setAddress(resultSet.getString("Address"));
				restaurant.setAdminUserID(resultSet.getInt("AdminUserID"));
				restaurant.setRating(resultSet.getDouble("Rating"));
				restaurant.setIsActive(resultSet.getBoolean("IsActive"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return restaurant;
	}

	@Override
	public void updateRestaurant(Restaurant restaurant) {
		Connection connection = DBConnection.getConnection();

		String updateQuery = "update restaurant set Name = ?, CuisineType = ?, DeliveryTime = ?, Address = ?, AdminUserID = ?, Rating = ?, IsActive = ? where RestaurantID = ?";

		try {
			PreparedStatement prepStatement = connection.prepareStatement(updateQuery);

			prepStatement.setString(1, restaurant.getName());
			prepStatement.setString(2, restaurant.getCuisineType());
			prepStatement.setInt(3, restaurant.getDeliveryTime());
			prepStatement.setString(4, restaurant.getAddress());
			prepStatement.setInt(5, restaurant.getAdminUserID());
			prepStatement.setDouble(6, restaurant.getRating());
			prepStatement.setBoolean(7, restaurant.IsActive());
			prepStatement.setInt(8, restaurant.getRestaurantID());

			int rowsAffected = prepStatement.executeUpdate();
			System.out.println(rowsAffected);
			System.out.println("Restaurant updated");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteRestaurant(int RestaurantID) {
		Connection connection = DBConnection.getConnection();

		String deleteQuery = "delete from restaurant where RestaurantID = ?";

		try {
			PreparedStatement prepStatement = connection.prepareStatement(deleteQuery);
			prepStatement.setInt(1, RestaurantID);

			int rowsAffected = prepStatement.executeUpdate();
			System.out.println(rowsAffected);
			System.out.println("Restaurant deleted");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Restaurant> getAllRestaurant() {
		Connection connection = DBConnection.getConnection();

		String selectAllQuery = "select * from restaurant";

		List<Restaurant> restaurantList = new ArrayList<>();

		try {
			PreparedStatement prepStatement = connection.prepareStatement(selectAllQuery);

			ResultSet resultSet = prepStatement.executeQuery();

			while (resultSet.next()) {
				Restaurant restaurant = new Restaurant();
				restaurant.setRestaurantID(resultSet.getInt("RestaurantID"));
				restaurant.setName(resultSet.getString("Name"));
				restaurant.setCuisineType(resultSet.getString("CuisineType"));
				restaurant.setDeliveryTime(resultSet.getInt("DeliveryTime"));
				restaurant.setAddress(resultSet.getString("Address"));
				restaurant.setAdminUserID(resultSet.getInt("AdminUserID"));
				restaurant.setRating(resultSet.getDouble("Rating"));
				restaurant.setIsActive(resultSet.getBoolean("IsActive"));
				restaurant.setImagePath(resultSet.getString("imagePath"));

				restaurantList.add(restaurant);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return restaurantList;
	}

}
