import java.io.Serializable;

/*************************************************************
 Developer Name : Ayush Tiwari
 Developer Contact : ayushtiwari3012004@gmail.com
 Created on : 21-02-2026 09:51
 Project Name : untitled
 *************************************************************/
public class Student implements Serializable {
    int rollno;
    String name;
    int marks;

    public Student(String  name, int marks) {
        this.name = name;
        this.marks = marks;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name=" + name +
                ", marks=" + marks +
                '}';
    }
}
