package org.example;

import java.util.ArrayList;
import java.util.Scanner;

/*************************************************************
 Developer Name : Ayush Tiwari
 Developer Contact : ayushtiwari3012004@gmail.com
 Created on : 04-02-2026 12:13
 Project Name : Capgemini
 *************************************************************/
public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String > list = new ArrayList<>();
        boolean flag = true;
        while(flag) {
            System.out.println("Choose option");
            System.out.println("1. Add");
            System.out.println("2. Delete");
            System.out.println("3. Update");
            System.out.println("4. Print");
            System.out.println("5. Quit");
            int option = sc.nextInt();
            if (option == 1) {
                System.out.println("Enter your name");
                String name = sc.nextLine();
                list.add(name);
                System.out.println("Added Successfully");

            } else if (option == 2) {
                System.out.println("Enter your name");
                String name = sc.nextLine();
                System.out.println("Name removed");

            } else if (option == 3) {
                System.out.println("Enter your name");
                String name = sc.nextLine();
                System.out.println("Enter new name to update");
                String s = sc.nextLine();
                if(list.contains(name)) {
                    list.remove(name);
                    list.add(s);
                    System.out.println("Name Updated");
                }

            } else if (option==4) {
                System.out.println("Data : "+list);
            } else if (option==5) {
                System.out.println("Thank You !!");
                flag=false;

            } else {
                System.out.println("Invalid Option");

            }
        }
    }
}
