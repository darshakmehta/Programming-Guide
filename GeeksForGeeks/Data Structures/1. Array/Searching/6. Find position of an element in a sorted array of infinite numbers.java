import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {

    public static int binarySearch(int[] nums, int value, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == value) {
                return mid;
            } else if (nums[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int infiniteArrFindPosition(int[] nums, int key) {
        int n = nums.length;
        int low = 0;
        int high = 1;

        int val = nums[low];

        // Find high to do binary search
        while (val < key) {
            low = high;     // store previous high
            // check that 2*h doesn't exceeds array
            // length to prevent ArrayOutOfBoundException
            if (2 * high < n - 1)
                high = 2 * high;
            else
                high = n - 1;

            val = nums[high]; // update new val
        }

        return binarySearch(nums, key, low, high);
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int key = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = infiniteArrFindPosition(arr, key);

        if (result == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element: " + key + " found at index: " + result);
        }
    }
}

/**
 * Let p be the position of element to be searched. Number of steps for finding high index ‘h’ is O(Log p). The value of
 * ‘h’ must be less than 2*p. The number of elements between h/2 and h must be O(p). Therefore, time complexity of
 * Binary Search step is also O(Log p) and overall time complexity is 2*O(Log p) which is O(Log p).
 */

// Solution: https://ideone.com/DZcWRt

/*
Testcases:
11 10
3 5 7 9 10 90 100 130 140 160 170

11 101
3 5 7 9 10 90 100 130 140 160 170
*/
