import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
  public static void main(String[] args) throws java.lang.Exception {
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();
    int[] a = new int[size];

    for (int i = 0; i < size; i++) {
      a[i] = sc.nextInt();
    }

    System.out.println("Maximum Subarray Sum is: " + maxSubarray(a, 0, size));
  }


  public static int maxSubarray(int[] a, int low, int high) { // O(n)
    int maxSoFar = 0, maxEndingHere = 0;
    int start = 0, end = 0; // To Print indices

    for (int i = low; i < high; i++) {
      maxEndingHere = maxEndingHere + a[i];
      if (maxEndingHere < 0) {
        maxEndingHere = 0;
        start = i + 1;
      } else if (maxSoFar < maxEndingHere) { // Consider 1 positive number exists.
        maxSoFar = maxEndingHere;
        end = i;
      }
    }

    for (int i = start; i <= end; i++) {
      System.out.print(a[i] + " ");
    }
    System.out.println();

    return maxSoFar;
  }
}

// TC: O(n)

// Solution: https://ideone.com/bYAV1r

/**
 * Input: 8 -2 -3 4 -1 -2 1 5 -3
 * Output: 4 -1 -2 1 5 -3
 * Maximum Subarray Sum is: 7
 **/

// Note: Does not handle all negative number cases.
// Acoording to Kadane's Algo, All Negative Number Array does not exist. So the sum will be 0 (size of subarrary = 0)
