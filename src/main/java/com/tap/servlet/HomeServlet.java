package com.tap.servlet;


import java.io.IOException;
import java.util.List;

import com.foodapp.DAOimpl.RestaurantDAOimpl;
import com.foodapp.models.Restaurant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	

	@Override
	protected void service(HttpServletRequest req ,HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("hi from HomeServlet");	
		
		
		RestaurantDAOimpl daoimpl = new RestaurantDAOimpl();
		List<Restaurant> allRestaurant = daoimpl.getAllRestaurant();
		for(Restaurant restaurant : allRestaurant) {
			System.out.println(restaurant);
			
		}
		
		req.setAttribute("allRestaurant", allRestaurant);
		
		RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
		rd.forward(req, resp);
		
		
	}

}
