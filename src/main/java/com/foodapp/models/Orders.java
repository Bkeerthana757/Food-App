package com.foodapp.models;

import java.sql.Timestamp;
import java.util.List;


public class Orders {
	private int orderId;
	private Timestamp orderDate;
	private int restaurantId;
	private int userId;
	private double totalAmount;
	private String paymentMethod;
	private String Status;
	private String address;
	private List<OrderItem> orderItems;
	public Orders() {
		super();
	}
	public Orders(int orderId, Timestamp orderDate, int restaurantId, int userId, double totalAmount,
			String paymentMethod, String status, String address) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.restaurantId = restaurantId;
		this.userId = userId;
		this.totalAmount = totalAmount;
		this.paymentMethod = paymentMethod;
		this.Status = status;
		this.address = address;
	
	}
	public Orders(int orderId, Timestamp orderDate, int restaurantId, int userId, double totalAmount,
			String paymentMethod, String status, String address, List<OrderItem> orderItems) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.restaurantId = restaurantId;
		this.userId = userId;
		this.totalAmount = totalAmount;
		this.paymentMethod = paymentMethod;
		Status = status;
		this.address = address;
		this.orderItems = orderItems;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Timestamp getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderDate=" + orderDate + ", restaurantId=" + restaurantId
				+ ", userId=" + userId + ", totalAmount=" + totalAmount + ", paymentMethod=" + paymentMethod
				+ ", Status=" + Status + ", address=" + address + "]";
	}
	
	
	

}
