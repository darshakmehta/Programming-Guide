/**
 * Ideone: https://ideone.com/InHVen
 * Time: O(n^3) Solution
 */
class Result {
    int w, x, y, z;

    public Result(int w, int x, int y, int z) {
        this.w = w;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

class Solution {
    public static Result fourElementSum(int[] nums, int sum) { // Time: O(n^3)
        int n = nums.length;
        Arrays.sort(nums);
        Result result = new Result(-1, -1, -1, -1);

        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                int low = j + 1, high = n - 1;

                while (low < high) {
                    int temp = nums[i] + nums[j] + nums[low] + nums[high];
                    if (temp == sum) {
                        result.w = nums[low];
                        result.x = nums[high];
                        result.y = nums[i];
                        result.z = nums[j];
                        return result;
                        // Do not return if you want to find all possible solutions
                        // Just print them here
                    } else if (temp < sum) {
                        low++;
                    } else {
                        high--;
                    }
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

        Result result = fourElementSum(arr, sum);

        if (result.x == -1 && result.y == -1 && result.z == -1) {
            System.out.println("Four Elements with sum " + sum + " does not exist");
        } else {
            System.out.println("Four Elements with sum " + sum + " exists as: " + result.w + " and " + result.x
                    + " and " + result.y + " and " + result.z);
        }
    }
}

/**
 * Testcases:
 *
 * 8 23
 * 10 2 3 4 5 9 7 8
 *
 * 6 91
 * 10 20 30 40 1 2
 */

/**
 * TODO:
 * 1. Two Pointer Solution: Time: O(n^2Logn) and Space: O(n^2)
 * 2. Hashing based Solution: Time: O(n^2) and Space: O(n^2)
 * 3. Solution when no duplicate elements: Time: O(n^2) and Space: O(n^2)
 */
