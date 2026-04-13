package com.foodapp.DAOimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.models.Menu;
import com.foodapp.util.DBconnection;
import com.tap.foodDAO.MenuDAO;

public class MenuDAOimpl implements MenuDAO{
	
	private static final String INSERT = "INSERT into `menu`(`menuId`,`menuname`,`price`,`isAvailable`,`description`,`imageUrl`,`retaurantId`) values(?,?,?,?,?,?,?)";
	private static final String UPDATE= "UPDATE `menu` SET `menuname`=? ,`price`=? ,`isAvailable`=? ,`description`=? ,`imageUrl`=?, `restaurantId`=?,  WHERE `menuid`";
	private static final String GET_USER_BY_ID = "SELECT * from `menu` where menuId=?";
	private static final String GET_MENU = "SELECT * FROM menu where restaurantId=?";

	@Override
	public List<Menu> getAllMenu(int restaurantId) {
		
        ArrayList<Menu> menulist = new ArrayList<Menu>();

		try (Connection connection = DBconnection.getConnection();
				   PreparedStatement preparedStatement = connection.prepareStatement(GET_MENU);)
		{
			preparedStatement.setInt(1, restaurantId);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt("menuId");
				String menuname = resultSet.getString("menuname");
				int price = resultSet.getInt("price");
				String isAvailable = resultSet.getString("isAvailable");
				String description = resultSet.getString("description");
				String imageUrl =resultSet.getString("imageUrl");
				int restaurantid =resultSet.getInt("restaurantId");

				Menu m = new Menu(id,menuname,price,isAvailable,description,imageUrl,restaurantid);
				menulist.add(m);
			}
			
		    
		    
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return menulist;
	}

	@Override
	public Menu getmenuByid(int menuId) {
		Menu m = null;

		try (Connection connection = DBconnection.getConnection();
				   PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_ID );)
		{
			preparedStatement.setInt(1,menuId);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt("menuId");
				String menuname = resultSet.getString("menuname");
				int price = resultSet.getInt("price");
				String isAvailable = resultSet.getString("isAvailable");
				String description = resultSet.getString("description");
				String imageUrl =resultSet.getString("imageUrl");
				int restaurantId =resultSet.getInt("restaurantId");

				

				 m = new Menu(id,menuname,price,isAvailable,description,imageUrl,restaurantId);

			}
			
		    
		    
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	
	}

	@Override
	public void addMenu(Menu m) {
		
		try (Connection connection = DBconnection.getConnection();
				   PreparedStatement preparedStatement = connection.prepareStatement(INSERT);)
		{
			
			
		    
		    preparedStatement.setInt(1,m.getMenuId());
		    preparedStatement.setString(2,m.getMenuName());
		    preparedStatement.setInt(3,m.getPrice());
		    preparedStatement.setString(4,m.getIsAvailable());
		    preparedStatement.setString(5,m.getDescription());
		    preparedStatement.setString(6,m.getImageUrl());
		    preparedStatement.setInt(7,m.getRestaurantId());



           int i =  preparedStatement.executeUpdate();
           System.out.println(i);
   
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateMenu(Menu m) {
		try (Connection connection = DBconnection.getConnection();
		   PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);)
{
			
			preparedStatement.setInt(1, m.getMenuId());
			preparedStatement.setString(2, m.getMenuName());
			preparedStatement.setInt(3, m.getPrice());
			preparedStatement.setString(4, m.getIsAvailable());
			preparedStatement.setString(5, m.getDescription());
			preparedStatement.setString(6, m.getImageUrl());
		    preparedStatement.setInt(7, m.getRestaurantId());


			
			int i = preparedStatement.executeUpdate();
			
			System.out.println(i);

       } catch (SQLException e) {
	      e.printStackTrace();
         }
	}

	@Override
	public void deleteMenu(int menuId) {
		// TODO Auto-generated method stub
		
		
	}



	
	
}

   