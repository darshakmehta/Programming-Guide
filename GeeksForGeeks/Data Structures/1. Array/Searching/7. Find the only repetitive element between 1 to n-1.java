/**
 * Various Techniques:
 *
 * 1. Brute Force - Two nested loops
 * 2. Using Sum of first (n - 1) intergers formular (n * (n - 1) / 2)
 * 3. Using Hashing - refer to table and on occurence of an element second time return it. (HashSet or HashMap)
 * 4. Using XOR
 * 5. Using indexing - Hard to think
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    // Technique 2
    public static int repetitiveElement2(int[] nums) { // O(n) Time and O(1) Space
        int n = nums.length;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        return (sum - (n * (n - 1) / 2));
    }

    /**
     * The idea is based on the fact that x ^ x = 0 and x ^ y = y ^ x and x ^ 0 = x
     * 1) Compute XOR of elements from 1 to n - 1.
     * 2) Compute XOR of array elements.
     * 3) XOR of above two would be our result.
     *
     */
    // Technique 4
    public static int repetitiveElement4(int[] nums) { // O(n) Time and O(1) Space
        int n = nums.length;

        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            result = result ^ (i + 1) ^ nums[i];
        }

        return result ^ nums[n - 1];
    }

    /**
     * 1. Iterate through the array.
     * 2. For every index visit a[index], if it is positive change the sign of element at a[index] index, else print the element.
     */
    // Technique 5
    public static int repetitiveElement5(int[] nums) { // O(n) Time and O(1) Space
        int n = nums.length;

        int repetitiveElement = 0;

        for (int i = 0; i < n; i++){
            int element = nums[Math.abs(nums[i])];

            if (element < 0) {
                repetitiveElement = nums[i];
                break;
            }

            nums[Math.abs(nums[i])] = -nums[Math.abs(nums[i])];
        }

        return Math.abs(repetitiveElement);
    }

    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("The repetitive element is: " + repetitiveElement2(arr));
        System.out.println("The repetitive element is: " + repetitiveElement4(arr));
        System.out.println("The repetitive element is: " + repetitiveElement5(arr));
    }
}


// Solution: https://ideone.com/xVVSWm

/*
Testcases:

6
1 5 1 2 3 4

5
1 3 2 3 4

10
9 8 2 6 1 8 5 3 4 7

10
5 4 3 9 8 9 1 6 2 7
*/
