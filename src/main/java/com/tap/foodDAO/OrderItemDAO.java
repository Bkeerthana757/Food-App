package com.tap.foodDAO;

import java.util.List;


import com.foodapp.models.OrderItem;


public interface OrderItemDAO {
	 OrderItem getOrderItemByid(int orderitemid);
	 void addOrderItem(OrderItem o);
	 void updateOrderItem(OrderItem o);
	 void deleteOrderItem(int orderitemid);
	 List<OrderItem> getAllOrderItem();




}
