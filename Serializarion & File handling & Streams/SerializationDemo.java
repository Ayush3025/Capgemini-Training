import java.io.*;
import java.util.Scanner;

/*************************************************************
 Developer Name : Ayush Tiwari
 Developer Contact : ayushtiwari3012004@gmail.com
 Created on : 21-02-2026 09:45
 Project Name : untitled
 *************************************************************/
public class SerializationDemo  {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream fos = new FileOutputStream("studentData.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Scanner sc = new Scanner(System.in);


//        oos.writeObject(new Student(1391,85));
//        oos.writeObject(new Student(1392,80));
//        oos.writeInt(987);
        oos.close();
        fos.close();
        System.out.println("Data Written");

        FileInputStream fin = new FileInputStream("studentData.bin");
        ObjectInputStream ois = new ObjectInputStream(fin);
        Object ob1 = ois.readObject();
        Object ob2 = ois.readObject();
        int x = ois.readInt();
        ois.close();
        fin.close();

        System.out.println(ob1);
        System.out.println(ob2);
        System.out.println("x : "+x);
    }
}
