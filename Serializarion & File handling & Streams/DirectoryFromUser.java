import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;
import java.util.TreeSet;

/*************************************************************
 Developer Name : Ayush Tiwari
 Developer Contact : ayushtiwari3012004@gmail.com
 Created on : 21-02-2026 15:30
 Project Name : untitled
 *************************************************************/
public class DirectoryFromUser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<File,Integer> hm = new HashMap<>();
        try{
        System.out.println("Enter the directory name : ");
        String name = sc.next();
        File dir = new File(name);
        TreeSet<File> set = new TreeSet<>((a,b)->Long.compare(b.length(),a.length()));
        if(dir.exists() && dir.isDirectory()){
            File[] list = dir.listFiles();
            if(list!=null) {
                for (File fname : list) {
                    if (fname.isFile() && fname.getName().endsWith(".java")) {
                        set.add(fname);
                        FileReader fr = new FileReader(fname);
                        Scanner filesc = new Scanner(fr);
                        int count=0;
                        while (filesc.hasNext()){
                            String word = filesc.next();
                            if(word.equals("system")){
                                count++;
                            }
                        }
                        hm.put(fname,count);
                    }
                }
                for(File f : set){
                    System.out.println("File name : "+f+"\tLength : "+f.length());
                }
            }
        }else{
            System.out.println("Directory does not exist.");
        }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            sc.close();
        }
        System.out.println(hm);
    }
}
