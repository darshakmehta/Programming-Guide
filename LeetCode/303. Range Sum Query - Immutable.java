class NumArray {

    int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        int sum = 0;

        for ( int x = i; x <= j; x++ ) {
            sum += nums[x];
        }

        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */

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
