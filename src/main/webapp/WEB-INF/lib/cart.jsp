<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>FoodExpress | Restaurants</title>

    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }

        body {
            background-color: #f2f2f2;
        }

        /* NAVBAR */
        .navbar {
            background-color: #fc8019;
            padding: 15px 40px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            color: #fff;
        }

        .navbar h2 {
            font-size: 24px;
        }

        .navbar ul {
            list-style: none;
            display: flex;
            gap: 25px;
        }

        .navbar ul li {
            font-weight: bold;
            cursor: pointer;
        }

        /* MAIN CONTAINER */
        .container {
            padding: 40px;
        }

        .restaurant-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(260px, 1fr));
            gap: 25px;
        }

        /* CARD */
        .card {
            background-color: #ffffff;
            border-radius: 12px;
            overflow: hidden;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
            transition: transform 0.3s;
        }

        .card:hover {
            transform: translateY(-6px);
        }

        .card img {
            width: 100%;
            height: 170px;
            object-fit: cover;
        }

        .card-body {
            padding: 15px;
        }

        .card-body h3 {
            font-size: 18px;
            margin-bottom: 6px;
        }

        .desc {
            font-size: 14px;
            color: #666;
            margin-bottom: 10px;
        }

        .card-info {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .rating {
            background-color: #48c479;
            color: #fff;
            padding: 4px 8px;
            border-radius: 6px;
            font-size: 14px;
            font-weight: bold;
        }

        .eta {
            font-size: 14px;
            font-weight: bold;
            color: #333;
        }
    </style>
</head>

<body>

<!-- NAVBAR -->
<div class="navbar">
    <h2>FoodExpress</h2>
    <ul>
        <li>Home</li>
        <li>Restaurants</li>
        <li>Offers</li>
        <li>Help</li>
        <li>Login</li>
    </ul>
</div>

<!-- RESTAURANT LIST -->
<div class="container">
    <div class="restaurant-grid">

        <!-- 1 -->
        <div class="card">
            <img src="https://source.unsplash.com/400x300/?biryani">
            <div class="card-body">
                <h3>Paradise Biryani</h3>
                <p class="desc">Authentic Hyderabadi biryani</p>
                <div class="card-info">
                    <span class="rating">4.5 ★</span>
                    <span class="eta">30 mins</span>
                </div>
            </div>
        </div>

        
    </div>
</div>

</body>
</html>
    