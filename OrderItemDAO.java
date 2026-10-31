package com.tap.DAO;

import java.util.List;

import com.tap.model.OrderItem;

public interface OrderItemDAO {
	void addOrderItem(OrderItem orderItem);

    OrderItem getOrderItem(int orderItemId);

    void updateOrderItem(OrderItem orderItem);

    void deleteOrderItem(int orderItemId);

    List<OrderItem> getAllOrderItem();

    // Extra useful method: get all items belonging to one specific order
    // (very commonly needed in real cart/order-summary screens)
    List<OrderItem> getOrderItemsByOrderId(int orderId);

}
