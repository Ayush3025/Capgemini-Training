package Multithreading;

/*************************************************************
 Developer Name : Ayush Tiwari
 Developer Contact : ayushtiwari3012004@gmail.com
 Created on : 25-02-2026 10:32
 Project Name : untitled
 *************************************************************/
class ChildThread extends Thread{
//    public ChildThread(ThreadGroup group){
//        super(group,"Ayush");
//    }
    @Override
    public void run(){
        Thread thread = Thread.currentThread();
        System.out.println("Child : "+thread);
        for(int i=0;i<500;i++){
            System.out.println("Child "+i);
        }
    }
}
class ChildThread2 implements Runnable{

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println("Child 2 : "+thread);
        for(int i=0;i<500;i++){
            System.out.println("Child2 "+i);
        }
    }
}
public class ThreadingBasic {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println("Main Thread : "+thread);


        ChildThread c1 = new ChildThread();
        c1.setPriority(1);


        ChildThread2 c2 = new ChildThread2();
        Thread t = new Thread(c2);
        t.setPriority(10);

        c1.start();
        t.start();

        for(int i=0;i<500;i++){
            System.out.println("Main "+i);
        }

    }
}
