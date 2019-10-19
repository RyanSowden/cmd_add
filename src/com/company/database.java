package com.company;
import java.sql.*;

public class database {

    public static void main(String args[]) throws Exception {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("SQLite DB Connected");

            stmt = c.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS users " +
                    "(ID INTEGER PRIMARY KEY ," +
                    "UserName TEXT NOT NULL," +
                    "Password TEXT NOT NULL)";

                    //"CREATE TABLE IF NOT EXISTS contacts " +
                    //"(ID INT PRIMARY KEY NOT NULL," +
                    //"Name TEXT NOT NULL," +
                    //"Phone INT NOT NULL," +
                    //"Email TEXT NOT NULL)";

            stmt.executeUpdate(sql);
            stmt.close();
            c.close();



        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }
}

