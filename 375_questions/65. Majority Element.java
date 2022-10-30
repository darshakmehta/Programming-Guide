/**
 * Using Hashing
 * Ideone: https://ideone.com/OvU5cO
 */
class Solution {
    public static int findMajority(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            hmap.put(arr[i], hmap.getOrDefault(arr[i], 0) + 1);
            if (hmap.get(arr[i]) > (n/2)) {
                return arr[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int a[] = new int[]{2,2,2,2,5,5,2,3,3};

        System.out.print("Majority Element: " + findMajority(a));
    }
}

/**
 * Using Moore's Voting Algorithm
 * Ideone: https://ideone.com/8cvZAw
 */
class Solution {
    public static int findCandidate(int[] arr, int n) {
        int majority = arr[0];
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] == majority) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                majority = arr[i];
                count = 1;
            }
        }
        return majority;
    }

    public static boolean isMajority(int[] arr, int n, int candidate) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == candidate) {
                count++;
            }
            if (count > (n/2)) {
                return true;
            }
        }
        return false;
    }

    public static void printMajority(int[] arr) {
        int n = arr.length;
        int candidate = findCandidate(arr, n);

        if (isMajority(arr, n, candidate)) {
            System.out.println("Majority Element is: " + candidate);
        } else {
            System.out.println("No Majority Element found");
        }
    }
    public static void main(String[] args) {
        int a[] = new int[] { 1, 3, 3, 1, 2 };
        printMajority(a);
    }
}

/**
 * TODO:
 * 1. Using BST - Time: O(n^2). For self balancing BST - Time: O(nlogn)
 * 2. Using Sorting - Time: O(nlogn)
 */
