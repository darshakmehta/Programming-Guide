import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static int findMaxElement(int a[]) {
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < a.length; i++) {
			if(a[i] >= max) {
				max = a[i];
			} 
		}
		return max;
	}
	
	public static int[] countSort(int a[]) {
		int n = findMaxElement(a);
		int index[] = new int[n + 1];
		int output[] = new int[a.length];
		for(int i = 0; i < a.length; i++) {
			index[a[i]]++;
		}
		
		for(int i = 1; i < index.length; i++) {
			index[i] += index[i - 1];
		}
		
		for(int i = 0; i < a.length; i++) {
			output[index[a[i]] - 1] = a[i];
			index[a[i]]--;
		}
		return output;
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		int a[] = {4,3,7,8,9,1,2,2};
		
		a = countSort(a);
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}

/***

Counting sort is a sorting technique based on keys between a specific range. It is not a comparison based sorting. It running time complexity is O(n) with space proportional to the range of data.

Time Complexity: O(n+k) where n is the number of elements in input array and k is the range of input.
Auxiliary Space: O(n+k)

TODO: 

1. Modify above code to sort the input data in the range from M to N.
2. Modify above code to sort negative input data.
3. Is counting sort stable and online?
4. Thoughts on parallelizing the counting sort algorithm.


Reference: https://www.geeksforgeeks.org/counting-sort/

***/