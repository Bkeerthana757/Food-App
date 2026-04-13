<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.foodapp.models.Cart ,com.foodapp.models.CartItem" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>My Cart</title>

    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background-image: url("https://source.unsplash.com/1600x900/?food,delivery");
            background-size: cover;
            background-attachment: fixed;
        }

        .cart-title {
            text-align: center;
            padding: 20px;
            color: #fff;
            background-color:  #FF4500;
        }

        .cart-container {
            max-width: 900px;
            margin: 30px auto;
            padding: 20px;
        }

        .cart-item {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: #ffffff;
            margin-bottom: 20px;
            padding: 15px;
            border-radius: 12px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.3);
        }

        .item-details h3 {
            margin: 0;
            color: #333;
        }

        .item-details p {
            margin: 5px 0;
            color: #555;
        }

        .price {
            font-size: 18px;
            font-weight: bold;
            color: #e63946;
        }

        .quantity-controls {
            display: flex;
            align-items: center;
            gap: 10px;
        }

        .quantity-btn {
            padding: 6px 12px;
            font-size: 16px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            background-color: #ff7a00;
            color: white;
        }

        .quantity-btn:disabled {
            background-color: #ccc;
            cursor: not-allowed;
        }

        .remove-btn {
            background-color: red;
            color: white;
            border: none;
            padding: 6px 12px;
            border-radius: 6px;
            cursor: pointer;
        }

        .total {
            text-align: right;
            font-size: 20px;
            font-weight: bold;
            margin-top: 20px;
        }

        .btn {
            padding: 12px 20px;
            background-color: #ff7a00;
            color: white;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            text-decoration: none;
            display: inline-block;
            margin-top: 15px;
        }

        .btn:hover {
            background-color: #e66a00;
        }

        .center {
            text-align: center;
        }
    </style>
</head>

<body>

<h1 class="cart-title">Your Cart</h1>

<div class="cart-container">

<%
    Cart cart = (Cart) session.getAttribute("cart");
    Integer restaurantId = (Integer) session.getAttribute("restaurantId");

    if (cart != null && !cart.getItems().isEmpty()) {
        for (CartItem item : cart.getItems().values()) {
%>

    <div class="cart-item">

        <div class="item-details">
            <h3><%= item.getName() %></h3>
            
        </div>

        <div class="price">₹<%= item.getPrice() %></div>

        <div class="quantity-controls">

            <!-- Increase -->
            <form action="cart" method="post">
                <input type="hidden" name="menuId" value="<%= item.getItemId() %>">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="restaurantId" value="<%= session.getAttribute("restaurantId") %>">
                <input type="hidden" name="quantity" value="<%= item.getQuantity() + 1 %>">
                <button class="quantity-btn" type="submit">+</button>
            </form>

            <strong><%= item.getQuantity() %></strong>

            <!-- Decrease -->
            <form action="cart" method="post">
                <input type="hidden" name="menuId" value="<%= item.getItemId() %>">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="restaurantId" value="<%= session.getAttribute("restaurantId")  %>">
                <input type="hidden" name="quantity" value="<%= item.getQuantity() - 1 %>">
                <button class="quantity-btn" type="submit" <%= item.getQuantity() == 1 ? "disabled" : "" %>>-</button>
            </form>

            <!-- Remove -->
            <form action="cart" method="post">
                <input type="hidden" name="menuId" value="<%= item.getItemId() %>">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="restaurantId" value="<%= session.getAttribute("restaurantId") %>">
                <button class="remove-btn">Remove</button>
                
            </form>

        </div>
        <p>Total: ₹<%= item.getTotalPrice() %></p>
    </div>

<%
        }
%>

    <div class="total">
        Grand Total: ₹<%= cart.getToatlPrice() %>
    </div>

    <div class="center">
        <a href="menu?restaurantId=<%= session.getAttribute("restaurantId") %>" class="btn">Add More Items</a>
    </div>

    <div class="center">
        <form action="checkout.jsp" method="post">
        <input type="hidden" name="restaurantId" value="<%= session.getAttribute("restaurantId") %>">
            <input class="btn" type="submit" value="Proceed to Checkout">
        </form>
    </div>

<%
    } else {
%>

    <p class="center">Your Cart is Empty.</p>
    <div class="center">
        <a href="menu?restaurantId=<%= session.getAttribute("restaurantId") %>" class="btn">Add Items</a>
    </div>

<%
    }
%>

</div>

</body>
</html>
    