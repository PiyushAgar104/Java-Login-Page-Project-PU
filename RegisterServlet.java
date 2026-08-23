package com.loginsystem;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException {

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (name == null ||
                surname == null ||
                email == null ||
                password == null ||
                name.trim().isEmpty() ||
                surname.trim().isEmpty() ||
                email.trim().isEmpty() ||
                password.trim().isEmpty()) {

            response.sendRedirect(
                    request.getContextPath() +
                            "/register.jsp?error=" +
                            URLEncoder.encode(
                                    "Please fill all details",
                                    StandardCharsets.UTF_8
                            )
            );

            return;
        }

        name = name.trim();
        surname = surname.trim();
        email = email.trim();

        if (!email.matches(
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {

            response.sendRedirect(
                    request.getContextPath() +
                            "/register.jsp?error=" +
                            URLEncoder.encode(
                                    "Invalid email",
                                    StandardCharsets.UTF_8
                            )
            );

            return;
        }

        if (password.length() < 6) {

            response.sendRedirect(
                    request.getContextPath() +
                            "/register.jsp?error=" +
                            URLEncoder.encode(
                                    "Password must be at least 6 characters",
                                    StandardCharsets.UTF_8
                            )
            );

            return;
        }

        try (Connection con = DBConnection.getConnection()) {

            String checkSql =
                    "SELECT id FROM users WHERE email = ?";

            try (PreparedStatement check =
                         con.prepareStatement(checkSql)) {

                check.setString(1, email);

                try (ResultSet rs =
                             check.executeQuery()) {

                    if (rs.next()) {

                        response.sendRedirect(
                                request.getContextPath() +
                                        "/register.jsp?error=" +
                                        URLEncoder.encode(
                                                "Email already registered",
                                                StandardCharsets.UTF_8
                                        )
                        );

                        return;
                    }
                }
            }

            String hashedPassword =
                    PasswordUtil.hashPassword(password);

            String sql =
                    "INSERT INTO users " +
                            "(name, surname, email, password) " +
                            "VALUES (?, ?, ?, ?)";

            try (PreparedStatement ps =
                         con.prepareStatement(sql)) {

                ps.setString(1, name);
                ps.setString(2, surname);
                ps.setString(3, email);
                ps.setString(4, hashedPassword);

                ps.executeUpdate();
            }

            response.sendRedirect(
                    request.getContextPath() +
                            "/login.jsp?success=" +
                            URLEncoder.encode(
                                    "Registration successful",
                                    StandardCharsets.UTF_8
                            )
            );

        } catch (Exception e) {

            e.printStackTrace();

            String message = e.getMessage();

            if (message == null ||
                    message.isBlank()) {

                message = "Database error";
            }

            response.sendRedirect(
                    request.getContextPath() +
                            "/register.jsp?error=" +
                            URLEncoder.encode(
                                    message,
                                    StandardCharsets.UTF_8
                            )
            );
        }
    }
}