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
    public static Result tripletSum2(int[] nums, int sum) { // Time: O(n^2) and Space: O(n)
        int n = nums.length;
        Result result = new Result(-1, -1, -1);

        for (int i = 0; i < n - 2; i++) {
            Set<Integer> hset = new HashSet<Integer>();
            int curr_sum = sum - nums[i];

            for (int j = i + 1; j < n; j++) {
                int temp = curr_sum - nums[j];
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
    public static Result tripletSum3(int[] nums, int sum) { // Time: O(n^2)
        int n = nums.length;
        Arrays.sort(nums);
        Result result = new Result(-1, -1, -1);

        for (int i = 0; i < n - 2; i++) {
            int low = i + 1, high = n - 1;

            while (low < high) {
                int temp = nums[i] + nums[low] + nums[high];
                if (temp == sum) {
                    result.x = nums[low];
                    result.y = nums[high];
                    result.z = nums[i];
                    return result;

                    /**
                     * To print all possible solutions, uncomment following lines and remove above return statement
                     */
                    // System.out.println("Triplet with sum 0 exists as: " + result.x + " and " + result.y + " and " + result.z);
                    // low++;
                    // high--;

                } else if (temp < sum) {
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
        int sum = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Result result = tripletSum2(arr, sum);

        if (result.x == -1 && result.y == -1 && result.z == -1) {
            System.out.println("Triplet with sum " + sum + " does not exist");
        } else {
            System.out.println("Triplet with sum " + sum + " exists as: " + result.x + " and " + result.y + " and " + result.z);
        }

        result = tripletSum3(arr, sum);

        if (result.x == -1 && result.y == -1 && result.z == -1) {
            System.out.println("Triplet with sum " + sum + " does not exist");
        } else {
            System.out.println("Triplet with sum " + sum + " exists as: " + result.x + " and " + result.y + " and " + result.z);
        }
    }
}


// Solution: https://ideone.com/WHSBOF

/*
Testcases:

6 22
1 4 45 6 10 8

6 24
12 3 4 1 6 9

5 9
1 2 3 4 5
 */
