package org.example;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/*************************************************************
 Developer Name : Ayush Tiwari
 Developer Contact : ayushtiwari3012004@gmail.com
 Created on : 05-02-2026 15:04
 Project Name : Capgemini
 *************************************************************/
public class LogisticManagement {

    static class Product {
        int productId;
        String name;
        double price;

        Product(int productId, String name, double price) {
            this.productId = productId;
            this.name = name;
            this.price = price;
        }
    }

    static class Customer {
        String name;
        String address;
        long mobileNumber;

        Customer(String name, String address, long mobileNumber) {
            this.name = name;
            this.address = address;
            this.mobileNumber = mobileNumber;
        }
    }

    static class Delivery {
        String deliveryPartner;
        String status;
        boolean isPrepaid;

        Delivery(boolean isPrepaid) {
            this.isPrepaid = isPrepaid;
            this.status = "Order Placed";
            this.deliveryPartner = "Not Assigned";
        }
    }

    static HashMap<Integer, Product> productMap = new HashMap<>();
    static HashMap<Integer, Customer> customerMap = new HashMap<>();
    static HashMap<Integer, Delivery> deliveryMap = new HashMap<>();

    public static void menu() {
        System.out.println("\nChoose option :");
        System.out.println("1. Create New Order");
        System.out.println("2. Order Status");
        System.out.println("3. Update Status");
        System.out.println("4. Assign Delivery Partner");
        System.out.println("5. View Customer Details");
        System.out.println("6. Exit");
        System.out.println("----------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        System.out.println("*------* Welcome to Logistics Management System *------*");

        boolean flag = true;

        while (flag) {
            menu();
            int option = sc.nextInt();

            switch (option) {

                case 1:
                    int orderId = r.nextInt(90000) + 10000;

                    System.out.print("Enter Product Name : ");
                    String pname = sc.next();

                    System.out.print("Enter Product Price : ");
                    double price = sc.nextDouble();

                    System.out.print("Is prepaid? (true/false): ");
                    boolean prepaid = sc.nextBoolean();

                    System.out.print("Enter Customer Name : ");
                    String cname = sc.next();

                    System.out.print("Enter Customer Address : ");
                    sc.nextLine(); // buffer clear
                    String address = sc.nextLine();

                    System.out.print("Enter Customer Mobile Number : ");
                    long mobile = sc.nextLong();

                    Product product = new Product(orderId, pname, price);
                    Customer customer = new Customer(cname, address, mobile);
                    Delivery delivery = new Delivery(prepaid);

                    productMap.put(orderId, product);
                    customerMap.put(orderId, customer);
                    deliveryMap.put(orderId, delivery);

                    System.out.println("New order created!");
                    System.out.println("Order ID : " + orderId);
                    break;


                case 2:
                    System.out.print("Enter Order ID : ");
                    int id = sc.nextInt();

                    if (deliveryMap.containsKey(id)) {
                        Delivery d = deliveryMap.get(id);
                        System.out.println("Status : " + d.status);
                        System.out.println("Delivery Partner : " + d.deliveryPartner);
                        System.out.println("Payment : " + (d.isPrepaid ? "Prepaid" : "COD"));
                    } else {
                        System.out.println("Order not found");
                    }
                    break;

                case 3:
                    System.out.print("Enter Order ID : ");
                    int oid = sc.nextInt();

                    if (deliveryMap.containsKey(oid)) {
                        System.out.print("Enter new status (Packed / Shipped / Delivered): ");
                        sc.nextLine();
                        String status = sc.nextLine();

                        deliveryMap.get(oid).status = status;
                        System.out.println("Status updated");
                    } else {
                        System.out.println("Order not found");
                    }
                    break;

                case 4:
                    System.out.print("Enter Order ID : ");
                    int did = sc.nextInt();

                    if (deliveryMap.containsKey(did)) {
                        System.out.print("Enter Delivery Partner Name : ");
                        String partner = sc.next();

                        deliveryMap.get(did).deliveryPartner = partner;
                        System.out.println("Delivery partner assigned");
                    } else {
                        System.out.println("Order not found");
                    }
                    break;


                case 5:
                    System.out.print("Enter Order ID : ");
                    int cid = sc.nextInt();

                    if (customerMap.containsKey(cid)) {
                        Customer c = customerMap.get(cid);
                        System.out.println("Customer Name : " + c.name);
                        System.out.println("Address : " + c.address);
                        System.out.println("Mobile : " + c.mobileNumber);
                    } else {
                        System.out.println("Customer not found");
                    }
                    break;

                case 6:
                    System.out.println("Thank you for using Logistics Management System");
                    flag = false;
                    break;

                default:
                    System.out.println("Invalid option");
            }
        }
        sc.close();
    }
}
