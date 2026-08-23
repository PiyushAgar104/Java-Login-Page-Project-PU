package com.loginsystem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email == null ||
                password == null ||
                email.isBlank() ||
                password.isBlank()) {

            response.sendRedirect(
                    "login.jsp?error=Please+fill+all+fields"
            );
            return;
        }

        String sql =
                "SELECT id,name,surname,email,password " +
                        "FROM users WHERE email=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    int id = rs.getInt("id");

                    String name =
                            rs.getString("name");

                    String surname =
                            rs.getString("surname");

                    String storedPassword =
                            rs.getString("password");

                    if (PasswordUtil.checkPassword(
                            password,
                            storedPassword)) {

                        HttpSession session =
                                request.getSession();

                        session.setAttribute(
                                "userId",
                                id
                        );

                        session.setAttribute(
                                "name",
                                name
                        );

                        session.setAttribute(
                                "surname",
                                surname
                        );

                        session.setAttribute(
                                "email",
                                email
                        );

                        response.sendRedirect(
                                "home.jsp"
                        );

                    } else {

                        response.sendRedirect(
                                "login.jsp?error=Invalid+email+or+password"
                        );
                    }

                } else {

                    response.sendRedirect(
                            "login.jsp?error=Invalid+email+or+password"
                    );
                }
            }

        } catch (Exception e) {

            e.printStackTrace();

            String error = e.getMessage();

            if (error == null) {
                error = "Database error";
            }

            response.sendRedirect(
                    "login.jsp?error=" +
                            URLEncoder.encode(
                                    error,
                                    StandardCharsets.UTF_8
                            )
            );
        }
    }
}