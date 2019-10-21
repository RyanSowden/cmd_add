package com.company;
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
        String choice = userChoice.nextLine();

        if(choice.equals("1")) {
            adduser();
        } else if(choice.equals("2")) {
            deleteUser();
        } else if(choice.equals("3")) {
            editUser();
        } else if(choice.equals("4")){
            displayContacts();
        } else {
            System.out.println("Invalid choice, please select from the following numbers: ");
            homeScreen();
        }
    }

    static void adduser(){

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
