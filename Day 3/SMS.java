package org.example;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/*************************************************************
 Developer Name : Ayush Tiwari
 Developer Contact : ayushtiwari3012004@gmail.com
 Created on : 05-02-2026 11:26
 Project Name : Capgemini
 *************************************************************/
public class SMS {
    static HashMap<Long,String> hm = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int m1 = r.nextInt(100-50)+50;
        int m2 = r.nextInt(100-50)+50;
        int m3 = r.nextInt(100-50)+50;
        int m4 = r.nextInt(100-50)+50;
        int m5 = r.nextInt(100-50)+50;
        double per = (m1+m2+m3+m4+m5)/5.0;


        boolean flag=true;
        while(flag) {
            System.out.println("Choose option : \n1. Register\n2. Login\n3. Exit");
            System.out.println("------------------------");
            int op = sc.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Enter your name: ");
                    String name = sc.next();
                    System.out.println("Enter mobile number : ");
                    long num = sc.nextLong();
                    if (!hm.containsKey(num)) {
                        hm.put(num, name);
                        System.out.println("Registration done ");
                        System.out.println("------------------------");
                    } else {
                        System.out.println("Credentials present");
                        System.out.println("------------------------");
                    }
                    break;
                case 2:
                    System.out.println("Enter your registered mobile number :");
                    long ip = sc.nextLong();
                    if (hm.containsKey(ip)) {
                        System.out.println(hm.get(ip)+" Logged in successfully");
                        System.out.println("------------------------");
                        boolean f = true;
                        while(f){
                        System.out.println("Choose option : \n1.Show all marks\n2.Calculate percentage\n3.Study Material\n4.Attendance\n5.Exit");
                        System.out.println("------------------------");
                        int n = sc.nextInt();
                        switch (n) {
                            case 1:
                                System.out.println("Subject and Marks : ");
                                System.out.println("English : " + m1);
                                System.out.println("Hindi : " + m2);
                                System.out.println("Science : " + m3);
                                System.out.println("Mathematics : " + m4);
                                System.out.println("Social Science : " + m5);
                                System.out.println("------------------------");
                                break;
                            case 2:
                                System.out.println("Percentage : " + per);
                                System.out.println("------------------------");
                                break;
                            case 3:
                                System.out.println("Want to open pdf : (Y/N)");
                                String p = sc.next().toUpperCase();
                                if (p.equals("Y") ) {
                                    System.out.println("Opened PDF");
                                    System.out.println("------------------------");
                                    break;
                                } else if (p.equals("N")) {
                                    System.out.println("Exit");
                                    System.out.println("------------------------");
                                    break;
                                } else {
                                    System.out.println("Invalid option");
                                    System.out.println("------------------------");
                                    break;
                                }
                                //break;
                            case 4:
                                float at = 50.0f+r.nextFloat()*(100.0f-50.0f);
                                at = Math.round(at * 100) / 100.0f;
                                System.out.println("Your overall attendance : "+at);
                                break;
                            case 5:
                                System.out.println("Back to main menu");
                                f=false;
                                System.out.println("------------------------");
                                break;
                            default:
                                System.out.println("Invalid option");
                                System.out.println("------------------------");
                                break;
                        }
                        }
                    } else {
                        System.out.println("No data found");
                        System.out.println("------------------------");
                    }
                    break;

            case 3:
                System.out.println("Thank you visit again !!");
                System.out.println("------------------------");
                flag = false;
                break;
            default:
                System.out.println("Invalid option");
                System.out.println("------------------------");
                break;
            }
        }
    }
}