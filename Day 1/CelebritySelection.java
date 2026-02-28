package org.example;
import java.util.Stack;

public class CelebritySelection {

    static int findCelebrity(int[][] M, int n) {
        Stack<Integer> stack = new Stack<>();

        // Step 1: push all people
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        // Step 2: eliminate non-celebrities
        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();

            if (M[a][b] == 1) {
                // a knows b → a not celebrity
                stack.push(b);
            } else {
                // a doesn't know b → b not celebrity
                stack.push(a);
            }
        }

        // Step 3: verify candidate
        int candidate = stack.pop();

        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                if (M[candidate][i] == 1 || M[i][candidate] == 0) {
                    return -1; // no celebrity
                }
            }
        }

        return candidate;
    }

    // Driver
    public static void main(String[] args) {
        int[][] M = {
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 1, 1, 0}
        };

        int result = findCelebrity(M, M.length);
        System.out.println(result == -1 ? "No Celebrity" : "Celebrity is person " + result);
    }
}
