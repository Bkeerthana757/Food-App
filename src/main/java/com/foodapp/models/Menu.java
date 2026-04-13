package com.foodapp.models;

public class Menu {
	private int menuId;
	private String menuName;
	private int price;
	private String isAvailable;
	private String description;
	private String imageUrl;
	private int restaurantId;
	public Menu() {
		super();
	}
	public Menu(int menuId, String menuName, int price, String isAvailable, String description, String imageUrl,
			int restaurantId) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.price = price;
		this.isAvailable = isAvailable;
		this.description = description;
		this.imageUrl = imageUrl;
		this.restaurantId = restaurantId;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", menuName=" + menuName + ", price=" + price + ", isAvailable=" + isAvailable
				+ ", description=" + description + ", imageUrl=" + imageUrl + ", restaurantId=" + restaurantId + "]";
	}
	
        
}
