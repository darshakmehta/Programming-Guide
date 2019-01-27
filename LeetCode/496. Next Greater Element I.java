class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        //if(nums1.length == 0 || nums2.length == 0) return new int[]{};
        Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int num : nums2 ) {
            while ( !stack.isEmpty() && stack.peek() < num ) {
                hmap.put(stack.pop(), num);
            }
            stack.push(num);
        }
                
        for ( int i = 0; i < nums1.length; i++ ) {
            nums1[i] = hmap.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }
}