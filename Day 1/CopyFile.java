package org.example;

import java.io.*;

/*************************************************************
 Developer Name : Ayush Tiwari
 Developer Contact : ayushtiwari3012004@gmail.com
 Created on : 20-02-2026 11:41
 Project Name : Capgemini
 *************************************************************/
public class CopyFile {
    public static void copyAlternateCharacter(String inputFile,String outputFile) throws IOException{
        FileInputStream fin = new FileInputStream(inputFile);
        FileOutputStream fout = new FileOutputStream(outputFile);

        int ch=0;
        boolean skip=true;
        while(ch  != -1){
            ch = fin.read();
            if(ch==-1){
                break;
            }
            if(skip)
                fout.write(ch);
            skip=!skip;
        }
        fin.close();
        fout.close();
    }
    public static void copyAlternateWord(String inputFile,String outputFile) throws IOException{
        FileReader fr = new FileReader(inputFile);
        FileWriter fw = new FileWriter(outputFile);
        BufferedReader br = new BufferedReader(fr);
        BufferedWriter bw = new BufferedWriter(fw);

        String line;
        boolean copy=true;
        while((line=br.readLine()) != null){
            String[] words = line.split("[ ]+");
            for(String word:words){
                if(copy){
                    bw.write(word+" ");
                }
                copy=!copy;
            }
            bw.newLine();
        }
        br.close();
        bw.close();
    }
    public static void copyAlternateLine(String inputFile, String outputFile) throws IOException{
        FileReader fr = new FileReader(inputFile);
        FileWriter fw = new FileWriter(outputFile);
        BufferedReader br = new BufferedReader(fr);
        BufferedWriter bw = new BufferedWriter(fw);

        String line1;
        boolean copyLine=true;
        while((line1=br.readLine())!=null){
            if(copyLine){
                bw.write(line1);
                bw.newLine();
            }
            copyLine=!copyLine;
        }
        br.close();
        bw.close();
    }
    public static void main(String[] args) throws IOException {

//        copyAlternateCharacter("z.txt","zCopy.txt");
//        copyAlternateWord("z.txt","zCopy.txt");
        copyAlternateLine("z.txt","zCopy.txt");

        System.out.println("File Copied");

    }
}
