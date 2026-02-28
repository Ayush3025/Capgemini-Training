package org.example;
import java.util.Stack;

public class minmax {

    private Stack<Long> stack = new Stack<>();
    private long min, max;

    public void push(long x) {
        if (stack.isEmpty()) {
            stack.push(x);
            min = max = x;
        }
        else if (x < min) {
            stack.push(2 * x - min);
            min = x;
        }
        else if (x > max) {
            stack.push(2 * x - max);
            max = x;
        }
        else {
            stack.push(x);
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }

        long top = stack.pop();

        if (top < min) {
            min = 2 * min - top;
        }
        else if (top > max) {
            max = 2 * max - top;
        }
    }

    public long getMin() {
        if (!stack.isEmpty()) throw new RuntimeException("Stack empty");
            return min;
    }

    public long getMax() {
        if (stack.isEmpty()) throw new RuntimeException("Stack empty");
        return max;
    }

    public static void main(String[] args) {
        minmax s = new minmax();

        s.push(5);
        s.push(2);
        s.push(10);
        s.push(3);
        s.push(20);
        s.push(1);

        System.out.println("Min: " + s.getMin());
        System.out.println("Max: " + s.getMax());

        s.pop();

        System.out.println("Min after pop: " + s.getMin());
        System.out.println("Max after pop: " + s.getMax());
    }
}
