/**
 * Given an array of n integers and q queries, print the number of next greater elements to the right of the given index element.
 * <p>
 * Examples:
 * <p>
 * Input : a[] = {3, 4, 2, 7, 5, 8, 10, 6}
 * q = 2
 * index = 0,
 * index = 5
 * Output: 4
 * 1
 * Explanation: the next greater elements
 * to the right of 3(index 0) are 4, 7, 8,
 * 10. The next greater elements to the right
 * of 8(index 5) are 10.
 * Time complexity: O(1) to answer a query.
 * Auxiliary Space: O(n)
 * CODE: https://ideone.com/jyEek0
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {

  private static void fillNext(int[] arr, int[] next, int n) {
    Stack<Integer> stack = new Stack<Integer>();
    stack.push(0); // push index of first element

    for (int i = 1; i < n; i++) {
      while (!stack.isEmpty()) {

        int cur = stack.peek();

        if (arr[cur] < arr[i]) {
          next[cur] = i;
          stack.pop();
        } else {
          break;
        }
      }
      stack.push(i);
    }

    while (!stack.isEmpty()) {
      next[stack.peek()] = -1;
      stack.pop();
    }
  }

  private static void count(int[] arr, int[] dp, int n) {
    int[] next = new int[n];

    fillNext(arr, next, n);

    for (int i = n - 2; i >= 0; i--) {
      if (next[i] == -1)
        dp[i] = 0;
      else
        dp[i] = 1 + dp[next[i]];
    }
  }

  private static int answerQuery(int[] dp, int queryValue) {
    return dp[queryValue];
  }

  public static void main(String[] args) throws java.lang.Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    int[] dp = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    if (n == 0)
      return;

    count(arr, dp, n);

    System.out.println(answerQuery(dp, 3));
    System.out.println(answerQuery(dp, 6));
    System.out.println(answerQuery(dp, 1));
  }
}
