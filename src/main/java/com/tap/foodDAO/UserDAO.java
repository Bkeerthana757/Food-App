package com.tap.foodDAO;

import java.util.List;

import com.foodapp.models.User;

public interface UserDAO {
	List<User>getAllUsers();
	 User getUserByid(int userid);
	 User getUserByEmailId(String email);

	 void addUser(User u);
	 void updateUser(User u);
	 void deleteUser(int userid);
	 

}
