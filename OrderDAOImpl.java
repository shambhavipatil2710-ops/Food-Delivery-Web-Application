package com.tap.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.OrderDAO;
import com.tap.model.Order;
import com.tap.utility.DBConnection;

public class OrderDAOImpl implements OrderDAO {
	@Override
    public void addOrder(Order order) {

        Connection connection = DBConnection.getConnection();

        String insertQuery = "insert into order (UserId, RestaurantId, OrderDate, TotalAmount, Status, PaymentMethod) " + " values (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement prepStatement = connection.prepareStatement(insertQuery);

            prepStatement.setInt(1, order.getUserId());
            prepStatement.setInt(2, order.getRestaurantId());
            prepStatement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            prepStatement.setBigDecimal(4, order.getTotalAmount());
            prepStatement.setString(5, order.getStatus());
            prepStatement.setString(6, order.getPaymentMethod());

            int rowsAffected = prepStatement.executeUpdate();
            System.out.println(rowsAffected);
            System.out.println("Order placed");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Order getOrder(int OrderId) {

        Connection connection = DBConnection.getConnection();

        String selectQuery = "select * from order where OrderId = ?";

        Order order = null;

        try {
            PreparedStatement prepStatement = connection.prepareStatement(selectQuery);
            prepStatement.setInt(1, OrderId);

            ResultSet resultSet = prepStatement.executeQuery();

            if (resultSet.next()) {
                order = new Order();
                order.setOrderId(resultSet.getInt("OrderId"));
                order.setUserId(resultSet.getInt("UserId"));
                order.setRestaurantId(resultSet.getInt("RestaurantId"));
                order.setOrderDate(resultSet.getTimestamp("OrderDate"));
                order.setTotalAmount(resultSet.getBigDecimal("TotalAmount"));
                order.setStatus(resultSet.getString("Status"));
                order.setPaymentMethod(resultSet.getString("PaymentMethod"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return order;
    }

    @Override
    public void updateOrder(Order order) {

        Connection connection = DBConnection.getConnection();

        // Typically only status/payment fields are updated post-creation
        // (order_date, user_id, restaurant_id shouldn't change after placement)
        String updateQuery = "update order set TotalAmount = ?, Status = ?, PaymentMethod = ? "
                + "where OrderId = ?";

        try {
            PreparedStatement prepStatement = connection.prepareStatement(updateQuery);

            prepStatement.setBigDecimal(1, order.getTotalAmount());
            prepStatement.setString(2, order.getStatus());
            prepStatement.setString(3, order.getPaymentMethod());
            prepStatement.setInt(4, order.getOrderId());

            int rowsAffected = prepStatement.executeUpdate();
            System.out.println(rowsAffected);
            System.out.println("Order updated");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrder(int OrderId) {

        Connection connection = DBConnection.getConnection();

        String deleteQuery = "delete from order where OrderId = ?";

        try {
            PreparedStatement prepStatement = connection.prepareStatement(deleteQuery);
            prepStatement.setInt(1, OrderId);

            int rowsAffected = prepStatement.executeUpdate();
            System.out.println(rowsAffected);
            System.out.println("Order deleted");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Order> getAllOrder() {

        Connection connection = DBConnection.getConnection();

        String selectAllQuery = "select * from order";

        List<Order> orderList = new ArrayList<>();

        try {
            PreparedStatement prepStatement = connection.prepareStatement(selectAllQuery);

            ResultSet resultSet = prepStatement.executeQuery();

            while (resultSet.next()) {
                Order order = new Order();
                order.setOrderId(resultSet.getInt("OrderId"));
                order.setUserId(resultSet.getInt("UserId"));
                order.setRestaurantId(resultSet.getInt("RestaurantId"));
                order.setOrderDate(resultSet.getTimestamp("OrderDate"));
                order.setTotalAmount(resultSet.getBigDecimal("TotalAmount"));
                order.setStatus(resultSet.getString("Status"));
                order.setPaymentMethod(resultSet.getString("PaymentMethod"));

                orderList.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderList;
    }

}
