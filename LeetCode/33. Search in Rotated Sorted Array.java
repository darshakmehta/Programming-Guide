class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length < 1) return -1;
        int minIdx = findMinIdx(nums);
        if (target == nums[minIdx]) return minIdx;
        int m = nums.length;
        int start = (target <= nums[m - 1]) ? minIdx : 0;
        int end = (target > nums[m - 1]) ? minIdx : m - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            else if (target > nums[mid]) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }

    public int findMinIdx(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end -  start) / 2;
            if (nums[mid] > nums[end]) start = mid + 1;
            else end = mid;
        }
        return start;
    }
}

class Solution { // Modified Binary Search
    public int search(int[] nums, int target) { // Time complexity: O(log n)
        int n = nums.length;
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[left] == target) {
                return left;
            } else if (nums[right] == target) {
                return right;
            }

            if (nums[left] <= nums[mid]) { // check if sorted
                if (target >= nums[left] && target < nums[mid]) { // check if target is in sorted range
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            if (nums[mid] <= nums[right]) { // check if sorted
                if (target <= nums[right] && target > nums[mid]) { // check if target is in sorted range
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
