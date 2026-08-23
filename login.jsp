<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Login - Login System</title>

    <style>

        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }

        body {
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            background: linear-gradient(135deg, #141e30, #243b55);
        }

        .container {
            width: 400px;
            background: white;
            padding: 35px;
            border-radius: 16px;
            box-shadow: 0 10px 35px rgba(0,0,0,0.3);
        }

        h1 {
            text-align: center;
            margin-bottom: 8px;
            color: #222;
        }

        .subtitle {
            text-align: center;
            color: #777;
            margin-bottom: 25px;
        }

        .form-group {
            margin-bottom: 18px;
        }

        label {
            display: block;
            margin-bottom: 7px;
            font-weight: bold;
            color: #333;
        }

        input {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 8px;
            font-size: 15px;
            outline: none;
        }

        input:focus {
            border-color: #243b55;
        }

        button {
            width: 100%;
            padding: 13px;
            border: none;
            border-radius: 8px;
            background: #243b55;
            color: white;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
        }

        button:hover {
            background: #141e30;
        }

        .message {
            padding: 10px;
            margin-bottom: 18px;
            border-radius: 7px;
            text-align: center;
        }

        .error {
            color: #b00020;
            background: #ffe5e5;
        }

        .success {
            color: #087f23;
            background: #e5ffe9;
        }

        .register-link {
            text-align: center;
            margin-top: 20px;
            color: #666;
        }

        .register-link a {
            color: #243b55;
            font-weight: bold;
            text-decoration: none;
        }

    </style>

</head>

<body>

<div class="container">

    <h1>Welcome Back</h1>

    <p class="subtitle">
        Login to your account
    </p>

    <%
        String error = request.getParameter("error");
        String success = request.getParameter("success");

        if (error != null && !error.isBlank()) {
    %>

    <div class="message error">
        <%= error %>
    </div>

    <%
        }

        if (success != null && !success.isBlank()) {
    %>

    <div class="message success">
        <%= success %>
    </div>

    <%
        }
    %>

    <form action="login" method="post">

        <div class="form-group">

            <label for="email">
                Email
            </label>

            <input
                    type="email"
                    id="email"
                    name="email"
                    placeholder="Enter your email"
                    required>

        </div>

        <div class="form-group">

            <label for="password">
                Password
            </label>

            <input
                    type="password"
                    id="password"
                    name="password"
                    placeholder="Enter your password"
                    required>

        </div>

        <button type="submit">
            Login
        </button>

    </form>

    <div class="register-link">

        Don't have an account?

        <a href="register.jsp">
            Create Account
        </a>

    </div>

</div>

</body>

</html>