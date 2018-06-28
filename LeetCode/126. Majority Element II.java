/***
Running time: O(N) where N = number of elements
***/


class Solution {
    public List<Integer> majorityElement(int[] nums) {
             
        List<Integer> list = new ArrayList<Integer>();
        Map<Integer, Integer> listNum = new HashMap<>();
        for(int i = 0; i<nums.length; i++) {
            if(listNum.containsKey(nums[i])) {
				listNum.put(nums[i],listNum.get(nums[i])+1);
			}else {
				listNum.put(nums[i], 1);
			}
        }
       
        int n = (int) Math.floor(nums.length/3);
        
        for (Map.Entry<Integer, Integer> entry : listNum.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if(value > n) {
                
                list.add(key);
            }
        }
        
        return list;
        
    }
}

//TODO: The algorithm should run in linear time and in O(1) space.

