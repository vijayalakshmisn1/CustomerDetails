<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.tap.customer.Customer" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Customer</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 20px;
    }

    h1 {
        text-align: center;
        color: #333;
    }

    form {
        background-color: #fff;
        border-radius: 8px;
        padding: 20px;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        max-width: 400px;
        margin: 0 auto;
    }

    label {
        font-weight: bold;
        display: block;
        margin-bottom: 8px;
    }

    input[type="text"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 10px;
        border: 1px solid #ddd;
        border-radius: 4px;
        box-sizing: border-box;
    }

    input[type="submit"] {
        background-color: #4CAF50;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        width: 100%;
    }

    input[type="submit"]:hover {
        background-color: #45a049;
    }

    input[readonly] {
        background-color: #f0f0f0;
    }
</style>
</head>
<body>
    <h1>Edit Customer</h1>
    <% Customer customer = (Customer) session.getAttribute("customer"); %>
    <form action="EditCustomer">
        <label for="id">ID</label>
        <input type="text" name="id" value="<%= customer.getId() %>" readonly>

        <label for="name">Name</label>
        <input type="text" name="name" value="<%= customer.getName() %>">

        <label for="email">Email</label>
        <input type="text" name="email" value="<%= customer.getEmail() %>" readonly>

        <label for="phone">Phone</label>
        <input type="text" name="phone" value="<%= customer.getPhone() %>">

        <label for="city">City</label>
        <input type="text" name="city" value="<%= customer.getCity() %>">

        <input type="submit" value="Edit Customer">
    </form>
</body>
</html>
