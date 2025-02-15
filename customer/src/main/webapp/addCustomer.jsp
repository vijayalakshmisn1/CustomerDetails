<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add new Customer</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 60%;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #333;
        }

        form {
            display: flex;
            flex-direction: column;
            gap: 15px;
        }

        input[type="text"] {
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 4px;
            width: 100%;
            box-sizing: border-box;
        }

        input[type="submit"] {
            padding: 10px 20px;
            font-size: 16px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        label {
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Add New Customer</h1>
        <form action="AddCustomer">
            <label for="name">Name</label>
            <input type="text" id="name" name="name">

            <label for="email">Email</label>
            <input type="email" id="email" name="email">

            <label for="phone">Phone</label>
            <input type="text" id="phone" name="phone">

            <label for="city">City</label>
            <input type="text" id="city" name="city">

            <input type="submit" value="Add Customer">
        </form>
    </div>
</body>
</html>
