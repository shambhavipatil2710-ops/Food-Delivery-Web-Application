package com.tap.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.MenuDAO;
import com.tap.model.Menu;
import com.tap.utility.DBConnection;

public class MenuDAOImpl implements MenuDAO{
	@Override
	public void addMenu(Menu menu) {
		Connection connection = DBConnection.getConnection();

        String insertQuery = "insert into menu (RestaurantID, ItemName, Description, Price, IsAvailable, Category, CreatedAt, UpdatedAt, imagePath)" + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement prepStatement = connection.prepareStatement(insertQuery);

            prepStatement.setInt(1, menu.getRestaurantID());
            prepStatement.setString(2, menu.getItemName());
            prepStatement.setString(3, menu.getDescription());
            prepStatement.setDouble(4, menu.getPrice());
            prepStatement.setBoolean(5, menu.IsAvailable());
            prepStatement.setString(6, menu.getCategory());
            prepStatement.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
            prepStatement.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
            prepStatement.setString(9, menu.getImagePath());

            int rowsAffected = prepStatement.executeUpdate();
            System.out.println(rowsAffected);
            System.out.println("Menu item added");

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public Menu getMenu(int MenuID) {
		Connection connection = DBConnection.getConnection();

        String selectQuery = "select * from menu where MenuID = ?";

        Menu menu = null;

        try {
            PreparedStatement prepStatement = connection.prepareStatement(selectQuery);
            prepStatement.setInt(1, MenuID);

            ResultSet resultSet = prepStatement.executeQuery();

            if (resultSet.next()) {
                menu = new Menu();
                menu.setMenuID(resultSet.getInt("MenuID"));
                menu.setRestaurantID(resultSet.getInt("RestaurantID"));
                menu.setItemName(resultSet.getString("ItemName"));
                menu.setDescription(resultSet.getString("Description"));
                menu.setPrice(resultSet.getDouble("Price"));
                menu.setIsAvailable(resultSet.getBoolean("IsAvailable"));
                menu.setCategory(resultSet.getString("Category"));
                menu.setCreatedAt(resultSet.getTimestamp("CreatedAt"));
                menu.setUpdatedAt(resultSet.getTimestamp("UpdatedAt"));
                menu.setDeletedAt(resultSet.getTimestamp("DeletedAt"));
                menu.setImagePath(resultSet.getString("imagePath"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return menu;
	}

	@Override
	public void updateMenu(Menu menu) {
		Connection connection = DBConnection.getConnection();

        String updateQuery = "update menu set ItemName = ?, Description = ?, Price = ?, IsAvailable = ?, Category = ?, UpdatedAt = ?, imagePath = ? where MenuID = ?";

        try {
            PreparedStatement prepStatement = connection.prepareStatement(updateQuery);

            prepStatement.setString(1, menu.getItemName());
            prepStatement.setString(2, menu.getDescription());
            prepStatement.setDouble(3, menu.getPrice());
            prepStatement.setBoolean(4, menu.IsAvailable());
            prepStatement.setString(5, menu.getCategory());
            prepStatement.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            prepStatement.setString(7, menu.getImagePath());
            prepStatement.setInt(8, menu.getMenuID());

            int rowsAffected = prepStatement.executeUpdate();
            System.out.println(rowsAffected);
            System.out.println("Menu item updated");

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public void deleteMenu(int MenuId) {
		Connection connection = DBConnection.getConnection();

        String deleteQuery = "delete from menu where MenuID = ?";

        try {
            PreparedStatement prepStatement = connection.prepareStatement(deleteQuery);
            prepStatement.setInt(1, MenuId);

            int rowsAffected = prepStatement.executeUpdate();
            System.out.println(rowsAffected);
            System.out.println("Menu item deleted");

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public List<Menu> getAllMenu() {
		Connection connection = DBConnection.getConnection();

        String selectAllQuery = "select * from menu";

        List<Menu> menuList = new ArrayList<>();

        try {
            PreparedStatement prepStatement = connection.prepareStatement(selectAllQuery);

            ResultSet resultSet = prepStatement.executeQuery();

            while (resultSet.next()) {
                Menu menu = new Menu();
                menu.setMenuID(resultSet.getInt("MenuID"));
                menu.setRestaurantID(resultSet.getInt("RestaurantID"));
                menu.setItemName(resultSet.getString("ItemName"));
                menu.setDescription(resultSet.getString("Description"));
                menu.setPrice(resultSet.getDouble("Price"));
                menu.setIsAvailable(resultSet.getBoolean("IsAvailable"));
                menu.setCategory(resultSet.getString("Category"));
                menu.setCreatedAt(resultSet.getTimestamp("CreatedAt"));
                menu.setUpdatedAt(resultSet.getTimestamp("UpdatedAt"));
                menu.setDeletedAt(resultSet.getTimestamp("DeletedAt"));
                menu.setImagePath(resultSet.getString("imagePath"));

                menuList.add(menu);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return menuList;
	}
	
	@Override
	public List<Menu> getMenuByRestaurant(int RestaurantID) {

		Connection connection =
				DBConnection.getConnection();

		String selectQuery =
				"select * from menu "
				+ "where RestaurantID = ? "
				+ "and DeletedAt is null";

		List<Menu> menuList =
				new ArrayList<Menu>();

		try {

			PreparedStatement prepStatement =
					connection.prepareStatement(selectQuery);

			prepStatement.setInt(
					1,
					RestaurantID);

			ResultSet resultSet =
					prepStatement.executeQuery();

			while (resultSet.next()) {

				Menu menu = createMenu(resultSet);

				menuList.add(menu);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return menuList;
	}

	private Menu createMenu(ResultSet resultSet)
			throws SQLException {

		Menu menu = new Menu();

		menu.setMenuID(resultSet.getInt("MenuID"));

		menu.setRestaurantID(resultSet.getInt("RestaurantID"));

		menu.setItemName(resultSet.getString("ItemName"));

		menu.setDescription(resultSet.getString("Description"));

		menu.setPrice(resultSet.getDouble("Price"));

		menu.setIsAvailable(resultSet.getBoolean("IsAvailable"));

		menu.setCategory(
				resultSet.getString("Category"));

		menu.setCreatedAt(
				resultSet.getTimestamp("CreatedAt"));

		menu.setUpdatedAt(resultSet.getTimestamp("UpdatedAt"));

		menu.setDeletedAt(resultSet.getTimestamp("DeletedAt"));

		menu.setImagePath(resultSet.getString("imagePath"));

		return menu;
	}
}
