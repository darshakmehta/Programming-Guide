/***
Running time: O(N) where N = number of elements
***/

class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> listNum = new HashMap<>();
        for(int i = 0; i<nums.length; i++) {
            if(listNum.containsKey(nums[i])) {
				listNum.put(nums[i],listNum.get(nums[i])+1);
			}else {
				listNum.put(nums[i], 1);
			}
        }
        
        int result = 0;
        
        for (Map.Entry<Integer, Integer> entry : listNum.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if(value == 1) {
                result = key;
                break;
            }
        }
        
        return result;
        
        
        
    }
}



/*** Method 1: Use hashing with element has key and number of occurence as value ***/
/*** Method 2: Use XOR ***/
/*** Method 3: Mathematical Equation = 2*(a+b+c+d) – (a + a + b + b + c + c + d) ***/
/*** 

Note:
a) XOR of a number with itself is 0.
b) XOR of a number with 0 is number itself.

***/

//Reference: geeksforgeeks
