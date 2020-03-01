/**
 * Given an array, for each element find the value of nearest element to the right which is having frequency greater than as that of current element.
 * If there does not exist an answer for a position, then make the value ‘-1’.
 * Example & Algorithm: https://www.geeksforgeeks.org/next-greater-frequency-element/
 * Input : a[] = [1, 1, 2, 3, 4, 2, 1]
 * Output : [-1, -1, 1, 2, 2, 1, -1]
 * <p>
 * Input : a[] = [1, 1, 1, 2, 2, 2, 2, 11, 3, 3]
 * Output : [2, 2, 2, -1, -1, -1, -1, 3, -1, -1]
 * CODE: https://ideone.com/dLAtNh
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
  private static void findFrequency(Map<Integer, Integer> hashMap, int[] arr) {
    for (int el : arr) {
      if (hashMap.containsKey(el)) {
        hashMap.put(el, hashMap.get(el) + 1);
      } else {
        hashMap.put(el, 1);
      }
    }
  }

  public static void main(String[] args) throws java.lang.Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    int[] result = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    if (n == 0)
      return;

    Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
    findFrequency(hashMap, arr);

    Stack<Integer> stack = new Stack<Integer>();
    stack.push(0); // push index of first element

    for (int i = 1; i < n; i++) {
      if (hashMap.get(arr[stack.peek()]) > hashMap.get(arr[i])) {
        stack.push(i);
      } else {
        while (!stack.isEmpty() && (hashMap.get(arr[stack.peek()]) < hashMap.get(arr[i]))) {
          result[stack.peek()] = arr[i];
          stack.pop();
        }
        stack.push(i);
      }
    }

    while (!stack.isEmpty()) {
      result[stack.peek()] = -1;
      stack.pop();
    }

    System.out.print(Arrays.toString(result));
  }
}
