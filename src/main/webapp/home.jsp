<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import = "com.foodapp.models.Restaurant,java.util.List" %>

    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Food Delivery - Restaurants</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }

        body {
            background-color: #f5f5f5;
        }

        /* Navbar */
        .navbar {
            background-color: #ff4d4d;
            color: white;
            padding: 15px 40px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .navbar h1 {
            font-size: 24px;
        }

        .navbar ul {
            list-style: none;
            display: flex;
            gap: 25px;
        }

        .navbar ul li {
            cursor: pointer;
            font-size: 16px;
        }

        /* Container */
        .container {
            padding: 40px;
        }

        .restaurant-grid {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(260px, 1fr));
            gap: 25px;
        }

        /* Card */
        .card {
            background-color: #fff;
            border-radius: 12px;
            overflow: hidden;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
            transition: transform 0.3s;
        }

        .card:hover {
            transform: scale(1.03);
        }

        .card img {
            width: 100%;
            height: 170px;
            object-fit: cover;
        }

        .card-content {
            padding: 15px;
        }

        .card-content h3 {
            font-size: 18px;
            margin-bottom: 5px;
        }

        .card-content p {
            font-size: 14px;
            color: #666;
            margin-bottom: 10px;
        }

        .card-info {
            display: flex;
            justify-content: space-between;
            align-items: center;
            font-size: 14px;
        }

        .rating {
            background-color: #48c479;
            color: white;
            padding: 4px 8px;
            border-radius: 5px;
            font-weight: bold;
        }

        .eta {
            color: #333;
            font-weight: bold;
        }

        footer {
            text-align: center;
            padding: 20px;
            background-color: #222;
            color: #ccc;
            margin-top: 40px;
        }
    </style>
</head>
<body>

    <!-- Navbar -->
    <div class="navbar">
        <h1>FoodExpress</h1>
        <ul>
            <li>Home</li>
            <li>Restaurants</li>
            <li>Offers</li>
            <li>Help</li>
            <li>Login</li>
        </ul>
    </div>

    <!-- Restaurant Cards -->
    <div class="container">
        <div class="restaurant-grid">
        
        
        
        <%
        
         List<Restaurant> allRestaurant= (List<Restaurant>)request.getAttribute("allRestaurant");
        
        for(Restaurant restaurant : allRestaurant){
        	%>
        	<!-- Card 1 -->
        	<a href="menu?restaurantId=<%=restaurant.getRestaurantId()%>">
            <div class="card">
                <img src="<%= restaurant.getImageurl() %>" alt="Restaurant">
                <div class="card-content">
                    <h3><%=restaurant.getRestaurantName() %></h3>
                    <p><%=restaurant.getCuisine() %></p>
                    <div class="card-info">
                        <span>★ <%= restaurant.getRating() %></span>
                        <span>ETA:<%=restaurant.getDeliveryTime() %></span>
                    </div>
                </div>
            </div>
        	
        	</a>
       <%}
        
        %>

        </div>
       </div>   

            

</body>
</html>
    