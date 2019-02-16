import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	public static void main (String[] args) throws java.lang.Exception {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int a[] = new int[size];
		for (int i = 0; i < size; i++)
			a[i] = sc.nextInt();
		Solution solution = new Solution();
		solution.bubbleSortOptimized(a);
		for (int i = 0 ; i < a.length; i++)
			System.out.print(a[i] + " ");
	}
	
	public void bubbleSort(int a[]) {
		boolean swapped;
		for (int i = 0; i < a.length - 1; i++) {
			swapped = false;
			for (int j =  0; j < a.length - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
					swapped = true;
				}
			}
			 // IF no two elements were swapped by inner loop, then break
			if (swapped == false)
				break;
		}
	}

	public void bubbleSortOptimized(int a[]) {
		boolean isSorted = false;
		int lastUnsorted = a.length - 1;

		while (!isSorted) {
			isSorted = true;
			for (int i = 0; i < lastUnsorted; i++) {
				if (a[i] > a[i+1]) {
					int temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
					isSorted = false;
				}
			}
			lastUnsorted--;
		}
	}

	public void bubbleSortRecursive( int[] a, int n ) {
		if( n == 1) return;
			
		for ( int i = 0; i < n - 1; i++ ) {
			if ( a[i] > a[i + 1] ) {
				int temp = a[i];
				a[i] = a[i + 1];
				a[i + 1] = temp;
			}
		}

		bubbleSortRecursive( a, n - 1);
	}
}

/***

Running time is O(n^2) in worst case, for nearly sorted data, it can be efficient using boolean "swapped".
O(1) space complexity.

***/