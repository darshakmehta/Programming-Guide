import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{

	public int gcd(int a, int b) { 
        if (b == 0) 
            return a; 
        else
            return gcd(b, a % b); 
    } 

    public void leftRotate(int arr[], int k, int n) {

		int j, temp, x;
    	for(int i = 0; i < gcd(k, n); i++) {
    		temp = arr[i];
    		j = i;
  			while ( true ) {
  				x = j + k;
  				if (x >= n)
  					x = x - n;
  				if (x == i)
  					break;
  				arr[j] = arr[x];
  				j = x;
      		}
      		arr[j] = temp;
      	}
      }

    public void juggling(int[] nums, int k) {
        int n = nums.length;
        int x = gcd(k, n);

        
        for ( int i = 0; i < x; i++ ) {
            
            int temp = nums[n - i - 1];
    		int j = n - i - 1;

    		while ( true ) {
                int d = j - k;
                if ( d < 0 ) d += n;
                if ( d == n - i - 1) break;
                nums[j] = nums[d];
                j = d;
            }
    		nums[j] = temp; 
    	}
    }

	public static void main (String[] args) throws java.lang.Exception
	{
		// Left Rotate by k
		/* Method 1 */
		int a[] = new int[]{9, 4, 7, 8, 10};
		int n = a.length;
		int k = 2;
		
		int x = k % n;
		int copy[] = new int[a.length];
		if (x != 0) {
			System.arraycopy(a, x, copy, 0, n - x);
			System.arraycopy(a, 0, copy, n - x, x);
			System.arraycopy(copy, 0, a, 0, n);
		}
		
		for(int i : a) {
			System.out.print(i + " ");
		}

		/* Method 3 */
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 }; 
		new Solution().leftRotate(arr, k, arr.length);
		System.out.println();
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}
}


/***

Method 1: Temporary Array
Time complexity : O(n)
Auxiliary Space : O(n) --> TODO: O(k)

Method 2: Rotate one by one: Temp first element of array and rotate n - 1 elements and store temp to last position, Rotate for k times

Time complexity : O(n * k)
Auxiliary Space : O(1)

Method 3: A Juggling Algorithm

Time complexity : O(n)
Auxiliary Space : O(1)


Method 4: In-place Rotation <-- TODO
Time complexity : O(n)
Auxiliary Space : O(1)

Method 5: Reversal Algorithm

rotate(arr[], d, n)
  reverse(arr[], 1, d) ;
  reverse(arr[], d + 1, n);
  reverse(arr[], 1, n);
Let AB are the two parts of the input array where A = arr[0..d-1] and B = arr[d..n-1]. The idea of the algorithm is :

Reverse A to get ArB, where Ar is reverse of A.
Reverse B to get ArBr, where Br is reverse of B.
Reverse all to get (ArBr) r = BA.

Example :
Let the array be arr[] = [1, 2, 3, 4, 5, 6, 7], d =2 and n = 7
A = [1, 2] and B = [3, 4, 5, 6, 7]

Reverse A, we get ArB = [2, 1, 3, 4, 5, 6, 7]
Reverse B, we get ArBr = [2, 1, 7, 6, 5, 4, 3]
Reverse all, we get (ArBr)r = [3, 4, 5, 6, 7, 1, 2]

Method 6: Block Swap Algorithm

Algorithm :

Initialize A = arr[0..d-1] and B = arr[d..n-1]
1) Do following until size of A is equal to size of B

  a)  If A is shorter, divide B into Bl and Br such that Br is of same 
       length as A. Swap A and Br to change ABlBr into BrBlA. Now A
       is at its final place, so recur on pieces of B.  

   b)  If A is longer, divide A into Al and Ar such that Al is of same 
       length as B Swap Al and B to change AlArB into BArAl. Now B
       is at its final place, so recur on pieces of A.

2)  Finally when A and B are of equal size, block swap them.

***/
