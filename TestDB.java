package com.loginsystem;

import java.sql.Connection;

public class TestDB {

    static void main() {
        try (Connection con = DBConnection.getConnection()) {
            if (con.isValid(2)) {
                System.out.println("DATABASE CONNECTED SUCCESSFULLY!");
            }
        } catch (Exception e) {
            System.err.println("DATABASE CONNECTION FAILED: " + e.getMessage());
        }
    }
}