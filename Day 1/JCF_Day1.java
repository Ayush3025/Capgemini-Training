package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/*************************************************************
 Developer Name : Ayush Tiwari
 Developer Contact : ayushtiwari3012004@gmail.com
 Created on : 04-02-2026 11:44
 Project Name : Capgemini
 *************************************************************/
public class JCF_Day1{
    public static void main(String[] args) {
        ArrayList<String > list = new ArrayList<>();
        list.add("Dosa");
        list.add("Idli");
        list.add("Bada");
        list.add("Lemon Rice");
        list.add("Rasmalai");

        ArrayList<String > list1 = new ArrayList<>();
        list1.add("samosa");
        list1.add("tea");

        list.addAll(1,list1);

//        list1.clear();
//
        System.out.println(list.contains("tea"));
//
        System.out.println(list.containsAll(list1));
//
//        list.remove("Idli");
//        list.removeAll(list1);
//
//        list.size();
//
//        list.retainAll(list1);
//
//        System.out.println(list1.isEmpty());
//
//        list.iterator();
//
//        list.stream();
//
//        list.parallelStream();
//
//        list1.toArray();
//
//        System.out.println(list.equals(list1));
//
//        list.hashCode();

        System.out.println(list);
        System.out.println(list1);
    }
}
