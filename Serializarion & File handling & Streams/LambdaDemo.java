import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*************************************************************
 Developer Name : Ayush Tiwari
 Developer Contact : ayushtiwari3012004@gmail.com
 Created on : 23-02-2026 09:47
 Project Name : untitled
 *************************************************************/
public class LambdaDemo {
    interface Calc{
        int add(int a, int b);
    }
     static class myClass implements Calc{
        @Override
        public int add(int a, int b) {
            return a+b;
        }
    }

    public static void main(String[] args) {
        myClass c1 = new myClass();
        System.out.println(c1.add(3,4));
        Calc c6 = new Calc() {
            @Override
            public int add(int a, int b) {
                return a+b;
            }
        };

        Calc c2 = (int a,int b)->{return a+b;};
        Calc c3 = (a,b)->{return a+b;};
        Calc c4 = (a,b)->a+b;
        Calc c5 = Integer :: sum;

        List<Employee> list = new ArrayList<>();
        list.add(new Employee(875,"Ayush"));
        list.add(new Employee(785,"Aman"));
        list.add(new Employee(74,"Divayansh"));
        list.add(new Employee(85,"Ratnesh"));
        list.add(new Employee(87,"Adtiya"));

        list.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        System.out.println(list);
        list.sort((e1,e2)->e1.name.compareTo(e2.name));
        System.out.println(list);
        List<Integer> l = new ArrayList<>();
        Integer []ar = {34,89,100,36,96,45,160,1780,889,478,960};
        l.addAll(Arrays.asList(ar));
        l.removeIf(x->x>100);
        System.out.println(l);


    }
}
