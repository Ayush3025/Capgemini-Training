package com.capge;


import java.util.HashSet;
import java.util.Scanner;



public class SumSquareDigitsRepeat {
	
	public static int steps(int n) {
		int original = n;
        int count = 0;

        HashSet<Integer> visited = new HashSet<>();
        visited.add(original);

        n = getSquare(n);
        count++;

        while (n != original) {

            if (visited.contains(n)) {
                return -1;
            }

            visited.add(n);
            n = getSquare(n);
            count++;
        }
		return count;
	}
	public static int getSquare(int n) {
		int sum=0;
		while(n>0) {
			int digit=n%10;
			sum+=digit*digit;
			n/=10;
		}
		return sum;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number greater than 0 ");
		int n=sc.nextInt();
		int ans=steps(n);
		if(ans==-1) {
			System.out.println("Unreachable");
		}else {
			System.out.println(ans);
		}
		
	}

}
