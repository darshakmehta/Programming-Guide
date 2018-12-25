import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int a[] = new int[size];
		for(int i = 0; i < size; i++) {
			a[i] = sc.nextInt();
		}
		Solution solution = new Solution();		
		int maxSum = solution.maxSubarray(a, 0, size -1);
		System.out.println("Answer: " + maxSum);
	}
	
	
	public int maxSubarray(int[] a, int low, int high){ // O(n)
		int maxSoFar = Integer.MIN_VALUE;
		int maxEndingHere = 0;
		int start = 0, end = 0, s = 0; // To Print indices
		for(int i = low; i <= high; i++){
			maxEndingHere = maxEndingHere + a[i];
			if(maxEndingHere < 0) {
				maxEndingHere = 0;
				s = i + 1;
			}
			else if(maxSoFar < maxEndingHere)    //Optimized version of Kadane's Algorithm
				maxSoFar = maxEndingHere;
				start = s; 
				end = i;
		}

		for(int i = start; i <= end; i++) {
			System.out.print(a[i] + " ");
		}
		return maxSoFar;
	}
}

/**

Input:

8
-2 -3 4 -1 -2 1 5 -3

Output:

4 -1 -2 1 5 -3 Answer: 7

**/

//Note: Does not handle negative number cases.