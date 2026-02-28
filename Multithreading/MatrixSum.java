package Multithreading;

/*************************************************************
 Developer Name : Ayush Tiwari
 Developer Contact : ayushtiwari3012004@gmail.com
 Created on : 25-02-2026 12:09
 Project Name : untitled
 *************************************************************/
class Sum extends Thread{
    int m1row[];
    int m2row[];
    int resultrow[];
    Sum(int m1row[], int m2row[], int resultrow[]){
        this.m1row=m1row;
        this.m2row=m2row;
        this.resultrow=resultrow;
    }
    public void run(){
        for(int i=0;i<m1row.length;i++){
            resultrow[i]=m1row[i]+m2row[i];
        }
    }
}
public class MatrixSum {
    public static void main(String[] args) throws InterruptedException {
        int[][] m1 = {{1,2,2,4},{7,8,4,5},{9,6,3,2},{1,5,9,7},{4,8,6,2}};
        int[][] m2 = {{1,2,2,4},{7,8,4,5},{9,6,3,2},{1,5,9,7},{4,8,6,2}};

        Sum[] threads = new Sum[m1.length];
        int [][] m3 = new int[5][4];
        for(int i=0;i<m1.length;i++){
            threads[i]=new Sum(m1[i],m2[i],m3[i]);
            threads[i].start();
        }
        for(int i=0;i<m1.length;i++){
            threads[i].join();
        }
        System.out.println("Sum of matrix : ");
        for(int i=0;i<m3.length;i++){
            for (int j=0;j<m3[0].length;j++){
                System.out.print(m3[i][j]+" ");
            }
            System.out.println();
        }
    }
}
