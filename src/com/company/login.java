package com.company;
import java.util.Scanner;
import java.security.MessageDigest;
import java.sql.*;



public class login {



        public static Scanner userInput = new Scanner(System.in);
        public static Scanner pswdInput = new Scanner(System.in);

     static void userLogin() {


        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs;

        System.out.println("Please enter your username: ");
        String userName = userInput.nextLine();

        System.out.println("Please enter your password: ");
        String password = pswdInput.nextLine();


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

            ps = c.prepareStatement("SELECT UserName, Password FROM users  ");
            rs = ps.executeQuery();
            boolean userFound = false;


            while (rs.next()) {

                if (userName.equals(rs.getString("UserName")) && sb.toString().equals(rs.getString("Password"))) {
                    userFound = true;
                    contacts.homeScreen();
                    break;

                }
            }

            if (!userFound) {
                System.out.println("Incorrect username or password");
                userLogin();
            }


        } catch (Exception e) {
            System.exit(0);
        }
    }

    public static void main (String[]args){
         userLogin();

    }
}


