class Solution {
    public int findMin(int[] nums) { // Time complexity: O(n)
        int low = 0, high = nums.length - 1;
        while(low < high) {
            if(nums[low] > nums[high]) low++;
            else if(nums[low] < nums[high]) high--;
        }
        return nums[low];
    }
}

class Solution { // Modified Binary Search
    public int findMin(int[] nums) { // Time complexity: O(log n)
        int n = nums.length;
        int left = 0, right = n - 1;

        if (nums != null && n == 1) { // single element array
            return nums[0];
        }

        if (nums[left] < nums[right]) { // sorted array
            return nums[left];
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid +1]) {
                return nums[mid + 1];
            }

            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
