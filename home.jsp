<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String name = (String) session.getAttribute("name");
    String surname = (String) session.getAttribute("surname");
    String email = (String) session.getAttribute("email");

    if (email == null) {
        response.sendRedirect("login.jsp?error=Please+login+first");
        return;
    }
%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Dashboard - Login System</title>

    <style>

        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }

        body {
            min-height: 100vh;
            background: linear-gradient(135deg, #141e30, #243b55);
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .card {
            width: 450px;
            background: white;
            padding: 40px;
            border-radius: 18px;
            text-align: center;
            box-shadow: 0 15px 40px rgba(0,0,0,0.3);
        }

        h1 {
            color: #243b55;
            margin-bottom: 10px;
        }

        .welcome {
            font-size: 22px;
            margin: 20px 0;
        }

        .info {
            background: #f4f6f8;
            padding: 18px;
            border-radius: 10px;
            text-align: left;
            margin: 20px 0;
        }

        .info p {
            margin: 10px 0;
        }

        .label {
            font-weight: bold;
        }

        .logout {
            display: inline-block;
            padding: 12px 25px;
            background: #243b55;
            color: white;
            text-decoration: none;
            border-radius: 8px;
            font-weight: bold;
        }

        .logout:hover {
            background: #141e30;
        }

    </style>

</head>

<body>

<div class="card">

    <h1>Login Successful 🎉</h1>

    <div class="welcome">
        Welcome, <strong><%= name %> <%= surname %></strong>
    </div>

    <div class="info">

        <p>
            <span class="label">Name:</span>
            <%= name %>
        </p>

        <p>
            <span class="label">Surname:</span>
            <%= surname %>
        </p>

        <p>
            <span class="label">Email:</span>
            <%= email %>
        </p>

    </div>

    <a class="logout" href="logout">
        Logout
    </a>

</div>

</body>

</html>