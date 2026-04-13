package com.foodapp.DAOimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.models.OrderItem;
import com.foodapp.util.DBconnection;
import com.tap.foodDAO.OrderItemDAO;

  public class OrderItemDAOimpl implements OrderItemDAO{
	
	private static final String INSERT = "INSERT into `orderItem`(`orderItemId`,`orderId`,`itemName`,`menuId`,`totalPrice`,`quantity`) values(?,?,?,?,?,?)";
	private static final String UPDATE= "UPDATE `orderItem` SET `orderItemId`=? ,`orderId`=? ,`itemName`=? ,`menuId`=? ,`totalPrice`=?, `quantity`=?,WHERE `orderItemid`";
	private static final String GET_USER_BY_ID = "SELECT * from `orderItem`";
	private static final String DELETE = "DELETE FROM orderitem  WHERE orderItemId=?";

	@Override
	public List<OrderItem> getAllOrderItem() {
		
        ArrayList<OrderItem> orderItemlist = new ArrayList<OrderItem>();

		try (Connection connection = DBconnection.getConnection();
				   PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_ID );)
		{
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt("orderItemid");
				int orderId = resultSet.getInt("orderId");
				String itemName = resultSet.getString("itemName");
				int menuId = resultSet.getInt("menuId");
				double totalPrice = resultSet.getDouble("totalPrice");
				int quantity =resultSet.getInt("quantity");


				OrderItem orderItem = new OrderItem(id,orderId,itemName,menuId,totalPrice,quantity);
				orderItemlist.add(orderItem);
			}
			
		    
		    
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return orderItemlist;
	}

	@Override
	public OrderItem getOrderItemByid(int orderItemid) {
		OrderItem o = null;

		try (Connection connection = DBconnection.getConnection();
				   PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_ID );)
		{
			preparedStatement.setInt(1,o.getOrderItemId());
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt("orderItemid");
				int orderId = resultSet.getInt("orderId");
				String itemName = resultSet.getString("itemName");
				int menuId = resultSet.getInt("menuId");
				double totalPrice = resultSet.getDouble("totalPrice");
				int quantity =resultSet.getInt("quantity");


				

				 
				 o = new OrderItem(id,orderId,itemName,menuId,totalPrice,quantity);

			}
			
		    
		    
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 	o;
	
	}

	@Override
	public void addOrderItem(OrderItem o) {
		
		try (Connection connection = DBconnection.getConnection();
				   PreparedStatement preparedStatement = connection.prepareStatement(INSERT);)
		{
			
			
		    
		    preparedStatement.setInt(1,o.getOrderItemId());
		    preparedStatement.setInt(2,o.getOrderId());
		    preparedStatement.setString(3,o.getItemName());
		    preparedStatement.setInt(4,o.getMenuId());
		    preparedStatement.setDouble(5,o.getTotalPrice());
		    preparedStatement.setInt(6,o.getQuantity());




           int i =  preparedStatement.executeUpdate();
           System.out.println(i);
   
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateOrderItem(OrderItem o) {
		try (Connection connection = DBconnection.getConnection();
		   PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);)
{
			
			preparedStatement.setInt(1, o.getOrderItemId());
			preparedStatement.setInt(2, o.getOrderId());
			preparedStatement.setString(3, o.getItemName());
			preparedStatement.setInt(4, o.getMenuId());
			preparedStatement.setDouble(5, o.getTotalPrice());
			preparedStatement.setInt(6, o.getQuantity());




			
			int i = preparedStatement.executeUpdate();
			
			System.out.println(i);

       } catch (SQLException e) {
	      e.printStackTrace();
         }
	}

	@Override
	public void deleteOrderItem(int orderItemId) {
		// TODO Auto-generated method stub
		try(Connection connection = DBconnection.getConnection();
				PreparedStatement pstmt=connection.prepareStatement(DELETE);){
			
			pstmt.setInt(1, orderItemId);
			int res = pstmt.executeUpdate();
			System.out.println(res);
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
		
		
	

	
}
