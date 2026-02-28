package DSa;

/*************************************************************
 Developer Name : Ayush Tiwari
 Developer Contact : ayushtiwari3012004@gmail.com
 Created on : 25-02-2026 15:14
 Project Name : untitled
 *************************************************************/
public class DateFormatingg {
    public static String formatting(String str){
        String ans="";
        for(int i=0;i<str.length();i++){
            int ch = str.charAt(i)-'0';
            if(ch>=0 && ch<10){
                ans+=str.charAt(i);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String s = "12.04.4";
        System.out.println(formatting(s));
    }
}
