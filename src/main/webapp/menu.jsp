<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <%@ page import = "com.foodapp.models.Menu,java.util.List" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Paradise Biryani | Menu</title>

<style>
*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family: 'Segoe UI', sans-serif;
}

body{
    background:#f8f8f8;
}

/* -------- NAVBAR -------- */
.navbar{
    background:#fc8019;
    color:#fff;
    padding:16px 40px;
    font-size:24px;
    font-weight:bold;
}

/* -------- RESTAURANT HEADER -------- */
.restaurant-header{
    background:#fff;
    margin:30px auto;
    width:90%;
    border-radius:14px;
    display:flex;
    padding:25px;
    gap:25px;
    box-shadow:0 6px 16px rgba(0,0,0,0.1);
}

.restaurant-header img{
    width:200px;
    height:140px;
    object-fit:cover;
    border-radius:12px;
}

.restaurant-info h2{
    font-size:26px;
    margin-bottom:6px;
}

.restaurant-info p{
    color:#666;
    margin-bottom:10px;
}

.meta{
    display:flex;
    gap:20px;
    font-weight:bold;
}

.rating-badge{
    background:#48c479;
    color:#fff;
    padding:6px 10px;
    border-radius:6px;
}

/* -------- MENU SECTION -------- */
.menu-section{
    width:90%;
    margin:auto;
}

.menu-title{
    font-size:28px;
    margin:30px 0 20px;
}

/* -------- MENU GRID -------- */
.menu-grid{
    display:grid;
    grid-template-columns:repeat(auto-fit,minmax(300px,1fr));
    gap:25px;
}

/* -------- MENU CARD -------- */
.menu-card{
    background:#fff;
    border-radius:16px;
    box-shadow:0 6px 18px rgba(0,0,0,0.12);
    overflow:hidden;
    transition:0.3s;
}

.menu-card:hover{
    transform:translateY(-6px);
}

.menu-card img{
    width:100%;
    height:190px;
    object-fit:cover;
}

/* -------- MENU CONTENT -------- */
.menu-content{
    padding:18px;
}

.menu-content h3{
    font-size:20px;
    margin-bottom:6px;
}

.menu-content p{
    color:#666;
    font-size:14px;
    margin-bottom:12px;
}

.menu-bottom{
    display:flex;
    justify-content:space-between;
    align-items:center;
}

.price{
    font-size:18px;
    font-weight:bold;
}

.item-rating{
    background:#eee;
    padding:5px 10px;
    border-radius:6px;
    font-weight:bold;
}

/* -------- FOOTER SPACE -------- */
.spacer{
    height:40px;
}
</style>
</head>

<body>

<!-- NAVBAR -->
<div class="navbar">FoodExpress</div>


<%
  List<Menu> menus = (List<Menu>)request.getAttribute("allMenusByRestaurant");
  for(Menu menu:menus){
	  
  




%>


<!-- MENU -->
<div class="menu-section">
    <h2 class="menu-title">Recommended</h2>

    <div class="menu-grid">

        <!-- ITEM 1 -->
        <div class="menu-card">
            <img src="<%= menu.getImageUrl() %>" alt="Menu Item">
            <div class="menu-content">
                <h3><%= menu.getMenuName() %></h3>
                <p class="description"><%= menu.getDescription() %></p>
                <div class="menu-bottom">
                    <span class="price"><%= menu.getPrice() %></span>
                </div>
            </div>
        </div>
        
        
        <form action="cart">
        <input type="hidden" name="menuId" value="<%= menu.getMenuId() %>">
        <input type="hidden" name="quantity" value="1">
        <input type="hidden" name="restaurantId" value="<%= menu.getRestaurantId() %>">
        <input type="hidden" name="action" value="add">
        
        
        <input type="submit" value="AddToCart">
        
        
        
        </form>
    
    </div>
</div>

<div class="spacer"></div>
 <%} %>

</body>
</html>
    