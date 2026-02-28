package com.capge;

import java.util.Random;

public class RandomGenerator {
	public static void main(String[] args) {
		RandomGenerator r = new RandomGenerator();
		int arr[]= r.getTenRandoms();
		for(int i=0;i<10;i++) {
			System.out.print(arr[i]+" ");
		}
	}

	public int[] getTenRandoms() {
		// TODO Auto-generated method stub
		int[] arr = new int[10];
		Random ran = new Random();
		for(int i=0;i<10;i++) {
			arr[i]=ran.nextInt(10);
		}
		return arr;
	}

}
