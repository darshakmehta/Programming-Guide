class Solution { // Iterative
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;

        while (low < high) {
            int mid1 = low + (high - low) / 2;
            int mid2 = mid1 + 1;
            if (nums[mid1] < nums[mid2])
                low = mid2;
            else
                high = mid1;
        }

        return low;
    }
}

class Solution { // Recursive
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        return findPeakElementUtil(nums, 0, n - 1);
    }

    public int findPeakElementUtil(int[] nums, int low, int high) {
        if (low == high) return low;
        int mid1 = low + (high - low) / 2;
        int mid2 = mid1 + 1;
        if (nums[mid1] < nums[mid2])
            return findPeakElementUtil(nums, mid2, high);
        else
            return findPeakElementUtil(nums, low, mid1);
    }
}

class Solution { // Sequential Search
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return n - 1;
    }
}
