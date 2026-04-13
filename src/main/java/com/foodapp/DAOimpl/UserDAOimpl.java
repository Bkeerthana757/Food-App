package com.foodapp.DAOimpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import com.foodapp.models.User;
import com.foodapp.util.DBconnection;
import com.tap.foodDAO.UserDAO;




public class UserDAOimpl implements UserDAO {



	private  final String INSERT = "INSERT into `user`(`userId`,`name`,`username`,`password`,`email`,`phonenumber`,`address`,`role`,`created_date`,`last_login_date`) values(?,?,?,?,?,?,?,?,?)";
	private final String UPDATE= "UPDATE `user` SET `name`=? ,`username`=? ,`password`=? ,`email`=? ,`phonenumber`=? ,`address`=?, `role`=?  WHERE `userid`";
	private  final String GET_USER_BY_ID = "SELECT * from `user` where userId=?";
	private  final String GET_USER_BY_EMAIL = "SELECT * from `user` where email=?";

	

	@Override
	public List<User> getAllUsers() {
		
        ArrayList<User> userlist=new ArrayList<User>();

		try (Connection connection = DBconnection.getConnection();
				   PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_ID );)
		{
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt("userid");
				String name = resultSet.getString("name");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				String email = resultSet.getString("email");
				String phonenumber =resultSet.getString("phonenumber");
				String address =resultSet.getString("address");
				String role =resultSet.getString("role");
				

				User user = new User(id,name,username,password,email,phonenumber,address,role);
				userlist.add(user);
			}
			
		    
		    
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userlist;
	}

	@Override
	public User getUserByid(int userid) {
		User u = null;

		try (Connection connection = DBconnection.getConnection();
				   PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_ID );)
		{
			preparedStatement.setInt(1, userid);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt("userid");
				String name = resultSet.getString("name");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				String email = resultSet.getString("email");
				String phonenumber =resultSet.getString("phonenumber");
				String address =resultSet.getString("address");
				String role =resultSet.getString("role");
				

				 u = new User(id,name,username,password,email,phonenumber,address,role);

			}
			
		    
		    
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	
	}

	@Override
	public void addUser(User u) {
		
		try (Connection connection = DBconnection.getConnection();
				   PreparedStatement preparedStatement = connection.prepareStatement(INSERT);)
		{
			
			
		    
		    preparedStatement.setString(1,u.getName());
		    preparedStatement.setString(2,u.getUsername());
		    preparedStatement.setString(3,u.getPassword());
		    preparedStatement.setString(4,u.getEmail());
		    preparedStatement.setString(5,u.getPhonenumber());
		    preparedStatement.setString(6,u.getAddress());
		    preparedStatement.setString(7,u.getRole());
		    preparedStatement.setTimestamp(8,new Timestamp(System.currentTimeMillis()));
		    preparedStatement.setTimestamp(9,new Timestamp(System.currentTimeMillis()));

           int i =  preparedStatement.executeUpdate();
           System.out.println(i);
   
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateUser(User u) {
		try (Connection connection = DBconnection.getConnection();
		   PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);)
{
			
			preparedStatement.setString(1, u.getName());
			preparedStatement.setString(2, u.getUsername());
			preparedStatement.setString(3, u.getPassword());
			preparedStatement.setString(4, u.getEmail());
			preparedStatement.setString(5, u.getAddress());
			preparedStatement.setString(6, u.getPhonenumber());
			preparedStatement.setString(7, u.getRole());
			
			int i = preparedStatement.executeUpdate();
			
			System.out.println(i);

} catch (SQLException e) {
	e.printStackTrace();
}
		
	}

	@Override
	public void deleteUser(int userid) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public User getUserByEmailId(String email)
	{
		User user=null;
		try(Connection connection=DBconnection.getConnection();
				PreparedStatement statement=connection.prepareStatement(GET_USER_BY_EMAIL);){
			
			statement.setString(1,email);
			ResultSet res=statement.executeQuery();
			
			while(res.next()) {
				
				int id=res.getInt("userid");
				String name=res.getString("username");
				String mail=res.getString("email");
				String phonenumber=res.getString("phonenumber");
				String password=res.getString("password");
				String address=res.getString("address");
				String role=res.getString("role");
				
				user= new User(id,name,password,mail,phonenumber,address,role);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
