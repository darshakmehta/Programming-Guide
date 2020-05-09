import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
  public static void main(String[] args) throws java.lang.Exception {
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();
    int a[] = new int[size];

    for (int i = 0; i < size; i++) {
      a[i] = sc.nextInt();
    }

    System.out.println("Maximum Subarray Sum is: " + maxSubarray(a));
  }

  public static int maxSubarray(int[] a) {
    int maxSum = Integer.MIN_VALUE;

    for (int i = 0; i < a.length; i++) {
      int sum = 0;
      for (int j = i; j < a.length; j++) {
        sum = sum + a[j];
        maxSum = Math.max(maxSum, sum); // Key step: Find the maximum at each step to cover the smaller subarrays
      }
    }

    return maxSum;
  }
}

// Code: https://ideone.com/gOTMYY
