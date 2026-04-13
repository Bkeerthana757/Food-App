package com.tap.servlet;

import java.io.IOException;

import com.foodapp.DAOimpl.MenuDAOimpl;
import com.tap.foodDAO.MenuDAO;
import com.foodapp.models.Cart;
import com.foodapp.models.CartItem;
import com.foodapp.models.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		
		
		HttpSession session = req.getSession();
		Cart cart =(Cart) session.getAttribute("cart");
		
		
		int newRestaurantId = Integer.parseInt(req.getParameter("restaurantId"));
		
		Integer oldRestaurantObj =(Integer)session.getAttribute("oldRestaurantId");
		
		int oldRestaurantId = (oldRestaurantObj == null)?0:oldRestaurantObj;
		if(cart == null && oldRestaurantId != newRestaurantId)
		{
			 cart = new Cart();
			session.setAttribute("cart", cart);
			session.setAttribute("oldRestaurantId", newRestaurantId);

			session.setAttribute("restaurantId", newRestaurantId);
		}
		
		String action = req.getParameter("action");
		
		if(action.equals("add")) {
			
			addItemToCart(req, cart,newRestaurantId);
			
		}else if(action.equals("update")) {
			updateCart(req,cart);
		}else if(action.equals("delete")) {
			deleteCart(req,cart);
		}
		resp.sendRedirect("Cart.jsp");	
		}

	private void deleteCart(HttpServletRequest req,Cart cart) {
		// TODO Auto-generated method stub
		String menuIdStr = req.getParameter("menuId");
        if (menuIdStr == null) return;
        int menuId = Integer.parseInt(menuIdStr);
        cart.removeItem(menuId);
//		int itemId=Integer.parseInt(req.getParameter("itemId"));
//		cart.removeItem(itemId);
		
	}

	private void updateCart(HttpServletRequest req,Cart cart) {
		// TODO Auto-generated method stub
	//	String itemParam=req.getParameter("itemId");
//		
//		String quantityParam = req.getParameter("quantity");
//		
//		if(itemParam == null || cart == null)return;
//		
//		int itemId = Integer.parseInt(itemParam);
//		
//		int quantity= Integer.parseInt(quantityParam);
		

        String menuIdStr = req.getParameter("menuId");
        String quantityStr = req.getParameter("quantity");

        if (menuIdStr == null || quantityStr == null) return;

        int menuId = Integer.parseInt(menuIdStr);
        int quantity = Integer.parseInt(quantityStr);
		if(quantity <= 0 ) {
			cart.removeItem(menuId);
		}
		else {
		cart.updateItem(menuId, quantity);
		}
		
	}

	private void addItemToCart(HttpServletRequest req, Cart cart,int restaurantId) {
		// TODO Auto-generated method stub
	//	int itemId=Integer.parseInt(req.getParameter("menuId"));
//		int quantity = Integer.parseInt(req.getParameter("quantity"));
        String menuIdStr = req.getParameter("menuId");
        String quantityStr = req.getParameter("quantity");

        if (menuIdStr == null || quantityStr == null) return;

        int menuId = Integer.parseInt(menuIdStr);
        int quantity = Integer.parseInt(quantityStr);
		
		MenuDAO menuDAOImpl = new MenuDAOimpl();
		
		Menu menu=menuDAOImpl.getmenuByid(menuId);
		
		String itemName=menu.getMenuName();
		
		double price = menu.getPrice(); 
		
		CartItem  cartItem = new CartItem(menuId,itemName,quantity,price);
		cart.addItem(cartItem);
		
		
		
		
	}

  }
