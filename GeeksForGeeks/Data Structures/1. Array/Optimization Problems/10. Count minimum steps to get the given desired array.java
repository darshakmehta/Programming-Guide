import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    public static boolean isEven(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    public static int[] doubleArr(int[] arr) {
        // Logically we will divide by 2
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] / 2;
        }
        return arr;
    }

    public static boolean zeroArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static int minSteps(int[] nums) {
        int n = nums.length;
        int minSteps = 0;

        while (true) {
            if (zeroArr(nums)) {
                break;
            }
            if (isEven(nums)) {
                nums = doubleArr(nums);
                minSteps++;
            } else {
                // TODO: Move below logic into a function, return [new array, minSteps]
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] % 2 != 0) {
                        nums[i] = nums[i] - 1;
                        minSteps++;
                    }
                }
            }
        }
        return minSteps;
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Minimum steps to get desired array: " + minSteps(arr));
    }
}

// Solution: https://ideone.com/l5MbC8


/**
 * Following Optimization
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    public static int minSteps(int[] nums) {
        int n = nums.length;
        int minSteps = 0;

        while (true) {

            int zero_count = 0, i = 0;

            for (i = 0; i < nums.length; i++) {
                if (nums[i] % 2 != 0) {
                    break;
                } else if (nums[i] == 0) {
                    zero_count++;
                }
            }

            if (zero_count == n) {
                break;
            }

            if (i == n) { // All numbers are even
                for (int j = 0; j < nums.length; j++) {
                    nums[j] = nums[j] / 2;
                }
                minSteps++;
            }

            for (int j = i; j < nums.length; j++) {
                if (nums[j] % 2 != 0) {
                    nums[j] = nums[j] - 1;
                    minSteps++;
                }
            }
        }
        return minSteps;
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Minimum steps to get desired array: " + minSteps(arr));
    }
}

// Solution: https://ideone.com/d36ap4
