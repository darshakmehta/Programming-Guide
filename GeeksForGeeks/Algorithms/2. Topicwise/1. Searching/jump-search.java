import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int a[] = { 0, 1, 1, 2, 3, 5, 8, 13, 21,
                    34, 55, 89, 144, 233, 377, 610};
        int v = 55;
		Solution solution = new Solution();

		int index = solution.jumpSearch(a, v);
		if(index == -1) {
			System.out.println("Value: " + v + " not found");
		}else {
			System.out.println("Value: "+ v + " found at index " + index);
		}
	}
	
	public int jumpSearch(int a[], int x){  
		int n = a.length;

		// Finding block size to be jumped
        int step = (int)Math.floor(Math.sqrt(n));

        int prev = 0;
        // Finding the block where element is
        // present (if it is present)
        while (a[Math.min(step, n)-1] < x) { //To avoid array index out of bound exception
            prev = step;
            step += (int)Math.floor(Math.sqrt(n));
            if (prev >= n)
                return -1;
        }

        // Doing a linear search for x in block
        // beginning with prev.
        while (a[prev] < x) {
            prev++;
 
            // If we reached next block or end of
            // array, element is not present.
            if (prev == Math.min(step, n))
                return -1;
        }

        // If element is found
        if (a[prev] == x)
            return prev;
 
        return -1;
	}

}

/***

Iterative Solution:

Time complexity: O(sqrt(n))
Space complexity: O(1)

Note: Jump search requires the array to be sorted

Important points:

Works only sorted arrays.
The optimal size of a block to be jumped is O(√ n). This makes the time complexity of Jump Search O(√ n).
The time complexity of Jump Search is between Linear Search ( ( O(n) ) and Binary Search ( O (Log n) ).
Binary Search is better than Jump Search, but Jump search has an advantage that we traverse back only once (Binary Search may require up to O(Log n) jumps, consider a situation where the element to be search is the smallest element or smaller than the smallest). So in a systems where jumping back is costly, we use Jump Search.

***/