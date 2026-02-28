package org.example;
import java.util.Stack;

public class DecodeString {

    public static String decode(String s) {

        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();

        String curr = "";
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);


            if (ch >= '0' && ch <= '9') {
                num = num * 10 + (ch - '0');
            }

            else if (ch == '[') {
                numStack.push(num);
                strStack.push(curr);
                curr = "";
                num = 0;
            }

            else if (ch == ']') {
                int times = numStack.pop();
                String prev = strStack.pop();
                String temp = "";

                for (int j = 0; j < times; j++) {
                    temp += curr;
                }

                curr = prev + temp;
            }

            else {
                curr += ch;
            }
        }

        return curr;
    }

    public static void main(String[] args) {
        System.out.println(decode("3[a2[b]]")); // abbabbabb
    }
}
