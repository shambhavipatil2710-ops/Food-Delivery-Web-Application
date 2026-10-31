package com.tap.model;

import java.math.BigDecimal;
import java.sql.Timestamp;


public class Order {
	private int OrderId;
    private int UserId;
    private int RestaurantId;
    private Timestamp OrderDate;
    private BigDecimal TotalAmount;
    private String Status;
    private String PaymentMethod;

    public Order() {
    }

    // Excludes orderId (auto-increment) and orderDate (system-generated)
    public Order(int UserId, int RestaurantId, BigDecimal TotalAmount, String Status, String PaymentMethod) {
        this.UserId = UserId;
        this.RestaurantId = RestaurantId;
        this.TotalAmount = TotalAmount;
        this.Status = Status;
        this.PaymentMethod = PaymentMethod;
    }

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int OrderId) {
        this.OrderId = OrderId;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public int getRestaurantId() {
        return RestaurantId;
    }

    public void setRestaurantId(int RestaurantId) {
        this.RestaurantId = RestaurantId;
    }

    public Timestamp getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(Timestamp OrderDate) {
        this.OrderDate = OrderDate;
    }

    public BigDecimal getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(BigDecimal TotalAmount) {
        this.TotalAmount = TotalAmount;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(String PaymentMethod) {
        this.PaymentMethod = PaymentMethod;
    }

    @Override
    public String toString() {
        return "Order [OrderId=" + OrderId + ", UserId=" + UserId + ", RestaurantId=" + RestaurantId
                + ", OrderDate=" + OrderDate + ", TotalAmount=" + TotalAmount + ", Status=" + Status
                + ", PaymentMethod=" + PaymentMethod + "]";
    }

}
