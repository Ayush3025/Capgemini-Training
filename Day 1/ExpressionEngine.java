package org.example;
import java.util.*;

public class ExpressionEngine {
    static Stack<Double> resultStack = new Stack<>();

    static int precedence(char op){
        switch(op){
            case '+': case '-': return 1;
            case '*': case '/': return 2;
        }
        return 0;
    }

    static String infixToPostfix(String infix){
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(char c : infix.toCharArray()){
            if(Character.isDigit(c)) postfix.append(c);
            else if(c=='(') stack.push(c);
            else if(c==')'){
                while(!stack.isEmpty() && stack.peek()!='(') postfix.append(stack.pop());
                stack.pop();
            } else {
                while(!stack.isEmpty() && precedence(c)<=precedence(stack.peek())) postfix.append(stack.pop());
                stack.push(c);
            }
        }
        while(!stack.isEmpty()) postfix.append(stack.pop());
        return postfix.toString();
    }

    static double evaluatePostfix(String postfix){
        Stack<Double> stack = new Stack<>();
        for(char c: postfix.toCharArray()){
            if(Character.isDigit(c)) stack.push((double)(c-'0'));
            else{
                double b = stack.pop();
                double a = stack.pop();
                switch(c){
                    case '+': stack.push(a+b); break;
                    case '-': stack.push(a-b); break;
                    case '*': stack.push(a*b); break;
                    case '/': stack.push(a/b); break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Enter expression or UNDO: ");
            String input = sc.nextLine();
            if(input.equalsIgnoreCase("UNDO")){
                if(!resultStack.isEmpty()){
                    resultStack.pop();
                    System.out.println("Undo done. Current top: " + (resultStack.isEmpty() ? "Empty" : resultStack.peek()));
                } else System.out.println("Nothing to undo.");
            } else if(input.matches("[0-9+\\-*/() ]+")){
                String postfix = infixToPostfix(input.replaceAll(" ", ""));
                double res = evaluatePostfix(postfix);
                resultStack.push(res);
                System.out.println("Result: "+res);
            } else System.out.println("Invalid expression.");
        }
    }
}
