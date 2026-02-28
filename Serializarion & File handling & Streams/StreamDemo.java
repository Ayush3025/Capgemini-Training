import java.util.List;
import java.util.stream.Stream;

/*************************************************************
 Developer Name : Ayush Tiwari
 Developer Contact : ayushtiwari3012004@gmail.com
 Created on : 23-02-2026 14:21
 Project Name : untitled
 *************************************************************/
public class StreamDemo {
    public static void main(String[] args) {
        List<Integer> list = List.of(23,23,45,34,65,4,78,54,25,56,7,65,43);
        Stream<Integer> stream = list.stream();
        boolean allMatch = stream.allMatch(x -> x>=40);
        System.out.println("All greater than 40 : "+allMatch );

        boolean anyMatch = list.stream().anyMatch(x -> x>=75);
        System.out.println("Any above 75 : "+anyMatch);

        System.out.println(list.stream().count());

        list.stream().distinct().forEach(System.out::println);

        list.stream().filter(x ->  x>=40);
    }
}
