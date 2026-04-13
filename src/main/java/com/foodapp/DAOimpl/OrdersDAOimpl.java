package com.foodapp.DAOimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.models.Orders;
import com.foodapp.util.DBconnection;
import com.tap.foodDAO.OrdersDAO;

public class OrdersDAOimpl implements  OrdersDAO{
	
	private static final String INSERT = "INSERT into `orders`(`orderId`,`orderDate`,`restaurantId`,`userId`,`totalAmount`,`paymentMethod`,`status`,`address`,`orderIteams`) values(?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE= "UPDATE `orders` SET `ordreDate`=? ,`restaurantId`=? ,`userId`=? ,`totalAmount`=? ,`paymentMethod`=?, `status`=?,`address`=?,`orderIteams`=?,WHERE `orderid`";
	private static final String GET_USER_BY_ID = "SELECT * from `orders`";

	@Override
	public List<Orders>getAllOrders() {
		
        ArrayList<Orders> orderlist = new ArrayList<Orders>();

		try (Connection connection = DBconnection.getConnection();
				   PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_ID );)
		{
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt("orderid");
				Timestamp orderDate = resultSet.getTimestamp("orderDate");
				int restaurantId = resultSet.getInt("restaurantId");
				int userId = resultSet.getInt("userId");
				double totalAmount = resultSet.getDouble("totalAmount");
				String paymentMethod =resultSet.getString("paymentMethod");
				String status =resultSet.getString("status");
				String address =resultSet.getString("address");


				Orders o = new Orders(id,orderDate,restaurantId,userId,totalAmount,paymentMethod,status,address);
				orderlist.add(o);
			}
			
		    
		    
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return orderlist;
	}

	@Override
	public Orders getOrdersByid(int orderid) {
		Orders o = null;

		try (Connection connection = DBconnection.getConnection();
				   PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_ID );)
		{
			preparedStatement.setInt(1,orderid);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt("orderid");
				Timestamp orderDate = resultSet.getTimestamp("orderDate");
				int restaurantId = resultSet.getInt("restaurantId");
				int userId = resultSet.getInt("userId");
				double totalAmount = resultSet.getDouble("totalAmount");
				String paymentMethod =resultSet.getString("paymentMethod");
				String status =resultSet.getString("status");
				String address =resultSet.getString("address");


				

				 
				 o = new Orders(id,orderDate,restaurantId,userId,totalAmount,paymentMethod,status,address);

			}
			
		    
		    
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return o;
	
	}

	@Override
	public void addOrders(Orders o) {
		
		try (Connection connection = DBconnection.getConnection();
				   PreparedStatement preparedStatement = connection.prepareStatement(INSERT);)
		{
			
			
		    
		    preparedStatement.setInt(1,o.getOrderId());
		    preparedStatement.setTimestamp(2,o.getOrderDate());
		    preparedStatement.setInt(3,o.getRestaurantId());
		    preparedStatement.setInt(4,o.getUserId());
		    preparedStatement.setDouble(5,o.getTotalAmount());
		    preparedStatement.setString(6,o.getPaymentMethod());
		    preparedStatement.setString(7,o.getStatus());
		    preparedStatement.setString(8,o.getAddress());




           int i =  preparedStatement.executeUpdate();
           System.out.println(i);
   
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateOrders(Orders o) {
		try (Connection connection = DBconnection.getConnection();
		   PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);)
{
			
			preparedStatement.setInt(1, o.getOrderId());
			preparedStatement.setTimestamp(2, o.getOrderDate());
			preparedStatement.setInt(3, o.getRestaurantId());
			preparedStatement.setInt(4, o.getUserId());
			preparedStatement.setDouble(5, o.getTotalAmount());
			preparedStatement.setString(6, o.getPaymentMethod());
		    preparedStatement.setString(7, o.getStatus());
		    preparedStatement.setString(8, o.getAddress());



			
			int i = preparedStatement.executeUpdate();
			
			System.out.println(i);

       } catch (SQLException e) {
	      e.printStackTrace();
         }
	}

	@Override
	public void deleteOrders(int orderid) {
		// TODO Auto-generated method stub
		
		
	}

	

}
