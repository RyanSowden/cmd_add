package com.company;
import java.sql.*;
import java.util.Scanner;
import java.security.MessageDigest;


public class Register {

    //user credentials variables
    public static Scanner userInput = new Scanner(System.in);
    public static Scanner pswdInput = new Scanner(System.in);
    public static Scanner pswdConfirm = new Scanner(System.in);



    public static void main(String[] args) {


        Connection c = null;
        PreparedStatement preparedStatement = null;



//getting user details
        System.out.println("Please enter your username: ");
        String userName = userInput.nextLine();

        System.out.println("Please enter your password: ");
        String password = pswdInput.nextLine();

        System.out.println("Confirm password: ");
        String confirm_password = pswdConfirm.nextLine();


//hashing the user password
        try {

            String algorithm = "SHA";

            byte[] plainText = password.getBytes();
            MessageDigest md = MessageDigest.getInstance(algorithm);

            md.reset();
            md.update(plainText);
            byte[] encodedPassword = md.digest();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < encodedPassword.length; i++) {
                if ((encodedPassword[i] & 0xff) < 0x10) {
                    sb.append("0");
                }

                sb.append(Long.toString(encodedPassword[i] & 0xff, 16));
            }


            c = DriverManager.getConnection("jdbc:sqlite:test.db");

//preparing statement to be committed to the database
            String query = "INSERT into users(UserName,Password) VALUES (?,?)";
            preparedStatement = c.prepareStatement(query);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2,sb.toString());

//checking if the passwords match
            if(!password.equals(confirm_password)) {
                System.out.println("Passwords don't match, please start again");
            }
            else {
//if both the passwords match, insert the username and password into the databse

                int i = preparedStatement.executeUpdate();
                System.out.println("User successfully created");
            }

//throwing error

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }

}
