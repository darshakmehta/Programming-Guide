import java.util.*;
import java.lang.*;
import java.io.*;

class Result {
    int x;
    int y;
    int z;

    public Result(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

class Solution {
    // Method 2: Hashing
    public static Result tripletSum2(int[] nums) { // Time: O(n^2) and Space: O(n)
        int n = nums.length;
        Result result = new Result(-1, -1, -1);

        for (int i = 0; i < n - 1; i++) {
            Set<Integer> hset = new HashSet<Integer>();

            for (int j = i + 1; j < n; j++) {
                int temp = -(nums[i] + nums[j]);
                if (hset.contains(temp)) {
                    result.x = nums[i];
                    result.y = nums[j];
                    result.z = temp;
                    return result;
                }
                hset.add(nums[j]);
            }
        }

        return result;
    }

    // Method 3: Sorting
    public static Result tripletSum3(int[] nums) { // Time: O(n^2)
        int n = nums.length;
        Arrays.sort(nums);
        Result result = new Result(-1, -1, -1);

        for (int i = 0; i < n - 1; i++) {
            int low = i + 1, high = n - 1;
            int x = nums[i];

            while (low < high) {
                int temp = x + nums[low] + nums[high];
                if (temp == 0) {
                    result.x = nums[low];
                    result.y = nums[high];
                    result.z = x;
                    return result;

                    /**
                     * To print all possible solutions, uncomment following lines and remove above return statement
                     */
                    // System.out.println("Triplet with sum 0 exists as: " + result.x + " and " + result.y + " and " + result.z);
                    // low++;
                    // high--;

                } else if (temp < 0) {
                    // If sum of three elements is less
                    // than zero then increment in left
                    low++;
                } else {
                    // if sum is greater than zero than
                    // decrement in right side
                    high--;
                }
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

        Result result = tripletSum2(arr);

        if (result.x == -1 && result.y == -1 && result.z == -1) {
            System.out.println("Triplet with sum 0" + " does not exist");
        } else {
            System.out.println("Triplet with sum 0 exists as: " + result.x + " and " + result.y + " and " + result.z);
        }

        result = tripletSum3(arr);

        if (result.x == -1 && result.y == -1 && result.z == -1) {
            System.out.println("Triplet with sum 0" + " does not exist");
        } else {
            System.out.println("Triplet with sum 0 exists as: " + result.x + " and " + result.y + " and " + result.z);
        }
    }
}

// Solution: https://ideone.com/rP9PEX

/*
Testcases:

5
0 -1 2 -3 1

5
1 -2 1 0 5
 */


/**
 * Danger: Failed Solution ahead Aim: To prove O(nlogn) solution is possible. Solution: Failed to consider every index
 * Resolution: Traverse every index until possible solution is found. Which ends up as O(n^2 logn) Failed testcase:
 *
 * 5 1 -2 1 0 5
 */

class Solution { // Solution: https://ideone.com/HETAXb
    public static int binarySearch(int[] nums, int low, int high, int value) { // Time: O(logn)
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

    public static Result tripletSum(int[] nums) { // Time: O(nlogn)
        int n = nums.length;
        Arrays.sort(nums); // Time: O(nlogn)

        Result result = new Result(-1, -1, -1);
        int i = 0, j = n - 1;

        // TODO: Add external wrapper loop to traverse every index. Ends up as O(n^2 logn)
        while (i < j) {   // Time: O(nlogn)
            int temp = nums[i] + nums[j];
            int mid = binarySearch(nums, i + 1, j - 1, -temp); // Time: O(logn)
            if (mid != -1) {
                result.x = nums[i];
                result.y = nums[j];
                result.z = nums[mid];
                break;
            }

            if (temp < 0) {
                j--;
            } else {
                i++;
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

        Result result = tripletSum(arr);

        if (result.x == -1 || result.y == -1 || result.z == -1) {
            System.out.println("Triplet with sum 0" + " does not exist");
        } else {
            System.out.println("Triplet with sum 0 exists as: " + result.x + " and " + result.y + " and " + result.z);
        }
    }
}
