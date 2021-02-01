/**
 * Union of two sorted arrays
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution { // Note: Both the arrays are sorted
    // Does not handle duplicates in any of the array
    public static List<Integer> union(int[] arr1, int[] arr2) { // Time: O(n1 + n2)
        int n1 = arr1.length;
        int n2 = arr2.length;

        List<Integer> result = new ArrayList<Integer>(); // Space: O(n1 + n2)

        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                result.add(arr1[i]);
                i++;
            } else if (arr1[i] > arr2[j]) {
                result.add(arr2[j]);
                j++;
            } else {
                result.add(arr1[i]); // common elements
                i++;
                j++;
            }
        }

        while (i < n1) {
            result.add(arr1[i++]);
        }

        while (j < n2) {
            result.add(arr2[j++]);
        }

        return result;
    }

    // Handle duplicates in any of the array using integer storage
    public static List<Integer> unionHandleDuplicate(int[] arr1, int[] arr2) { // Time: O(n1 + n2)
        int n1 = arr1.length;
        int n2 = arr2.length;

        int a = arr1[n1 - 1];
        int b = arr2[n2 - 1];

        int maxValue = 0;

        if (a > b) {
            maxValue = a;
        } else {
            maxValue = b;
        }

        int[] dp = new int[maxValue + 1]; // Space: O(max(a, b))
        List<Integer> result = new ArrayList<Integer>(); // O(n1 + n2)

        result.add(arr1[0]);

        ++dp[arr1[0]]; // First element is always present in the final result

        for (int i = 1; i < n1; i++) {
            if (arr1[i] != arr1[i - 1]) {
                result.add(arr1[i]);
                ++dp[arr1[i]];
            }
        }

        for (int i = 0; i < n2; i++) {
            if (dp[arr2[i]] == 0) { // find elements not yet found in dp
                result.add(arr2[i]);
                ++dp[arr2[i]];
            }
        }

        return result;
    }

    // Handle duplicates in any of the array using boolean storage to save space
    public static List<Integer> unionHandleDuplicateUsingBool(int[] arr1, int[] arr2) { // Time: O(n1 + n2)
        int n1 = arr1.length;
        int n2 = arr2.length;

        int a = arr1[n1 - 1];
        int b = arr2[n2 - 1];

        int maxValue = 0;

        if (a > b) {
            maxValue = a;
        } else {
            maxValue = b;
        }

        boolean[] dp = new boolean[maxValue + 1]; // Space: O(max(a, b))
        List<Integer> result = new ArrayList<Integer>(); // Space: O(n1 + n2)

        result.add(arr1[0]);

        dp[arr1[0]] = true; // First element is always present in the final result

        for (int i = 1; i < n1; i++) {
            if (arr1[i] != arr1[i - 1]) {
                result.add(arr1[i]);
                dp[arr1[i]] = true;
            }
        }

        for (int i = 0; i < n2; i++) {
            if (!dp[arr2[i]]) { // find elements not yet found in dp
                result.add(arr2[i]);
                dp[arr2[i]] = true;
            }
        }

        return result;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt(); // size of first array
        int n2 = sc.nextInt(); // size of second array

        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }

        // Does not handle duplicate
        List<Integer> result = union(arr1, arr2);
        System.out.print("Union of two array is: ");

        for (int el : result) {
            System.out.print(el + " ");
        }

        System.out.println();

        // Handles Duplicate in any of the Array using integer storage
        result = union(arr1, arr2);
        System.out.print("Union of two array is: ");

        for (int el : result) {
            System.out.print(el + " ");
        }

        System.out.println();

        // Handles Duplicate in any of the Array using boolean storage
        result = union(arr1, arr2);
        System.out.print("Union of two array is: ");

        for (int el : result) {
            System.out.print(el + " ");
        }

        System.out.println();
    }
}

// Solution: https://ideone.com/mGNFm4

/**
 * Interesection of two sorted arrays
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution { // Note: Both the arrays are sorted
    // Handle duplicates in any of the array using HashSet
    public static List<Integer> intersection(int[] arr1, int[] arr2) { // Time: O(n1 + n2)
        int n1 = arr1.length;
        int n2 = arr2.length;

        List<Integer> result = new ArrayList<Integer>(); // Space: O(n1 + n2)
        // Set<Integer> hset = new HashSet<Integer>(); // Check if element already found to handle duplicate
        // Note: Since array is sorted, use the previous added element to find duplicates
        int previous = 0;

        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else {
                if (previous != arr1[i]) { // handle duplicates
                    result.add(arr1[i]);
                    // hset.add(arr1[i]);
                    previous = arr1[i];

                }
                i++;
                j++;
            }
        }

        return result;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt(); // size of first array
        int n2 = sc.nextInt(); // size of second array

        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }

        List<Integer> result = intersection(arr1, arr2);
        System.out.print("Intersection of two array is: ");

        for (int el : result) {
            System.out.print(el + " ");
        }

        System.out.println();
    }
}

// Solution: https://ideone.com/Qxecc8

/**
 * Note: Another approach that is useful when difference between sizes of two given arrays is significant. The idea is
 * to iterate through the shorter array and do a binary search for every element of short array in big array (note that
 * arrays are sorted). Time complexity of this solution is O(min(mLogn, nLogm)). This solution works better than the
 * above approach when ratio of larger length to smaller is more than logarithmic order.
 */

/**
 * Above solutions can be extended to find common elements within more than 2 arrays. By solving for first 2 arrays and
 * extending resultant solution to next following array of elements.
 */
