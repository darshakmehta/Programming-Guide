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
    if (high == low)
      return a[low];
    else {
      int mid = (low + high) / 2;
      return Math.max(
        Math.max(
          maxSubarray(a, low, mid),
          maxSubarray(a, mid + 1, high)
        ),
        maxCrossSubarray(a, low, mid, high)
      );
    }
  }

  public static int maxCrossSubarray(int a[], int low, int mid, int high) {
    int leftSum = Integer.MIN_VALUE;
    int rightSum = Integer.MIN_VALUE;
    int sum = 0, maxLeft, maxRight;

    for (int i = mid; i >= 0; i--) {
      sum = sum + a[i];
      if (sum > leftSum) {
        leftSum = sum;
        maxLeft = i;
      }
    }

    sum = 0;

    for (int j = mid + 1; j <= high; j++) {
      sum = sum + a[j];
      if (sum > rightSum) {
        rightSum = sum;
        maxRight = j;
      }
    }

    return (leftSum + rightSum);
  }
}
