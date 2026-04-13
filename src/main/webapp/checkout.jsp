<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Checkout</title>
    <style>
    body {
    margin: 0;
    font-family: Arial, sans-serif;
    background-image: url("https://source.unsplash.com/1600x900/?food,checkout");
    background-size: cover;
    background-attachment: fixed;
}

.checkout-title {
    text-align: center;
    padding: 20px;
    color: #fff;
    background-color:  #ff7a00;
    border-radius: 10px;
}

.checkout-container {
    max-width: 600px;
    margin: 40px auto;
    background-color: rgba(255, 255, 255, 0.95);
    padding: 25px;
    border-radius: 12px;
    box-shadow: 0 4px 12px rgba(0,0,0,0.3);
}

.section {
    margin-bottom: 25px;
}

.section h2 {
    margin-bottom: 10px;
    color: #333;
}

textarea {
    width: 100%;
    height: 100px;
    padding: 10px;
    border-radius: 8px;
    border: 1px solid #ccc;
    resize: none;
    font-size: 14px;
}

.payment-option {
    display: block;
    margin: 10px 0;
    font-size: 15px;
    color: #444;
}

.payment-option input {
    margin-right: 10px;
}

button {
    width: 100%;
    padding: 14px;
    font-size: 18px;
    border: none;
    border-radius: 10px;
    background-color: #ff7a00;
    color: #fff;
    cursor: pointer;
}

button:hover {
    background-color: #e66a00;
}
    
    </style>
</head>
<body>

<div class="checkout-container">
    <h2 class="checkout-title">Checkout</h2>

    <form action="checkout" method="post">

        <!-- Address -->
        <div class="section">
            <label>Delivery Address:</label>
            <textarea name="address" required></textarea>
        </div>

        <!-- Payment -->
        <div class="section">
            <h3>Payment Method</h3>

            <label>
                <input type="radio" name="paymentMethod" value="CREDIT_CARD" required>
                Credit Card
            </label><br>

            <label>
                <input type="radio" name="paymentMethod" value="DEBIT_CARD">
                Debit Card
            </label><br>

            <label>
                <input type="radio" name="paymentMethod" value="CASH_ON_DELIVERY">
                Cash on Delivery
            </label>
        </div>

        <div class="section">
            <button type="submit">Place Order</button>
        </div>

    </form>
</div>

</body>
</html>