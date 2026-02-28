package org.example;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/*************************************************************
 Developer Name : Ayush Tiwari
 Developer Contact : ayushtiwari3012004@gmail.com
 Created on : 06-02-2026 10:58
 Project Name : Capgemini
 *************************************************************/
public class ReverseLL {
    public static boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;

                char top = stack.pop();

                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
        public static void main (String[]args){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a string of parentheses that you want to check");
            String s = sc.next();
            boolean ans = check(s);
            if (ans) {
                System.out.println("It is a valid parentheses.");
            } else {
                System.out.println("It is not a valid parentheses");
            }
        }

}
