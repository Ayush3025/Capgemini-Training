package org.example;

import java.util.Random;
import java.util.Scanner;

/*************************************************************
 Developer Name : Ayush Tiwari
 Developer Contact : ayushtiwari3012004@gmail.com
 Created on : 04-02-2026 14:13
 Project Name : Capgemini
 *************************************************************/
public class Dice {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner s = new Scanner(System.in);
        System.out.println("----------Welcome to Dice game----------");
        System.out.println("Rules:\n1: Computer rolls dice\n2: Players rolls dice\n3: Bigger number wins !!");
        System.out.println("Enter how many turns you want to play : ");
        int n=s.nextInt();
        int cc=0,uc=0;
        for(int i=0;i<n;i++){
            int c = r.nextInt(6);
            System.out.println("Computer chooses : "+c);
            System.out.println("Roll : Y/N");
            String st=s.next().toUpperCase();
            int u=0;
            if(st.equals("Y")){
                u= r.nextInt(6);
                System.out.println("User Chooses : "+u);
            }else if(st.equals("N")) {
                System.out.println("Game Ended");
                break;
            }else{
                System.out.println("Invalid option");
            }
            if(c>u){
                System.out.println("Computer Wins !!");
                System.out.println("----------------");
                cc++;
            }else if(c<u) {
                System.out.println("User Wins !!");
                System.out.println("----------------");
                uc++;
            }else {
                System.out.println("Draw!!");
            }
        }
        System.out.println("Final Result :\n User Wins : "+uc+"\n Computer Wins : "+cc);
    }
}
