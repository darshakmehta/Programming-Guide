class Solution { //O(n) time and O(n) space
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        List<Integer> list = new ArrayList<Integer>();
        int count;
        for(int i = 0; i < nums1.length; i++) {
            count = 1;
            if(hmap.containsKey(nums1[i])) {
                count = hmap.get(nums1[i]);
                count++;
            }
            hmap.put(nums1[i], count);
        }
        
        for(int i = 0; i < nums2.length; i++) {
            if(hmap.containsKey(nums2[i])) {
                count = hmap.get(nums2[i]);
                if(count > 0) {
                    list.add(nums2[i]);
                    count--;
                    hmap.put(nums2[i],count);
                }
            }
        }
        int result[] = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            result[i] = list.get(i);
        return result;
    }
}

/***

Followup

What if the given array is already sorted? How would you optimize your algorithm?
Answer: If it is already sorted, we can have 2 pointers and check both the arrays, so O(n) running time and O(1) space time

What if nums1's size is small compared to nums2's size? Which algorithm is better?
Answer: Binary Search [read and understand more about it]

What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
Answer: External sorting [read and understand more about it]

***/