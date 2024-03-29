class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

class Solution {
    public int findKthLargest(int[] nums, int k) {
        final Queue<Integer> pq = new PriorityQueue<>();

        for (int val : nums) {
            pq.offer(val);

            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}

/***

TODO:

1. Heap Sort
2. Quick Sort | Quick Select

***/
