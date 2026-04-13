package com.foodapp.DAOimpl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.models.Restaurant;
import com.foodapp.util.DBconnection;
import com.tap.foodDAO.RestaurantDAO;

public class RestaurantDAOimpl implements RestaurantDAO{
	private static final String INSERT = "INSERT into `restaurant`(`restaurantId`,`reastaurantname`,`address`,`rating`,`cuisine`,`deliveryTime`,`isActive`,`imageUrl`,`adminUserid`) values(?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE= "UPDATE `restaurant` SET `restaurantname`=? ,`address`=? ,`rating`=? ,`cuisine`=? ,`deliveryTime`=?, `isActive`=?,`imageUrl`=?,`adminUserid`=?  WHERE `restaurantid`";
	private static final String GET_USER_BY_ID = "SELECT * from `restaurant`";
	private static final String DELETE ="DELETE FROM restaurant where restaurantid=?";

	@Override
	public List<Restaurant> getAllRestaurant() {
		
        ArrayList<Restaurant> restaurantlist = new ArrayList<Restaurant>();

		try (Connection connection = DBconnection.getConnection();
				   PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_ID );)
		{
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt("restaurantid");
				String restaurantname = resultSet.getString("restaurantname");
				String address = resultSet.getString("address");
				String rating = resultSet.getString("rating");
				String cuisine = resultSet.getString("cuisine");
				int deliveryTime =resultSet.getInt("deliveryTime");
				String isActive =resultSet.getString("isActive");
				String imageUrl =resultSet.getString("imageUrl");
				int adminUserid=resultSet.getInt("adminUserid");

				Restaurant r = new Restaurant(id,restaurantname,address,rating,cuisine,deliveryTime,isActive,imageUrl,adminUserid);
				restaurantlist.add(r);
			}
			
		    
		    
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return restaurantlist;
	}

	@Override
	public Restaurant getRestaurantByid(int restaurantid) {
		Restaurant r = null;

		try (Connection connection = DBconnection.getConnection();
				   PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_ID );)
		{
			preparedStatement.setInt(1, restaurantid);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt("restaurantid");
				String restaurantname = resultSet.getString("restaurantname");
				String address = resultSet.getString("address");
				String rating = resultSet.getString("rating");
				String cuisine = resultSet.getString("cuisine");
				int deliveryTime =resultSet.getInt("deliveryTime");
				String isActive =resultSet.getString("isActive");
				String imageUrl =resultSet.getString("imageUrl");
				int adminUserid =resultSet.getInt("adminUserid");

				

				 r = new Restaurant(id,restaurantname,address,rating,cuisine,deliveryTime,isActive,imageUrl,adminUserid);

			}
			
		    
		    
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	
	}

	@Override
	public void addRestaurant(Restaurant r) {
		
		try (Connection connection = DBconnection.getConnection();
				   PreparedStatement preparedStatement = connection.prepareStatement(INSERT);)
		{
			
			
		    
		    preparedStatement.setInt(1,r.getRestaurantId());
		    preparedStatement.setString(2,r.getRestaurantName());
		    preparedStatement.setString(3,r.getAddress());
		    preparedStatement.setString(4,r.getRating());
		    preparedStatement.setString(5,r.getCuisine());
		    preparedStatement.setInt(6,r.getDeliveryTime());
		    preparedStatement.setString(7,r.getIsActive());
		    preparedStatement.setString(8,r.getImageurl());
		    preparedStatement.setInt(9,r.getAdminUserId());



           int i =  preparedStatement.executeUpdate();
           System.out.println(i);
   
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateRestaurant(Restaurant r) {
		try (Connection connection = DBconnection.getConnection();
		   PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);)
{
			
			preparedStatement.setInt(1, r.getRestaurantId());
			preparedStatement.setString(2, r.getRestaurantName());
			preparedStatement.setString(3, r.getAddress());
			preparedStatement.setString(4, r.getRating());
			preparedStatement.setString(5, r.getCuisine());
			preparedStatement.setInt(6, r.getDeliveryTime());
		    preparedStatement.setString(7, r.getIsActive());
		    preparedStatement.setString(8, r.getImageurl());
		    preparedStatement.setInt(9, r.getAdminUserId());


			
			int i = preparedStatement.executeUpdate();
			
			System.out.println(i);

       } catch (SQLException e) {
	      e.printStackTrace();
         }
	}

	@Override
	public void deleteRestaurant(int restaurantid) {
		// TODO Auto-generated method stub
		
		
	}

	

	

}
