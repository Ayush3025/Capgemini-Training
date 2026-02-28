package Multithreading;

import java.util.ArrayList;
import java.util.List;

/*************************************************************
 Developer Name : Ayush Tiwari
 Developer Contact : ayushtiwari3012004@gmail.com
 Created on : 25-02-2026 11:35
 Project Name : untitled
 *************************************************************/
class Downloader extends Thread{
    String image;
    Downloader(String image){
        this.image=image;
    }
    public void run(){
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("downloading "+image);
    }
}
public class ImageDownloader {
    public static void main(String[] args) throws InterruptedException {
        String images[] = {"image1","image2","image3","image4","image5"};
        List<Thread> list = new ArrayList<>();
        for(int i=0;i<images.length;i++){
            Downloader downloader = new Downloader(images[i]);
            downloader.start();
            list.add(downloader);
        }
        for(Thread t : list){
            t.join();
        }
        System.out.println("All image downloaded");
    }
}
