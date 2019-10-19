package com.company;
import java.util.Scanner;
import java.security.MessageDigest;
import java.sql.*;


public class login{

    public static Scanner userInput = new Scanner(System.in);
    public static Scanner pswdInput = new Scanner(System.in);

    public static void main(String[] args) {

        Connection c = null;
        PreparedStatement preparedStatement = null;



        System.out.println("Please enter your User Name: ");
        String userName = userInput.nextLine();


        System.out.println("Please enter your password: ");
        String password = pswdInput.nextLine();

        c = DriverManager.getConnection("jdbc:sqlite:test.db");

        if ()


    }

}
