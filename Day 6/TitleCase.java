package DSa;

/*************************************************************
 Developer Name : Ayush Tiwari
 Developer Contact : ayushtiwari3012004@gmail.com
 Created on : 25-02-2026 16:15
 Project Name : untitled
 *************************************************************/
public class TitleCase {
    public static  String convert(String s){
        String [] strings = s.split("\\s+");
        String ans="";
        for(int i=0;i<strings.length;i++){
            String word = strings[i];
            char c = word.charAt(0);
            c=Character.toUpperCase(c);
            strings[i]=c+word.substring(1);
            ans+=strings[i]+" ";
        }
        return ans;
    }
    public static void main(String[] args) {
        String s = "This is java lang";
        System.out.println(convert(s));
    }
}
