package com.tap.model;

import java.math.BigDecimal;

public class OrderItem {
	private int OrderItemId;
    private int OrderId;
    private int MenuId;
    private int Quantity;
    private BigDecimal ItemTotal;

    public OrderItem() {
    }

    // Excludes orderItemId (auto-increment)
    public OrderItem(int OrderId, int MenuId, int Quantity, BigDecimal ItemTotal) {
        this.OrderId = OrderId;
        this.MenuId = MenuId;
        this.Quantity = Quantity;
        this.ItemTotal = ItemTotal;
    }

    public int getOrderItemId() {
        return OrderItemId;
    }

    public void setOrderItemId(int OrderItemId) {
        this.OrderItemId = OrderItemId;
    }

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int OrderId) {
        this.OrderId = OrderId;
    }

    public int getMenuId() {
        return MenuId;
    }

    public void setMenuId(int MenuId) {
        this.MenuId = MenuId;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public BigDecimal getItemTotal() {
        return ItemTotal;
    }

    public void setItemTotal(BigDecimal ItemTotal) {
        this.ItemTotal = ItemTotal;
    }

    @Override
    public String toString() {
        return "OrderItem [OrderItemId=" + OrderItemId + ", OrderId=" + OrderId + ", MenuId=" + MenuId
                + ", Quantity=" + Quantity + ", ItemTotal=" + ItemTotal + "]";
    }

}
