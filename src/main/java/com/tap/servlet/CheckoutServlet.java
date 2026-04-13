package com.tap.servlet;


import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import com.foodapp.DAOimpl.OrderItemDAOimpl;
import com.foodapp.DAOimpl.OrdersDAOimpl;
import com.foodapp.models.Cart;
import com.foodapp.models.CartItem;
import com.foodapp.models.OrderItem;
import com.foodapp.models.Orders;
import com.foodapp.models.User;
import com.tap.foodDAO.OrdersDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet{
	
	private static final int quantity = 0;
	private static final String name = null;
	private OrdersDAO ordersDAO;
	private OrderItemDAOimpl orderItemsDAOImpl;
	
	@Override
	public void init(){
		 ordersDAO=new OrdersDAOimpl();
		 orderItemsDAOImpl=new OrderItemDAOimpl();
	}
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		
		HttpSession session=req.getSession();
		Cart cart=(Cart)session.getAttribute("cart");
		int restaurantId=(int)session.getAttribute("oldRestaurantId");
		
		User user= (User)session.getAttribute("user");
		
		if(user==null){
			resp.sendRedirect("login.jsp");
			return;
		}
		if(cart != null && user != null && !cart.getItems().isEmpty()) {
			String address=req.getParameter("address");
			String paymentMethod = req.getParameter("paymentMethod");
			
			Orders orders = new Orders();
			
			orders.setUserId(user.getUserid());
			orders.setRestaurantId(restaurantId);
			orders.setOrderDate(new Timestamp(System.currentTimeMillis()));
			orders.setAddress(address);
			orders.setPaymentMethod(paymentMethod);
			orders.setStatus("Pending");
			
			double totalAmount= 0;
			for(CartItem cartItem :cart.getItems().values()) {
				double totalPrice =cartItem.getPrice()*cartItem.getQuantity();
				totalAmount += totalPrice;
				
			}
			orders.setTotalAmount(totalAmount);
			
			//OrdersDAOImpl orderdaoimpl=new OrdersDAOImpl();
			int orderId =ordersDAO.addOrders(orders);
			
			//OrderItem orderItem=new OrderItem();
			for( CartItem item :cart.getItems().values()) {
				
				OrderItem orderItem = new OrderItem(orderId,item.getItemId(),item.getName(), item.getTotalPrice(),item.getQuantity());
				orderItemsDAOImpl.addOrderItem(orderItem);
//			  	int itemId=item.getItemId();
//              int quantity = item.getQuantity();
//              double totalPrice = item.getTotalPrice();
//              
//              
//              orderItem.setOrderId(orderId);
//              orderItem.setMenuId(itemId);
//              orderItem.setQuantity(quantity);
//              orderItem.setTotalPrice(totalPrice);
			}
			
			
//			OrderItemsDAOImpl orderitemdaoimpl = new OrderItemsDAOImpl();
//			
//			orderitemdaoimpl.addOrderItems(orderItem);
			
			session.removeAttribute("cart");
			session.setAttribute("order", orders);
			resp.sendRedirect("orderConfirm.jsp");
		}
		
		else {
			resp.sendRedirect("cart.jsp");
		}
		
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}