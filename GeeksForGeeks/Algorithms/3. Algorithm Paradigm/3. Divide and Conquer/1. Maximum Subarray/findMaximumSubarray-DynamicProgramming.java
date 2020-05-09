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

    int maxSum = maxSubarray(a, 0, size - 1);
    System.out.println("Maximum Subarray Sum is: " + maxSum);
  }

  public static int maxSubarray(int a[], int low, int high) {
    int currMax = a[low];
    int maxSoFar = a[low];

    for (int i = low + 1; i <= high; i++) {
      currMax = Math.max(a[i], currMax + a[i]);
      maxSoFar = Math.max(maxSoFar, currMax);
    }

    return maxSoFar;
  }
}
