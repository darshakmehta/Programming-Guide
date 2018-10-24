class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums); //TODO: copy to temp array as nums is read only
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }
}

class Solution { //Faster Approach
    public int findDuplicate(int[] nums) {
        int tortoise = nums[0];
        int hare = nums[0];
        
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while(tortoise != hare);
        
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        
        while(ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }
        
        return ptr1;
    }
}

/***

# Knowledge
Proving that at least one duplicate must exist in nums is simple application of the pigeonhole principle
Here, each number in nums is a "pigeon" and each distinct number that can appear in nums is a "pigeonhole". Because there are n+1 numbers are n distinct possible numbers, the pigeonhole principle implies that at least one of the numbers is duplicated.

TODO:

1. Sorting will rearraange array so it does not satisfy the constraints. [O(nlogn) and O(n) space] 
2. HashSet approach much faster O(n) and O(n) space. If already exist in set that is the duplicate element.
*** Think about PigeonHole principle ***
3. Approach using Constant space and read only array --> Floyd's Tortoise and Hare (Cycle Detection)
o(n) running time and O(1) space
4. If modification was allowed

<!-- class Solution {
    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++)
            if(nums[Math.abs(nums[i])] >0)
                nums[Math.abs(nums[i])]=-nums[Math.abs(nums[i])];
            else
                return Math.abs(nums[i]);
        return -1;
    }
} -->

***/