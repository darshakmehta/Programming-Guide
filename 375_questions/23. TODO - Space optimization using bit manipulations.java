import java.util.*;
import java.lang.*;
import java.io.*;

class Solution { // Time complexity: O(|b - a|)
	public static void getMultiplesOf2And5(int a, int b) {
		int size = Math.abs(b - a) + 1;
		int[] result = new int[size];

		for (int i = a; i <= b; i++) {
			if (i % 2 == 0 || i % 5 == 0) {
				result[i - a] = 1;
			}
		}

		System.out.println("Multiples of 2" + " and 5 are:");
        for (int i = a; i <= b; i++) {
            if (array[i - a] == 1) {
                System.out.printf(i + " ");
            }
        }
	}
	public static void main (String[] args) throws java.lang.Exception {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

		getMultiplesOf2And5(a, b);
	}
}

/**
Ideone: https://ideone.com/VVQflZ
**/

/**
TODO:
Understand bit setbit function in bit manipulation solution
**/
