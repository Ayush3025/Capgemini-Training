import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

/*************************************************************
 Developer Name : Ayush Tiwari
 Developer Contact : ayushtiwari3012004@gmail.com
 Created on : 21-02-2026 10:19
 Project Name : untitled
 *************************************************************/
public class MarksDB {
    static HashMap<Integer,Student> hm = new HashMap<>();
    static String file = "studentData.bin";
    public static void addMarks(int roll,int marks,String name) throws IOException, ClassNotFoundException {
        FileInputStream fin = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fin);
        hm = (HashMap<Integer, Student>) ois.readObject();
        ois.close();
        fin.close();
        hm.put(roll,new Student(name,marks));
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(hm);
        oos.close();
        fos.close();
        System.out.println("Student Added Successfully");
    }
    public static void getMarks(int roll) throws IOException, ClassNotFoundException {
        FileInputStream fin = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fin);
        hm = (HashMap<Integer, Student>) ois.readObject();
        ois.close();
        fin.close();
        Student s = hm.get(roll);
        if(s!=null){
            System.out.println("Name : "+s.name+" Marks : "+s.marks);
        }else{
            System.out.println("Invalid Roll Number !!");
        }
    }
    public static void printAll() throws IOException, ClassNotFoundException {
        FileInputStream fin = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fin);
        hm = (HashMap<Integer, Student>) ois.readObject();
        ois.close();
        fin.close();
        if (hm.isEmpty()) {
            System.out.println("No Records Found");
        } else {
            hm.forEach((roll, student) ->
                    System.out.println("Roll: " + roll + " -> " + student));
        }
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        boolean flag =true;
        while(flag) {
            System.out.println("Choose option : ");
            System.out.println("1. Add details");
            System.out.println("2. Get details");
            System.out.println("3. Show details");
            System.out.println("4. Exit");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter roll number : ");
                    int roll = sc.nextInt();
                    System.out.println("Enter your name : ");
                    String name = sc.next();
                    System.out.println("Enter marks : ");
                    int marks = sc.nextInt();
                    addMarks(roll, marks, name);
                    break;
                case 2:
                    System.out.println("Enter roll number : ");
                    int roll1 = sc.nextInt();
                    getMarks(roll1);
                    break;
                case 3:
                    System.out.println("File Data : ");
                    printAll();
                    break;
                case 4:
                    System.out.println("Thank you !! ");
                    flag=false;
                    break;

                default:
                    System.out.println("Invalid option");
                    flag=false;
                    break;
            }
        }
    }
}
