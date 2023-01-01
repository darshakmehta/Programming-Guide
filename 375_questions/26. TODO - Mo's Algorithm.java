/**
Problem: https://leetcode.com/problems/range-sum-query-immutable/
Prefix sum solution
**/

class NumArray {
    int[] nums; // original array
    int[] cacheArr; // cached array

    public NumArray(int[] nums) {
        int n = nums.length;

        this.cacheArr = new int[n];
        cacheArr[0] = nums[0];

        for (int i = 1; i < n; i++) {
            cacheArr[i] = nums[i] + cacheArr[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return (left == 0) ? cacheArr[right] : cacheArr[right] - cacheArr[left - 1];
    }
}

/**
TODO: MO's Algorithm
**/
