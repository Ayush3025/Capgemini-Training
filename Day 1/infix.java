package org.example;
import java.util.Stack;

public class infix {

    public static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;

            default:
                return -1;
        }
    }

    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    public static String infixToPostfix(String infix) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            }
            else if (c == '(') {
                stack.push(c);
            }
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            }
            else if (isOperator(c)) {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println("--------------------------------");
        String infix1 = "(a+(b*c))";
        System.out.println("Infix : " + infix1);
        System.out.println("Postfix : " + infixToPostfix(infix1));
        System.out.println("--------------------------------");
        String infix2 = "((a+b)*(z+k))";
        System.out.println("Infix : " + infix2);
        System.out.println("Postfix : " + infixToPostfix(infix2));
        System.out.println("--------------------------------");
        String infix3 = "((a+t)*((b+(a+c))^(c+d)))";
        System.out.println("Infix : " + infix3);
        System.out.println("Postfix : " + infixToPostfix(infix3));
        System.out.println("--------------------------------");
    }
}
