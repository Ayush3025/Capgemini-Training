package org.example;

import java.io.*;
// kavita.arora@capgemini.com
/*************************************************************
 Developer Name : Ayush Tiwari
 Developer Contact : ayushtiwari3012004@gmail.com
 Created on : 11-02-2026 12:00
 Project Name : Capgemini
 *************************************************************/
public class Capge {
    public static void main(String[] args) throws FileNotFoundException, IOException {

        try{
            FileReader fileReader = new FileReader("abc.txt");
        }catch (Exception E){
            System.out.println("File not found !!");
        }

        InputStream stream = System.in;
        InputStreamReader inputStreamReader = new InputStreamReader(stream);
        BufferedReader r1 = new BufferedReader(inputStreamReader);
        String s = r1.readLine();
        System.out.println(s);
    }
}
