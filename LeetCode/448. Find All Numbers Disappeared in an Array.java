class Solution { //O(n) extra space
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        boolean flag[] = new boolean[nums.length + 1];
        
        for(int i = 0; i < nums.length; i++) {
            if(!flag[nums[i]])
                flag[nums[i]] = true;
        }
        
        for(int i = 1; i < flag.length; i++) {
            if(!flag[i])
                list.add(i);
        }   
        
        return list;
        
    }
}

/***

Note: Think we surely have to negate anytime we are given an array with values from 1 to the length of array.

TODO: Without extra space --> Try negation Technique
Solution: {Missing Understanding}

class Solution {
    
     public void printArr(int nums[]) {
        for(int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0 ; i != nums.length ; i++) {
            int pos = Math.abs(nums[i])-1;
            nums[pos] = - Math.abs(nums[pos]);
            printArr(nums);
        }
        
        
        
        for (int i = 0 ; i != nums.length; i++) {
            if (nums[i] >= 0) res.add(i+1);
        }
        return res;
    }
}



***/