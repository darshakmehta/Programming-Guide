import java.util.*;
import java.lang.*;
import java.io.*;

class Result {
    int floor;
    int ceil;

    public Result(int floor, int ceil) {
        this.floor = floor;
        this.ceil = ceil;
    }
}

class Solution {

    public static int modifiedCeilBinarySearch(int[] nums, int value) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {

            if (value <= nums[low]) {
                return low;
            }
            if (value > nums[high]) {
                return -1;
            }

            int mid = low + (high - low) / 2;

            if (nums[mid] == value) {
                return mid;
            } else if ((mid + 1) <= high && value <= nums[mid + 1]) {
                return mid + 1;
            } else if (nums[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid - 1) >= low && value > nums[mid - 1]) {
                    return mid;
                }
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int modifiedFloorBinarySearch(int[] nums, int value) {
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

    public static Result floorAndCeilSearch(int[] nums, int x) {
        int n = nums.length;
        Result result = new Result(Integer.MIN_VALUE, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            if (nums[i] <=  x) {
                result.floor = Math.max(result.floor, nums[i]);
            }
            if (nums[i] >= x) {
                result.ceil = Math.min(result.ceil, nums[i]);
            }
        }

        return result;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Result result = floorAndCeilSearch(arr, x);

        if (result.floor == Integer.MIN_VALUE) {
            System.out.println("Floor of value x: " + x + " does not exist");
        } else {
            System.out.println("Floor of value x: " + x + " is " + result.floor);
        }

        if (result.ceil == Integer.MAX_VALUE) {
            System.out.println("Ceil of value x: " + x + " does not exist");
        } else {
            System.out.println("Ceil of value x: " + x + " is " + result.ceil);
        }
    }
}

/**
 * Technique 1: Sort the array and apply binary search. Sorting takes O(n log n) time complexity.
 * Note: Technique 1 is more useful to answer more queries which takes O(log n) time for every query after sorting.
 * Technique 2: Linear Search. O(n) Time complexity
 * Note: Technique 2 is more useful to answer few queries which takes O(n) time for every query.
 */

// Solution: https://ideone.com/ZiaDTj

/*
Testcases:

8 7
5 6 8 9 6 5 5 6

8 6
5 6 8 9 6 5 5 6

8 10
5 6 8 9 6 5 5 6

8 1
5 6 8 9 6 5 5 6
*/
