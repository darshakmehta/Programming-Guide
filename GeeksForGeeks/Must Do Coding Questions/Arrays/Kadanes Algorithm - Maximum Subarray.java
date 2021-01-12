import java.util.*;
import java.lang.*;
import java.io.*;

/*
Time Complexity: O(n)
Space Complexity: O(1) excluding input array space
Algorithmic Paradigm: Dynamic Programming
 */

class kadanes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t != 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int maxSoFar = a[0];
            int currMax = a[0];

            // Handles all negative elements in array
            for (int i = 1; i < a.length; i++) {
                currMax = Math.max(a[i], a[i] + currMax);
                maxSoFar = Math.max(maxSoFar, currMax);
            }
            System.out.println(maxSoFar);

            t--;
        }
    }
}

/***
 * Sample Test cases
 */

/*

Solution: https://ideone.com/f595D2

Input:

3
8
-2 -3 4 -1 -2 1 5 -3
5
4 5 6 7 8
5
-1 -2 -3 -4 -5

Output:
7
30
-1

 */

/* Print subarray Elements */

import java.util.*;
import java.lang.*;
import java.io.*;

class printSubarrElementKadanes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int max_so_far = arr[0];
        int max_ending_here = arr[0];
        int start = 0;
        int end = 0;
        int currIndex = 0;

        for (int i = 0; i < n; i++) {
            max_ending_here = max_ending_here + arr[i];

            if (max_ending_here < 0) {
                max_ending_here = 0;
                // When current sum is negative reset sum to 0 and start with next index
                currIndex = i + 1;
            } else if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
                start = currIndex;
                end = i;
            }
        }

        System.out.println(max_so_far);

        System.out.print("Subarr: ");


        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}


/*

Solution: https://ideone.com/C3Lz2b

Input:

8
-2 -3 4 -1 -2 1 5 -3

Output:
7
Subarr: 4 -1 -2 1 5

 */


/**
 * TODO: Given an array of integers (possibly some of the elements negative), write a C program to find out the *maximum
 * product* possible by multiplying ‘n’ consecutive integers in the array where n <= ARRAY_SIZE. Also print the starting
 * point of maximum product subarray.
 */
