package com.company;
import java.util.Scanner;


public class Main{

        public static void main(String[] args) {
            
            System.out.println("Welcome to cmdadd, please select from the below options:");
            System.out.println("1.Login");
            System.out.println("2.Register");

            Scanner choice = new Scanner(System.in);
            String answer = choice.nextLine();

            if(answer.equals("1")) {

            }

            else if(answer.equals("2")){
                System.out.println("You chose 2");
            } else {
                System.out.println("Invalid Choice");
            }



        }



}

