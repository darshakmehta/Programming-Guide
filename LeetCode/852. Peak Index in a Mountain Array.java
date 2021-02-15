class Solution {
    public int peakIndexInMountainArray(int[] nums) {
        int n = nums.length;
        int x = 1, result = 0;
        for (int i = 1; i < n - 1; i++) {
            if (x == 1) {
                if (nums[i] > nums[i - 1]) {
                    result = i;
                } else {
                    x = 2;
                }
            }
            if (x == 2) {
                if (nums[i] < nums[i + 1]) {
                    return i;
                }
            }
        }
        return result;
    }
}

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

class Solution {
    public static int peakElement(int[] nums) { // Time: O(n)
        int n = nums.length;

        if (n == 1)
            return nums[0];
        if (nums[0] >= nums[1])
            return 0;
        if (nums[n - 1] >= nums[n - 2])
            return n - 1;

        for (int i = 1; i < n - 1; i++) {
            if (nums[i] >= nums[i - 1] && nums[i] >= nums[i + 1]) {
                return i;
            }
        }
        return -1;
    }
}

class Solution {
    public static int peakElementBinarySearchUtil(int[] nums, int low, int high, int n) {
        int mid = low + (high - low) / 2;

        if ((mid == 0 || nums[mid] >= nums[mid - 1]) && (mid == n - 1 || nums[mid] >= nums[mid + 1])) {
            return mid;
        } else if (mid > 0 && nums[mid] < nums[mid - 1]) {
            return peakElementBinarySearchUtil(nums, low, mid - 1, n);
        } else {
            return peakElementBinarySearchUtil(nums, mid + 1, high, n);
        }
    }

    public static int peakElement(int[] nums) { // Time: O(logn)
        int n = nums.length;
        return peakElementBinarySearchUtil(nums, 0, n - 1, n);
    }
}
