/* Brute Force */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            for (int j = 0; j < nums.length && j != i; j++) {
                if (x == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }
}

class Solution { // Efficient Solution
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (hmap.containsKey(complement)) {
                return new int[]{hmap.get(complement), i};
            }
            
            if (!hmap.containsKey(nums[i])) // To avoid adding later index of already visited element
                hmap.put(nums[i], i);
        }
        return new int[]{-1, -1}; // not found
    }
}

/* Another Solution can be Binary Search */
