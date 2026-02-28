import java.io.File;

/*************************************************************
 Developer Name : Ayush Tiwari
 Developer Contact : ayushtiwari3012004@gmail.com
 Created on : 21-02-2026 15:15
 Project Name : untitled
 *************************************************************/
public class FilesList {
    public static void main(String[] args) {
        File file = new File("src/Students.java");
        System.out.println("exits " + file.exists());
        System.out.println("isFile " + file.isFile());
        System.out.println("isDir " + file.isDirectory());
        System.out.println("length " + file.length());
        System.out.println("can read " + file.canRead());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getAbsolutePath());

        File dir = new File(".");
        System.out.println("exits "+dir.exists());
        System.out.println(dir.isDirectory());
        String[] list = dir.list();
        for(String name : list){
            System.out.println(name);
        }

        File newDir = new File("e:/galgotias");
        if (! newDir.exists()){
            try{
                newDir.mkdir();
            }catch (SecurityException e){
                System.out.println("Can not create dir");
            }
        }


    }
}
