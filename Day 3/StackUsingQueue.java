package org.example;
import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    // =========================
    // METHOD 1: COSTLY PUSH
    // =========================
    static class StackCostlyPush {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        void push(int x) {
            q2.add(x);

            while (!q1.isEmpty()) {
                q2.add(q1.remove());
            }

            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }

        int pop() {
            if (q1.isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return q1.remove();
        }
    }

    // =========================
    // METHOD 2: COSTLY POP
    // =========================
    static class StackCostlyPop {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        void push(int x) {
            q1.add(x);
        }

        int pop() {
            if (q1.isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }

            while (q1.size() > 1) {
                q2.add(q1.remove());
            }

            int popped = q1.remove();

            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;

            return popped;
        }
    }

    // =========================
    // MAIN METHOD
    // =========================
    public static void main(String[] args) {

        System.out.println("=== Costly Push Stack ===");
        StackCostlyPush s1 = new StackCostlyPush();
        s1.push(10);
        s1.push(20);
        s1.push(30);
        System.out.println(s1.pop()); // 30
        System.out.println(s1.pop()); // 20

        System.out.println("\n=== Costly Pop Stack ===");
        StackCostlyPop s2 = new StackCostlyPop();
        s2.push(10);
        s2.push(20);
        s2.push(30);
        System.out.println(s2.pop()); // 30
        System.out.println(s2.pop()); // 20
    }
}
