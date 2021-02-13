import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {

    public static int modifiedBinarySearch(int[] nums, int value) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {

            if (value >= nums[high]) {
                return high;
            }

            int mid = low + (high - low) / 2;

            if (nums[mid] == value) {
                return mid;
            } else if (mid > 0 && nums[mid - 1] <= value && value < nums[mid]) {
                return mid - 1;
            } else if (nums[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int floorSearch(int[] nums, int x) {
        return modifiedBinarySearch(nums, x);
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = floorSearch(arr, x);

        if (result == -1) {
            System.out.println("Floor of value x: " + x + " does not exist");
        } else {
            System.out.println("Floor of value x: " + x + " is " + arr[result]);
        }
    }
}

// Solution: https://ideone.com/B8kmMA

/*
Testcases:

7 0
1 2 8 10 10 12 19

7 1
1 2 8 10 10 12 19

7 19
1 2 8 10 10 12 19

7 20
1 2 8 10 10 12 19

7 5
1 2 8 10 10 12 19

7 12
1 2 8 10 10 12 19

7 18
1 2 8 10 10 12 19

7 10
1 2 8 10 10 12 19
 */
