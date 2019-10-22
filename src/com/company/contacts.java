package com.company;
import org.jcp.xml.dsig.internal.dom.DOMSubTreeData;

import java.sql.*;
import java.util.Scanner;

public class contacts {

    public static Scanner userChoice = new Scanner(System.in);

    static void homeScreen(){



        System.out.println("Welcome, please chose from the follwoing options: ");
        System.out.println("1. Add a user");
        System.out.println("2. Delete a user");
        System.out.println("3. Edit a user");
        System.out.println("4. Display contacts");
        System.out.println("5. Logout");
        String choice = userChoice.nextLine();

        if(choice.equals("1")) {
            addUser();
        } else if(choice.equals("2")) {
            deleteUser();
        } else if(choice.equals("3")) {
            editUser();
        } else if(choice.equals("4")) {
            displayContacts();
        } else if(choice.equals("5")){
            Main.welcome();
        } else {
            System.out.println("Invalid choice, please select from the following numbers: ");
            homeScreen();
        }
    }

    static void addUser(){
        Connection c = null;
        PreparedStatement ps = null;

        System.out.println("Please enter the persons name: ");
        String name = userChoice.nextLine();

        System.out.println("Please enter phone number: ");
        String number = userChoice.nextLine();

        System.out.println("Please enter email address: ");
        String email = userChoice.nextLine();

        System.out.println("Confirm adding: " + name + " " + number + " " + email +"?" + " " + "(Y/N");
        String confirm = userChoice.nextLine();

      try{
          c = DriverManager.getConnection("jdbc:sqlite:test.db");

          String query = "INSERT into contacts(Name, Phone, Email) VALUES (?,?,?)";
          ps = c.prepareStatement(query);
          ps.setString(1, name);
          ps.setString(2, number);
          ps.setString(3, email);

          if (confirm.equalsIgnoreCase("N")) {
              addUser();
          } else if(confirm.equalsIgnoreCase("Y")) {

              int i = ps.executeUpdate();
              System.out.println("Contact successfully added");
              homeScreen();
          } else {
              addUser();
          }

      } catch (Exception e) {
          System.exit(0);
      }


    }

    static void deleteUser(){

    }

    static void editUser(){

    }

    static  void displayContacts(){
        
    }



    public static void main(String[] args) {
        homeScreen();
    }
}
