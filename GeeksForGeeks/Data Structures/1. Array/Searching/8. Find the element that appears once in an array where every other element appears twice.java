/**
 * Various Techniques:
 *
 * 1. Brute Force - Two nested loops
 * 2. Using Formula
 * 3. Using Hashing - Loop once through the array and once through the hash table to find element appearing once
 * 4. Using XOR
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {

    // Note: x ^ x = 0 and x ^ 0 = x
    // Technique 4
    public static int appearsOnce(int[] nums) { // O(n) time and O(1) space
        int n = nums.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            result = result ^ nums[i];
        }

        return result;
    }

    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("The element appears only once is: " + appearsOnce(arr));
    }
}

// Solution: https://ideone.com/0CyEm4

/*
Testcases:

7
7 3 5 4 5 3 4

7
-2 3 5 4 5 3 4
*/

/**
 * Technique 2 - This is not an efficient approach but just another way to get the desired results. If we add each
 * number once and multiply the sum by 2, we will get twice the sum of each element of the array. Then we will subtract
 * the sum of the whole array from the twice_sum and get the required number (which appears once in the array).
 *
 * Array [] : [a, a, b, b, c, c, d] Mathematical Equation = 2 * (a + b + c + d) – (a + a + b + b + c + c + d)
 *
 * In more simple words: 2 * (sum_of_array_without_duplicates) – (sum_of_array)
 *
 * let arr[] = {7, 3, 5, 4, 5, 3, 4}
 * result = 2 * (sum_of_array_without_duplicates) - (sum_of_array)
 * result = 2 * (7 + 3 + 5 + 4) - (7 + 3 + 5 + 4 + 5 + 3 + 4)
 * result = 2 * 19 - 31 = 38 - 31 = 7 (required answer)
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
