import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static int linearSearch(int[] nums, int value) { // O(n)
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static int deleteUnsorted(int[] nums, int value, int nums_in_arr) { // O(n)
        for (int i = 0; i < nums_in_arr + 1; i++) {
            if (nums[i] == value) {
                nums[i] = nums[nums_in_arr];
                nums[nums_in_arr] = -1;
                return nums_in_arr;
            }
        }
        return -1;
    }

    // For unsorted array - insert at the end
    public static int insertUnsorted(int[] nums, int value, int nums_in_arr) { // O(1)
        int n = nums.length;
        if (nums_in_arr > n) {
            return -1;
        }
        nums[nums_in_arr - 1] = value;
        return nums_in_arr; // current number of elements in array
    }

    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 5]; // To add Max. 5 more elements for the sake of insertion Logic

        // Initialize complete array to -1
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }

        // User Input 'n' elements
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int search_value = sc.nextInt(); // value to search
        int insert_value_unsorted = sc.nextInt(); // value to insert in unsorted array
        int delete_value = sc.nextInt(); // value to delete

        // Search Operation - Unsorted Array
        int result = linearSearch(arr, search_value);
        if (result == -1) {
            System.out.println("Value: " + search_value + " not found");
        } else {
            System.out.println("Value: " + search_value + " found at index " + result);
        }

        // Print initial Array
        System.out.print("Initial Array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();


        // Insert Operation - Unsorted Array
        result = insertUnsorted(arr, insert_value_unsorted, ++n);
        if (result == -1) {
            System.out.println("Array does not have enough capacity");
        } else {
            System.out.print("Insert " + "value " + insert_value_unsorted + " in unsorted Array: ");
            for (int i = 0; i < result; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        // Delete Operation - Unsorted Array
        result = deleteUnsorted(arr, delete_value, --n);
        if (result == -1) {
            System.out.println("Array does not contain value: " + delete_value);
        } else {
            System.out.print("Deleting " + "value " + delete_value + " in Array: ");
            for (int i = 0; i < result; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

    }
}

// Solution: https://ideone.com/0i4HN2

/*
Testcases:

6
12 16 20 40 50 70
50
80
12

6
12 16 20 40 50 70
12
11
70

6
12 16 20 40 50 70
90
71
81

6
12 16 20 40 50 70
12
11
11
 */
