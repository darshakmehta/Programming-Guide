/**
 * Using Sorting
 */
class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums); // Time: O(nlogn)
        int median = nums[n/2];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.abs(median - nums[i]);
        }

        return sum;
    }
}

/**
 * Using Quick Select
 * Reference: https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/solutions/2215782/visual-explanation-interview-tips-java/
 *
 */
class Solution {
    public void swap(int nums[], int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public int partition(int[] nums, int left, int right, int partitionIndex) {
        int pivot = nums[partitionIndex];
        swap(nums, partitionIndex, right);
        partitionIndex = left;

        for (int i = left; i <= right; i++) {
            if (nums[i] <= pivot) {
                swap(nums, i, partitionIndex++);
            }
        }

        return partitionIndex - 1;
    }

    public int quickSelect(int[] nums, int left, int right, int mid) {
        if (left == right) {
            return nums[left];
        }

        int partitionIndex = new Random().nextInt(right - left + 1) + left;
        partitionIndex = partition(nums, left, right, partitionIndex);

        if (partitionIndex == mid) {
            return nums[mid];
        }
        else if (partitionIndex < mid) {
            return quickSelect(nums, partitionIndex + 1, right, mid);
        }

        return quickSelect(nums, left, partitionIndex - 1, mid);
    }
    public int minMoves2(int[] nums) {
        int n = nums.length;
        int moves = 0;
        int mid = quickSelect(nums, 0, n - 1, n/2);

        for (int i = 0; i < n; i++) {
            moves+= Math.abs(mid - nums[i]);
        }

        return moves;
    }
}
