import java.util.*;
import java.lang.*;
import java.io.*;

class Solution { // Prefix Sum using Hashing to handle negative numbers
    public static int[] subArraySum(int[] nums, int sum) {
        int n = nums.length;
        if (n == 0) {
            return new int[]{-1, -1};
        }

        int curr_sum = 0, start = 0, end = -1;
        Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            curr_sum = curr_sum + nums[i];

            int maybeSum = curr_sum - sum;
            // if 0, subarray starts at index 0
            if (maybeSum == 0) {
                start = 0;
                end = i;
                break;
            }

            // if hashMap has the value, we already have subarray
            if (hmap.containsKey(maybeSum)) {
                start = hmap.get(maybeSum) + 1;
                end = i;
                break;
            }

            hmap.put(curr_sum, i);
        }

        return new int[]{start, end};
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] result = subArraySum(arr, sum);

        if (result[0] == -1 || result[1] == -1) {
            System.out.println("Cannot be formed");
            return;
        }
        System.out.println("Continuous subarray is start index: " + result[0] + " and end index: " + result[1]);
        for (int i = result[0]; i <= result[1]; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

// Time Complexity: O(n); Space Complexity: O(n)

// Solution: https://ideone.com/WedUnm

/*
Testcases:

6 20
-10 0 2 -2 -20 10

5 -10
10 2 -2 -20 10

6 33
1 4 20 3 10 5

6 51
1 4 45 6 0 19
*/
