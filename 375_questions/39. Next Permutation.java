class Solution {
    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static void reverseSequence(int[] nums, int i, int j) {
        while (i < j) {
         swap(nums, i++, j--);
        }
    }

    static List<Integer> prepareResult(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();

        for (int val : nums) {
            result.add(val);
        }
        return result;
    }

    static List<Integer> nextPermutationOp(int[] nums) {
        if (nums == null || nums.length <= 1) { // Base case
            return new ArrayList<Integer>();
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
        return prepareResult(nums);
    }

    static List<Integer> nextPermutation(int N, int arr[]){
        return nextPermutationOp(arr);
    }
}
