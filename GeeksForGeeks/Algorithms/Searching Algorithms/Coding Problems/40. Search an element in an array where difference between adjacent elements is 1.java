import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static int findElement(int[] nums, int x) { // O(n)
        int n = nums.length;
        int index = -1;

        for (int i = 0; i < n; ) {
            if (nums[i] == x) {
                index = i;
                break;
            }
            i += Math.abs(nums[i] - x);
        }

        return index;
    }

    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = findElement(arr, x);
        if (result != -1) {
            System.out.println("Element x: " + x + " found at index: " + result);
        } else {
            System.out.println("Element x: " + x + " not found");
        }
    }
}

// Solution: https://ideone.com/owkWYy

/*
Testcases:

12 3
8 7 6 7 6 5 4 3 2 3 4 3

6 5
1 2 3 4 5 4

6 9
1 2 3 4 5 8
 */
