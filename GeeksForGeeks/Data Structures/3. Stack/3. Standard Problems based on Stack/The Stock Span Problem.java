/**
 * The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we
 * need to calculate span of stock’s price for all n days. The span Si of the stock’s price on a given day i is
 * defined as the maximum number of consecutive days just before the given day, for which the price of the stock on
 * the current day is less than or equal to its price on the given day. For example, if an array of 7 days prices is
 * given as {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}
 * <p>
 * A Simple but inefficient method: O(n^2)
 * Traverse the input price array. For every element being visited, traverse elements on left of it and increment the
 * span value of it while elements on the left side are smaller.
 * CODE: TODO
 * <p>
 * A Linear Time Complexity Method
 * We see that S[i] on day i can be easily computed if we know the closest day preceding i, such that the price is
 * greater than on that day than the price on day i. If such a day exists, let’s call it h(i), otherwise,
 * we define h(i) = -1. The span is now computed as S[i] = i – h(i).
 * To implement this logic, we use a stack as an abstract data type to store the days i, h(i), h(h(i)) and so on.
 * When we go from day i-1 to i, we pop the days when the price of the stock was less than or equal to price[i]
 * and then push the value of day i back into the stack.
 * Time Complexity: O(n). It seems more than O(n) at first look.
 * If we take a closer look, we can observe that every element of array is added and removed from stack at most once.
 * So there are total 2n operations at most. Assuming that a stack operation takes O(1) time,
 * we can say that the time complexity is O(n).
 * Auxiliary Space: O(n) in worst case when all elements are sorted in decreasing order.
 * CODE: https://ideone.com/Z2xqqH
 * <p>
 * Another approach: (without using stack)
 * CODE: https://ideone.com/Vk8xIQ
 */

// Using Stack

import java.lang.*;
import java.util.*;
import java.io.*;

class StockSpanProblem {

  public static void calculateSpan(int[] price, int n, int[] span) {
    Stack<Integer> stack = new Stack<Integer>();
    span[0] = 1; // span value of first element is always 1
    stack.push(0); // index of first element

    for (int i = 1; i < n; i++) {

      // Pop elements from stack while stack is not
      // empty and top of stack is smaller than
      // price[i]
      while (!stack.empty() && price[stack.peek()] <= price[i])
        stack.pop();

      // If stack becomes empty, then price[i] is
      // greater than all elements on left of it, i.e.,
      // price[0], price[1], ..price[i-1]. Else price[i]
      // is greater than elements after top of stack
      span[i] = (stack.empty()) ? (i + 1) : (i - stack.peek());

      // Push this element to stack
      stack.push(i);
    }
  }

  public static void main(String[] arg) {
    int[] price = {10, 4, 5, 90, 120, 80};
    int n = price.length;
    int[] span = new int[n];

    // Fill the span values in array span[]
    calculateSpan(price, n, span);

    // print the calculated span values
    System.out.print(Arrays.toString(span));
  }
}

// Without Using Stack

import java.lang.*;
import java.util.*;
import java.io.*;

class StockSpanProblem {

  public static void calculateSpan(int[] price, int n, int[] span) {
    span[0] = 1; // span value of first element is always 1

    for (int i = 1; i < n; i++) {
      int counter = 1;
      while ((i - counter) >= 0 && price[i] > price[i - counter]) {
        counter += span[i - counter];
      }
      span[i] = counter;
    }
  }

  public static void main(String[] arg) {
    int[] price = {10, 4, 5, 90, 120, 80};
    int n = price.length;
    int[] span = new int[n];

    // Fill the span values in array span[]
    calculateSpan(price, n, span);

    // print the calculated span values
    System.out.print(Arrays.toString(span));
  }
}
