package com.tap.servlet;

import java.io.IOException;
import java.util.List;

import com.foodapp.DAOimpl.MenuDAOimpl;
import com.foodapp.models.Menu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/menu")
public class MenuServlet extends HttpServlet{
	
	@Override
	protected void service (HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		
		System.out.println("Hi from menu servlet");
		MenuDAOimpl daoImpl = new MenuDAOimpl();
		int restaurantId = Integer.parseInt(req.getParameter("restaurantId"));
		
		List<Menu> allMenusByRestaurant = daoImpl.getAllMenu(restaurantId);
		
		for(Menu menu:allMenusByRestaurant) {
			System.out.println(menu);
		}
		req.setAttribute("allMenusByRestaurant", allMenusByRestaurant);
		
		RequestDispatcher rd = req.getRequestDispatcher("menu.jsp");
		rd.forward(req, resp);
		
		
		
		
	}		
		
	

}

