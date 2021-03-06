/***
 Given an array, print the Next Greater Element (NGE) for every element.
 The Next greater Element for an element x is the first greater element on the right side of x in array.
 Elements for which no greater element exist, consider next greater element as -1.

 Examples:

 For any array, rightmost element always has next greater element as -1.
 For an array which is sorted in decreasing order, all elements have next greater element as -1.

 For the input array [4, 5, 2, 25}, the next greater elements for each element are as follows.
 Element       NGE
 4      -->   5
 5      -->   25
 2      -->   25
 25     -->   -1

 For the input array [13, 7, 6, 12}, the next greater elements for each element are as follows.
 Element        NGE
 13      -->    -1
 7       -->     12
 6       -->     12
 12      -->     -1

 Method 1: Two loops O(n^2)
 Time Complexity: O(n^2). The worst case occurs when all elements are sorted in decreasing order.

 Method 2: Stack O(n)
 Push the first element to stack.
 Pick rest of the elements one by one and follow the following steps in loop.
 Mark the current element as next.
 If stack is not empty, compare top element of stack with next.
 If next is greater than the top element,Pop element from stack. next is the next greater element for the popped element.
 Keep popping from the stack while the popped element is smaller than next.
 next becomes the next greater element for all such popped elements
 Finally, push the next in the stack.
 After the loop in step 2 is over, pop all the elements from stack and print -1 as next element for them.
 Code: https://ideone.com/E5TkTK
 **/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {

  private static void printNextGreaterElement(int x, int y) {
    System.out.println(x + " --> " + y);
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

    Stack<Integer> stack = new Stack<Integer>();
    stack.push(arr[0]);

    for (int i = 1; i < n; i++) {
      if (stack.peek() >= arr[i]) {
        stack.push(arr[i]);
      } else {
        printNextGreaterElement(stack.pop(), arr[i]);

        while (!stack.isEmpty() && stack.peek() <= arr[i]) {
          printNextGreaterElement(stack.pop(), arr[i]);
        }
        stack.push(arr[i]);
      }
    }

    while (!stack.isEmpty()) {
      printNextGreaterElement(stack.pop(), -1);
    }
  }
}

/**
 * Time Complexity: O(n).
 * The worst case occurs when all elements are sorted in decreasing order. If elements are sorted in decreasing order,
 * then every element is processed at most 4 times.
 *
 * Initially pushed to the stack.
 * Popped from the stack when next element is being processed.
 * Pushed back to the stack because the next element is smaller.
 * Popped from the stack in step 3 of algorithm.
 **/
