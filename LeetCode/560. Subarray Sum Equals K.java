class Solution {
    public int subarraySum(int[] A, int S) {
        Map<Integer, Integer> hmap = new HashMap<Integer, Integer>(); //To store number of subarrays for Sum
        int count = 0;
        
        int sumSoFar = 0; // Sum so far
        
        for(int i = 0; i < A.length; i++) {

            sumSoFar += A[i]; //Sum every element
            
            if(sumSoFar == S) // if sumSoFar is equal to S we have found one of our subarrays
                count++;
            
            //Important check: if sumSoFar > S, check if we have found subarrays for sumSoFar - S; add them
            if(hmap.containsKey(sumSoFar - S)) { 
                count += hmap.get(sumSoFar - S);
            }
            
            hmap.put(sumSoFar, hmap.getOrDefault(sumSoFar, 0) + 1); //Maintain count of different values of sumSoFar in a map
        }
        return count;
    }
}

/***

Same as: https://leetcode.com/problems/binary-subarrays-with-sum/

***/