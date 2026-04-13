package com.foodapp.models;

public class OrderItem {
	private int orderItemId;
	private int orderId;
	private String itemName;
	private int menuId;
	private double totalPrice;
	private int quantity;
	public OrderItem() {
		super();
	}
	public OrderItem(int orderItemId, int orderId, String itemName, int menuId,double totalPrice, int quantity) {
		super();
		this.orderItemId = orderItemId;
		this.orderId = orderId;
		this.itemName = itemName;
		this.menuId = menuId;
		this.totalPrice = totalPrice;
		this.quantity = quantity;
	}
	public OrderItem(int orderId,int menuId,String itemName, double totalPrice, int quantity) {
		// TODO Auto-generated constructor stub
		super();
		this.orderId = orderId;
		this.menuId = menuId;
		this.itemName = itemName;
		this.totalPrice = totalPrice;
		this.quantity = quantity;
	}
	public int getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "OrderItemId [orderItemId=" + orderItemId + ", orderId=" + orderId + ", itemName=" + itemName
				+ ", menuId=" + menuId + ", totalPrice=" + totalPrice + ", quantity=" + quantity + "]";
	}
	

}
