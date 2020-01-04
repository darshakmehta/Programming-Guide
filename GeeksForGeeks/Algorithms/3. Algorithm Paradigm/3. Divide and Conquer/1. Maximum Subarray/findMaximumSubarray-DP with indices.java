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
		for(int i = 0; i < size; i++){
			a[i] = sc.nextInt();
		}
		Solution solution = new Solution();		
		int maxSum = solution.maxSubarray(a, 0, size -1);
		System.out.println("Answer: " + maxSum);
	}
	
	
	public int maxSubarray(int a[], int low, int high){
		int maxEndingHere = 0;
		int maxSoFar = Integer.MIN_VALUE;
		int start, end, s;
		start = end = s = 0;
		for(int i =low; i<= high; i++){
			maxEndingHere += a[i];
			if (maxEndingHere < 0) {
                maxEndingHere = 0;
                s = i + 1;
            } else if(maxSoFar < maxEndingHere){
            	maxSoFar = 	maxEndingHere;
            	start = s;
            	end = i;
            }
		}
		System.out.println("Maximum contiguous sum is "
                           + maxSoFar);
              	System.out.println("Starting index " + start);
	            System.out.println("Ending index " + end);
		return maxSoFar;
	}

}