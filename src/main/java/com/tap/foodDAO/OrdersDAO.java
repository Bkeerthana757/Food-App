package com.tap.foodDAO;

import java.util.List;

import com.foodapp.models.Menu;
import com.foodapp.models.Orders;

public interface OrdersDAO {
	List<Orders>getAll();
	 Orders getOrdersByid(int ordersid);
	 int addOrders(Orders o);
	 void updateOrders(Orders o);
	 void deleteOrders(int ordersid);
	 List<Orders> getAllOrders();



}
