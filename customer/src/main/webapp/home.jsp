<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> 
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.tap.customer.Customer" %>
<!-- Bootstrap 5 CSS (Use CDN for simplicity) -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer App</title>
    <style>
        /* Custom Styles */
        body {
            background-color: #d4edda; /* Light Green background for the page */
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh; /* Full viewport height */
            margin: 0;
        }

        .container {
            background-color: #ffffff; /* White background for the container */
            padding: 20px;
            border-radius: 10px;
            width: 100%;
            max-width: 1200px; /* Limit the width of the container */
        }

        .card {
            margin-bottom: 20px;
            border: 1px solid #007bff; /* Blue border around the card */
            border-radius: 10px;
        }

        .card-body {
            background-color: #ffffff; /* White background for the card body */
            border-radius: 10px;
            text-align: center;
        }

        .card-title {
            color: #007bff; /* Blue color for the card title */
        }

        .btn-primary {
            background-color: #007bff; /* Blue background for the Edit button */
            border-color: #007bff;
        }

        .btn-primary:hover {
            background-color: #0056b3; /* Darker blue on hover for Edit button */
            border-color: #0056b3;
        }

        .btn-danger {
            background-color: #dc3545; /* Red background for Delete button */
            border-color: #dc3545;
        }

        .btn-danger:hover {
            background-color: #c82333; /* Darker red on hover for Delete button */
            border-color: #c82333;
        }

        h2,h5 {
            color: #007bff; /* Blue color for the header */
            text-align: center;
        }
    </style>
</head>
<body>

<div class="container mt-5">
    <h2>Customer List</h2>
    <h5><a href="addCustomer.jsp"><button>Add a new Customer</button></a></h5>
    
    <!-- Start of the row for cards -->
    <div class="row row-cols-1 row-cols-md-3 g-4"> <!-- row-cols-md-3 ensures three cards per row on medium screens -->
        <%
            ArrayList<Customer> sList = (ArrayList<Customer>) session.getAttribute("customerList");
            if (sList != null) {    
                for (Customer stu : sList) {
        %>
                    <!-- Each card is inside a column -->
                    <div class="col">
                        <div class="card">
                            <!-- Card Body -->
                            <div class="card-body">
                                <h5 class="card-title">ID: <%= stu.getId() %></h5>
                                <p class="card-text"><strong>Name:</strong> <%= stu.getName() %></p>
                                <p class="card-text"><strong>Email:</strong> <%= stu.getEmail() %></p>
                                <p class="card-text"><strong>Phone:</strong> <%= stu.getPhone() %></p>
                                <p class="card-text"><strong>City:</strong> <%= stu.getCity() %></p>
                                
                                <!-- Action Buttons -->
                                <a href="FetchOne?sid=<%= stu.getId() %>" class="btn btn-primary">Edit</a>
                                <a href="DeleteCustomer?sid=<%= stu.getId() %>" class="btn btn-danger" 
                                   onclick="return confirm('Are you sure you want to delete this customer?');">Delete</a>
                            </div>
                        </div>
                    </div>
        <% 
                }
            }
        %>
    </div>
    <!-- End of the row for cards -->
</div>

<!-- Bootstrap JS and Popper.js for interactive components -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js">
