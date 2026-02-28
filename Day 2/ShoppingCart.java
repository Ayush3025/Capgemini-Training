package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*************************************************************
 Developer Name : Ayush Tiwari
 Developer Contact : ayushtiwari3012004@gmail.com
 Created on : 05-02-2026 10:45
 Project Name : Capgemini
 *************************************************************/
public class ShoppingCart {
    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Name: ");
        String str = sc.next();
        System.out.println("Choose option : ");

        //l.add(str);

        boolean flag = true;
        while(flag){
            System.out.println("1.Add item\n2.Remove item\n3.Show Cart\n4.Fetch\n5.Quit");
            int n =sc.nextInt();

        if(n==1){
            System.out.println("Enter the mobile phone brand.");
            String s = sc.next();
            l.add(s);
            System.out.println("Item Added in cart");
            System.out.println("-----------");
        }else if(n==2){
            System.out.println("Enter the mobile phone brand.");
            String s = sc.next();
            if(l.contains(s)) {
                l.remove((s));
                System.out.println(s + " removed.");
                System.out.println("-----------");
            }else{
                System.out.println("Item not present");
                System.out.println("-----------");
            }
        }else if(n==4){
            System.out.println("Enter which position item you want to find ");
            int m=sc.nextInt();
            if(m<l.size()){
                System.out.println(l.get(m));
                System.out.println("-----------");
            }else{
                System.out.println("No item");
                System.out.println("-----------");
            }
        } else if (n==3) {
            System.out.println(str + " your cart contains : "+l);
            System.out.println("-----------");

        } else if (n==5) {
            System.out.println("Thank You !! ");
            flag=false;
        } else{
            System.out.println("Invalid option");
        }

        }
        int len=l.size();
        System.out.println("Items in list : " + (len));

    }
}
