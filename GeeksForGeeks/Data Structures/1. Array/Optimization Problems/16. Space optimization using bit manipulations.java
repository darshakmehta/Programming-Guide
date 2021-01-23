import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {

    public static int[] multiplesOfTwoAndFiveUsingHashingWithIntArr(int a, int b) {
        int size = a + b + 1;

        int[] hash = new int[size];

        for (int i = a; i <= b; i++) {
            if (i % 2 == 0 || i % 5 == 0) {
                hash[i] = 1;
            }
        }

        return hash;
    }

    public static boolean[] multiplesOfTwoAndFiveUsingHashingWithBoolArr(int a, int b) {
        int size = a + b + 1;

        boolean[] hash = new boolean[size];

        for (int i = a; i <= b; i++) {
            if (i % 2 == 0 || i % 5 == 0) {
                hash[i] = true;
            }
        }

        return hash;
    }

    public static boolean[] multiplesOfTwoAndFiveUsingHashingWithBoolArrSaveSpace(int a, int b) {
        int size = Math.abs(a - b) + 1;

        boolean[] hash = new boolean[size];

        for (int i = a; i <= b; i++) {
            if (i % 2 == 0 || i % 5 == 0) {
                hash[i - a] = true;
            }
        }

        return hash;
    }

    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        // Using Integer Hashing
        int[] intHash = multiplesOfTwoAndFiveUsingHashingWithIntArr(a, b);
        System.out.print("Multiples of 2 and 5 between a: " + a + " b: " + b + " are: ");
        for (int i = a; i <= b; i++) {
            if (intHash[i] == 1) {
                System.out.print(i + " ");
            }
        }

        System.out.println();

        // Using Boolean Hashing
        boolean[] boolHash = multiplesOfTwoAndFiveUsingHashingWithBoolArr(a, b);
        System.out.print("Multiples of 2 and 5 between a: " + a + " b: " + b + " are: ");
        for (int i = a; i <= b; i++) {
            if (boolHash[i]) {
                System.out.print(i + " ");
            }
        }

        System.out.println();

        // Save space by making O(|b - a|) sized array
        boolean[] boolHashSaveSpace = multiplesOfTwoAndFiveUsingHashingWithBoolArrSaveSpace(a, b);
        System.out.print("Multiples of 2 and 5 between a: " + a + " b: " + b + " are: ");
        for (int i = a; i <= b; i++) {
            if (boolHashSaveSpace[i - a]) {
                System.out.print(i + " ");
            }
        }
    }
}

// Solution: https://ideone.com/1sJxWC

/**
 * Testcase:
 * 2 10
 * 60 95
 */

/**
 * Using bit manipulation:- Bit Manipulation technique can be applied to problems mapping binary values in Arrays
 * Size of int variable in 64-bit compiler is 4 bytes.
 * 1 byte is represented by 8 bit positions in memory.
 * So, an integer in memory is represented by 32 bit positions(4 Bytes) these 32 bit positions can be used instead of
 * just one index to hash binary values.
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {

    public static boolean checkBit(int[] nums, int index) {
        int val = nums[index >> 5] & (1 << (index & 31));
        if (val == 0) {
            return false;
        }
        return true;
    }

    /**
     * To set at `index` similar to setting an index to `0` in integer array we will set a bit.
     * 1. To find array position we will right shift index by 5, in other words divide by 2^5 = 32
     * 2. From step 1, we will get position which consists of 32 bits.
     *      - Now, we will find bit position within array position found in step &
     *        set (index & 31) bit which is represented by taking modulo operation of index by 32
     *
     * for eg: setBit(arr, 4)
     * index >> 5 => 4 >> 5 i.e 4/32 = 0
     * 4 is multiple of 2, therefore find which bit position so take modulo 32
     * i.e 4 % 31 = 4 (0 based indexing). Set 4th bit to 1 i.e. left shift
     */
    public static void setBit(int[] nums, int index) {
        nums[index >> 5] |= (1 << (index & 31));
    }

    public static int[] multiplesOfTwoAndFiveUsingBitManipulation(int a, int b) {
        int size = Math.abs(b - a) + 1;

        size = (int) Math.ceil(size / 32.0); // Divide by 32, since init size of 4 byte = (4 * 8) bits

        int[] hash = new int[size];

        for (int i = a; i <= b; i++) {
            if (i % 2 == 0 || i % 5 == 0) {
                setBit(hash, i - a);
            }
        }

        return hash;
    }

    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        // Using Bit Manipulation
        int[] intHash = multiplesOfTwoAndFiveUsingBitManipulation(a, b);
        System.out.print("Multiples of 2 and 5 between a: " + a + " b: " + b + " are: ");
        for (int i = a; i <= b; i++) {
            if (checkBit(intHash, i - a)) {
                System.out.print(i + " ");
            }
        }

        System.out.println();
    }
}

// Solution: https://ideone.com/5xK7Pc

/**
 * Testcases:
 * 2 5
 * 60 95
 */

/**
 * Techniques to learn:
 * Set bit: A |= 1 << bit
 * Test bit: (A & 1 << bit) != 0
 *
 * Note: Left and Right Shift Operator
 *      int x = 200;
 * 		// Right Shift - Divides Number by 2
 * 		System.out.println("Right shift an element once " + (x >> 1));
 * 		System.out.println("Right shift an element twice " + (x >> 2));
 *
 * 		int y = 50;
 * 		// Left Shift - Multiplies Number by 2
 * 		System.out.println("Left shift an element once " + (y << 1));
 * 		System.out.println("Left shift an element twice " + (y << 2));
 *
 * Note: `|` and `&` do not do circuit operation, i.e they evaluate both the sides, useful for doing bitwise operations
 *       `||` and `&&` do the circuit evaluation, i.e they evaluate only if first value satisfies
 */
