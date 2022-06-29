class Solution {
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverseSequence(int[] nums, int i, int j) {
        while (i < j) {
         swap(nums, i++, j--);
        }
    }

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) { // Base case
            return;
        }

        int i = nums.length - 2;

        while (i >= 0 && nums[i] >= nums[i+1]) { // check for descending sequence
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;

            while (nums[j] <= nums[i]) { // find rightmost larger element
                j--;
            }
            swap(nums, i, j);
        }

        reverseSequence(nums, i + 1, nums.length - 1); // Reverse the descending sequence - next lexicographical order
    }
}
