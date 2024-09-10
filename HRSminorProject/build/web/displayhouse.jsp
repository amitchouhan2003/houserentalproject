<%-- 
    Document   : displayhoude.jsp
    Created on : 17 May 2024, 13:36:28
    Author     : krishtiwari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>House Details</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h2>House Details</h2>
    <table>
        <thead>
            <tr>
                <th>Owner Name</th>
                <th>Contact</th>
                <th>Price</th>
                <th>Location</th>
                <th>State</th>
            </tr>
        </thead>
        <tbody>
        <h2>hello</h2>
            <% 
//             Retrieve house list from request attribute
            List<House> houseList = (List<House>) request.getAttribute("houseList");
            // Loop through the list and display house details in table rows
            for (House house : houseList) { %>
            <tr>
                <td><%= house.getOwnername() %></td>
                <td><%= house.getContact() %></td>
                <td><%= house.getPrice() %></td>
                <td><%= house.getLocation() %></td>
                <td><%= house.getState() %></td>
            </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>
