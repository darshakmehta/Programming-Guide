import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    // Method 2: Using Auxillary Array
    public static List<Integer> twoRepeatingElements2(int[] nums) { // Time: O(n) and Space: O(n)
        int n = nums.length;
        List<Integer> result = new ArrayList<Integer>();
        boolean[] count = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (count[nums[i]]) {
                result.add(nums[i]);
            } else {
                count[nums[i]] = true;
            }
        }
        return result;
    }

    // Method 4: Using XOR
    public static List<Integer> twoRepeatingElements4(int[] nums) { // Time: O(n) and Space: O(1)
        int n = nums.length;
        List<Integer> result = new ArrayList<Integer>();

        // XOR of all elements
        int xor = nums[0];
        int set_bit_no, range = n - 2;
        int x = 0, y = 0;

        for (int i = 1; i < n; i++) {
            xor ^= nums[i];
        }
        for (int i = 1; i <= range; i++) {
            xor ^= i;
        }

        set_bit_no = (xor & ~(xor - 1));

        /* Now divide elements in two sets by comparing rightmost set
           bit of xor with bit at same position in each element. */
        for (int i = 0; i < n; i++) {
            int a = nums[i] & set_bit_no;
            if (a != 0) {
                x = x ^ nums[i]; /* XOR of first set in nums[] */
            }
            else {
                y = y ^ nums[i]; /* XOR of second set in nums[] */
            }
        }
        for (int i = 1; i <= range; i++) {
            int a = i & set_bit_no;
            if (a != 0) {
                x = x ^ i; /* XOR of first set in arr[] and {1, 2, ...n } */
            }
            else {
                y = y ^ i; /* XOR of second set in arr[] and {1, 2, ...n } */
            }
        }

        result.add(x);
        result.add(y);

        return result;
    }

    // Method 5: Using Array elements as index
    public static List<Integer> twoRepeatingElements5(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            if (nums[Math.abs(nums[i])] > 0) {
                nums[Math.abs(nums[i])] = -nums[Math.abs(nums[i])];
            } else {
                result.add(Math.abs(nums[i]));
            }
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

        // Using Auxillary Array
        List<Integer> result = twoRepeatingElements2(arr);
        System.out.println("Two repeating elements are: " + result.get(0) + " and " + result.get(1));

        // Using XOR
        result = twoRepeatingElements4(arr);
        System.out.println("Two repeating elements are: " + result.get(0) + " and " + result.get(1));

        // Using Array elements as index
        result = twoRepeatingElements5(arr);
        System.out.println("Two repeating elements are: " + result.get(0) + " and " + result.get(1));
    }
}

// Solution: https://ideone.com/4Asm7T

/*
Testcases:

7
4 2 4 5 2 3 1
 */

/**
 * TODO: Method 3 - Using two equations
 */

/**
 * Method 4: Explanation here: https://stackoverflow.com/a/22953668/4489066
 */
