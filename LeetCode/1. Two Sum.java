class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            for(int j = 0; j < nums.length && j != i; j++) {
                if(x == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }
}

class Solution { //Very efficient Solution
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            if(!hmap.containsKey(nums[i])) {
                hmap.put(nums[i], i);
            }
            int complement = target - nums[i];
            if(hmap.containsKey(complement) && hmap.get(complement) != i) {
                return new int[]{hmap.get(complement), i};
            }
        }
        return new int[]{-1, -1};
    }
}

