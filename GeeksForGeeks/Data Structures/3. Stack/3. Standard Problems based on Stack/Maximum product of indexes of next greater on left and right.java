/***
 Given an array a[1..N]. For each element at position i (1 <= i <= N). Where

 L(i) is defined as closest index j such that j < i and a[j] > a[i]. If no such j exists then L(i) = 0.
 R(i) is defined as closest index k such that k > i and a[k] > a[i]. If no such k exists then R(i) = 0.
 LRProduct(i) = L(i)*R(i) .

 We need to find an index with maximum LRProduct

 Examples:

 Input : 1 1 1 1 0 1 1 1 1 1
 Output : 24
 For {1, 1, 1, 1, 0, 1, 1, 1, 1, 1} all element are same except 0. So only for zero their exist greater element and
 for others it will be zero. for zero, on left 4th element is closest and greater than zero
 and on right 6th element is closest and greater. so maximum
 product will be 4*6 = 24.

 Input : 5 4 3 4 5
 Output : 8
 For {5, 4, 3, 4, 5}, L[] = {0, 1, 2, 1, 0} and R[]
 = {0, 5, 4, 5, 0},
 LRProduct = {0, 5, 8, 5, 0} and max in this is 8.

 Note: Taking starting index as 1 for finding LRproduct.

 This problem is based on Next Greater Element.

 From the current position, we need to find the closest greater element on its left and right side.
 So to find next greater element, we used stack one from left and one from right.
 simply we are checking which element is greater and storing their index at specified position.
 1- if stack is empty, push current index.
 2- if stack is not empty
 ….a) if current element is greater than top element then store the index of current element on index of top element.

 Do this, once traversing array element from left and once from right and form the left and right array,
 then, multiply them to find max product value.
 **/

// Code: https://ideone.com/jzwyIm
import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {

  public static int[] leftNextGreaterElement(int[] arr, int n) {
    int[] left = new int[n];
    Stack<Integer> stack = new Stack<Integer>();

    for (int i = n - 1; i >= 0; i--) {
      while (stack.size() != 0 && arr[i] > arr[stack.peek() - 1]) {
        int r = stack.pop();
        left[r - 1] = i + 1;
      }

      stack.push(i + 1);
    }

    return left;
  }

  public static int[] rightNextGreaterElement(int[] arr, int n) {
    int[] right = new int[n];
    Stack<Integer> stack = new Stack<Integer>();

    for (int i = 0; i < n; i++) {
      while (stack.size() != 0 && arr[i] > arr[stack.peek() - 1]) {
        int r = stack.pop();
        right[r - 1] = i + 1;
      }

      stack.push(i + 1);
    }

    return right;
  }

  public static int findMaxProd(int[] arr, int n) {
    /* Step 1: Find L[i] using Next Greater Element - O(n) */
    int[] left = leftNextGreaterElement(arr, n);

    /* Step 2: Find R[i] using Next Greater Element - O(n) */
    int[] right = rightNextGreaterElement(arr, n);

    int result = -1;

    /* Step 3: Find LR Product - O(n) */
    for (int i = 0; i < n; i++) {
      result = Math.max(result, left[i] * right[i]);
    }

    return result;
  }

  public static void main(String[] args) throws java.lang.Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    if (n == 0)
      return;

    System.out.println("Max Product of indexes of next Greater Left and Right is " + findMaxProd(arr, n));
  }
}

/**
 * Time Complexity: O(n)
 */
