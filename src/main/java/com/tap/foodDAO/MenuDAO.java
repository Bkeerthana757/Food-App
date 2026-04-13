package com.tap.foodDAO;

import java.util.List;

import com.foodapp.models.Menu;

public interface MenuDAO {
	 void addMenu(Menu m);
	 void updateMenu(Menu m);
	 void deleteMenu(int menuId);
	 List<Menu> getAllMenu(int restaurantId);
	 Menu getmenuByid(int menuId);



}
