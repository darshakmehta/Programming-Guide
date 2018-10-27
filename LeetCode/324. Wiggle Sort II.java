class Solution {
    
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
    
    public void wiggleSort(int[] nums) { //O(n) time and space
        int median = findKthLargest(nums,(nums.length+1)/2); //O(n)
        int odd = 1;
        int even = nums.length % 2 == 0 ? nums.length-2 : nums.length-1;
        int[] tmpArr = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > median){
                tmpArr[odd] = nums[i];
                odd += 2;
                continue;
            }
            if(nums[i] < median){
                tmpArr[even] = nums[i];
                even -= 2;
                continue;
            }
        }
        while(odd < nums.length){
            tmpArr[odd] = median;
            odd += 2;
        }
        while(even >= 0){
            tmpArr[even] = median;
            even -= 2;
        }
        for(int i = 0; i < nums.length; i++){
            nums[i] = tmpArr[i];
        }
    }
}

/***

TODO: 
Virtual Indexing: https://leetcode.com/problems/wiggle-sort-ii/discuss/77682/Step-by-step-explanation-of-index-mapping-in-Java
O(1) space complexity.


***/