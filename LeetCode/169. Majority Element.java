/***
Running time: O(N) where N = number of elements
***/


class Solution {
    public int majorityElement(int[] nums) {
        
        Map<Integer, Integer> listNum = new HashMap<>();
        for(int i = 0; i<nums.length; i++) {
            if(listNum.containsKey(nums[i])) {
				listNum.put(nums[i],listNum.get(nums[i])+1);
			}else {
				listNum.put(nums[i], 1);
			}
        }
        int result = 0;
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : listNum.entrySet()) {
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