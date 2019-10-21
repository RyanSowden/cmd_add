package com.company;
import java.util.Scanner;


public class Main{

        static void welcome(){
            
            System.out.println("Welcome to cmdadd, please select from the below options:");
            System.out.println("1.Login");
            System.out.println("2.Register");

            Scanner choice = new Scanner(System.in);
            String answer = choice.nextLine();

            if(answer.equals("1")) {

                login.userLogin();


            }

            else if(answer.equals("2")){
                Register.registerUser();
            } else {
                System.out.println("Invalid Choice");
                welcome();
            }



        }

    public static void main(String[] args) {
        welcome();
    }

}

