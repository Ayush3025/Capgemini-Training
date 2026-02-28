package org.example;
import java.util.Stack;

public class JVMCallStack {

    static Stack<String> callStack = new Stack<>();

    // Utility to print current call stack
    static void printStack() {
        System.out.println("Current Call Stack:");
        for (int i = callStack.size() - 1; i >= 0; i--) {
            System.out.println("  " + callStack.get(i));
        }
        System.out.println("--------------------------");
    }

    static void validate() {
        callStack.push("validate()");
        printStack();

        // return from validate
        callStack.pop();
        printStack();
    }

    static void login() {
        callStack.push("login()");
        printStack();

        validate();

        // return from login
        callStack.pop();
        printStack();
    }


    // Driver
    public static void main(String[] args) {
        callStack.push("main()");
        printStack();

        login();

        // return from main
        callStack.pop();
        printStack();

    }
}
