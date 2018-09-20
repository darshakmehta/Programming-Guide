/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

/* 

Sorting - Inefficient Solution - Use Heap Data Structure

class KthLargest {
    
    int k;
    ArrayList<Integer> list = new ArrayList<Integer>();
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
    }
    
    public int add(int val) {
        list.add(val);
        Collections.sort(list);
        // for(Integer i : list)
        //     System.out.print(i + " ");
        // System.out.println();
        // System.out.println(list.get(list.size() - k));
        return list.get(list.size() - k);
    }
}

*/


/***

Note:
1. Sorting takes lost of time, so we have to think of a data structure which will manage the kth largest element always i.e Heap Data Structure

***/

class KthLargest {
    
    int k;
    PriorityQueue<Integer> queue;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;  
        queue = new PriorityQueue<Integer>();
        for(int i : nums) add(i);
    }
    
    public int add(int val) {
        if(queue.size() < k) queue.offer(val);
        else if(queue.peek() < val) {
            queue.poll();
            queue.offer(val);
        }
        
        return queue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

 