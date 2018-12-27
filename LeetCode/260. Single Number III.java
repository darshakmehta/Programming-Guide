/* Linear solution with O(n) space complexity */
class Solution {
    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        
        for ( int num : nums ) {
            if(!set.contains(num))
                set.add(num);
            else
                set.remove(num);
        }
        
        return set.stream() 
            .mapToInt(Integer::intValue) 
            .toArray();
        
    }
}

class Solution {
    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        
        for ( int num : nums ) {
            if(!set.contains(num))
                set.add(num);
            else
                set.remove(num);
        }
        
        int[] result = new int[2];
        int k = 0;
        
        for(Integer i : set) { //Enhanced for loop
            result[k++] = i;
        }
        
        return result;
    }
}

/* Linear solution with O(1) space complexity */

