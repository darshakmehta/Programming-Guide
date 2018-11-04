class Solution {
    public int majorityElement(int[] nums) {
        
        Map<Integer, Integer> hmap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            hmap.put(nums[i], hmap.getOrDefault(nums[i], 0) + 1);
        }
        int result = 0;
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            //System.out.println("key: " + key + " Value: " + value );
            if(value > max) {
                max = value;
                result = key;
            }
        }
        return result;
    }
}

class Solution { //Boyer-Moore Voting Algorithm -> O(1) space time
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) 
                candidate = num;
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}

/***

Running time: O(N) where N = number of elements
Space time: O(N) for n distinct elements

Boyer-Moore Voting Algorithm -> O(1) space time


***/