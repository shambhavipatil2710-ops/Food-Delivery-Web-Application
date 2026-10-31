package com.tap.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.OrderItemDAO;
import com.tap.model.OrderItem;
import com.tap.utility.DBConnection;

public class OrderItemDAOImpl implements OrderItemDAO {
	@Override
    public void addOrderItem(OrderItem orderitem) {

        Connection connection = DBConnection.getConnection();

        String insertQuery = "insert into orderitem (OrderId, MenuId, Quantity, ItemTotal) "
                + "values (?, ?, ?, ?)";

        try {
            PreparedStatement prepStatement = connection.prepareStatement(insertQuery);

            prepStatement.setInt(1, orderitem.getOrderId());
            prepStatement.setInt(2, orderitem.getMenuId());
            prepStatement.setInt(3, orderitem.getQuantity());
            prepStatement.setBigDecimal(4, orderitem.getItemTotal());

            int rowsAffected = prepStatement.executeUpdate();
            System.out.println(rowsAffected);
            System.out.println("Order item added");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public OrderItem getOrderItem(int OrderItemId) {

        Connection connection = DBConnection.getConnection();

        String selectQuery = "select * from orderitem where OrderItemId = ?";

        OrderItem orderitem = null;

        try {
            PreparedStatement prepStatement = connection.prepareStatement(selectQuery);
            prepStatement.setInt(1, OrderItemId);

            ResultSet resultSet = prepStatement.executeQuery();

            if (resultSet.next()) {
                orderitem = new OrderItem();
                orderitem.setOrderItemId(resultSet.getInt("OrderItemId"));
                orderitem.setOrderId(resultSet.getInt("OrderId"));
                orderitem.setMenuId(resultSet.getInt("MenuId"));
                orderitem.setQuantity(resultSet.getInt("Quantity"));
                orderitem.setItemTotal(resultSet.getBigDecimal("ItemTotal"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderitem;
    }

    @Override
    public void updateOrderItem(OrderItem orderitem) {

        Connection connection = DBConnection.getConnection();

        String updateQuery = "update orderitem set Quantity = ?, ItemTotal = ? where OrderItemId = ?";

        try {
            PreparedStatement prepStatement = connection.prepareStatement(updateQuery);

            prepStatement.setInt(1, orderitem.getQuantity());
            prepStatement.setBigDecimal(2, orderitem.getItemTotal());
            prepStatement.setInt(3, orderitem.getOrderItemId());

            int rowsAffected = prepStatement.executeUpdate();
            System.out.println(rowsAffected);
            System.out.println("Order item updated");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrderItem(int OrderItemId) {

        Connection connection = DBConnection.getConnection();

        String deleteQuery = "delete from orderitem where OrderItemId = ?";

        try {
            PreparedStatement prepStatement = connection.prepareStatement(deleteQuery);
            prepStatement.setInt(1, OrderItemId);

            int rowsAffected = prepStatement.executeUpdate();
            System.out.println(rowsAffected);
            System.out.println("Order item deleted");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<OrderItem> getAllOrderItem() {

        Connection connection = DBConnection.getConnection();

        String selectAllQuery = "select * from orderitem";

        List<OrderItem> orderItemList = new ArrayList<>();

        try {
            PreparedStatement prepStatement = connection.prepareStatement(selectAllQuery);

            ResultSet resultSet = prepStatement.executeQuery();

            while (resultSet.next()) {
                OrderItem orderitem = new OrderItem();
                orderitem.setOrderItemId(resultSet.getInt("OrderItemId"));
                orderitem.setOrderId(resultSet.getInt("OrderId"));
                orderitem.setMenuId(resultSet.getInt("MenuId"));
                orderitem.setQuantity(resultSet.getInt("Quantity"));
                orderitem.setItemTotal(resultSet.getBigDecimal("ItemTotal"));

                orderItemList.add(orderitem);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderItemList;
    }

    @Override
    public List<OrderItem> getOrderItemsByOrderId(int orderId) {

        Connection connection = DBConnection.getConnection();

        String selectQuery = "select * from order_item where order_id = ?";

        List<OrderItem> orderItemList = new ArrayList<>();

        try {
            PreparedStatement prepStatement = connection.prepareStatement(selectQuery);
            prepStatement.setInt(1, orderId);

            ResultSet resultSet = prepStatement.executeQuery();

            while (resultSet.next()) {
                OrderItem orderitem = new OrderItem();
                orderitem.setOrderItemId(resultSet.getInt("OrderItemId"));
                orderitem.setOrderId(resultSet.getInt("OrderId"));
                orderitem.setMenuId(resultSet.getInt("MenuId"));
                orderitem.setQuantity(resultSet.getInt("Quantity"));
                orderitem.setItemTotal(resultSet.getBigDecimal("ItemTotal"));

                orderItemList.add(orderitem);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderItemList;
    }

}
