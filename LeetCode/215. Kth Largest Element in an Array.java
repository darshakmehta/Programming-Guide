class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

public int findKthLargest(int[] nums, int k) {

    final PriorityQueue<Integer> pq = new PriorityQueue<>();
    for(int val : nums) {
        pq.offer(val);

        if(pq.size() > k) {
            pq.poll();
        }
    }
    return pq.peek();
}


/***

TODO:

1. Priority Queue
2. Heap Sort
3. Quick Sort | Quick Select

***/