class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(hmap.containsKey(nums[i]))
                return true;
            else
                hmap.put(nums[i], 1);
        }
        return false;
    }
}

class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i]))
                return true;
            else
                set.add(nums[i]);
        }
        return false;
    }
}

class Solution { //Little more efficient
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i + 1])
                return true;
        }
        return false;
    }
}

/***

Reference: https://stackoverflow.com/questions/16278995/why-is-hashmap-faster-than-hashset

HashMap vs HashSet (Solution 1 vs Solution 2)

Performance:

If you look at the source code of HashSet (at least JDK 6, 7 and 8), it uses HashMap internally, so it basically does exactly what you are doing with sample code.

So, if you need a Set implementation, you use HashSet, if you need a Map - HashMap. Code using HashMap instead of HashSet will have exactly the same performance as using HashSet directly.

Choosing the right collection

Map - maps keys to values (associative array) - http://en.wikipedia.org/wiki/Associative_array.

Set - a collection that contains no duplicate elements - http://en.wikipedia.org/wiki/Set_(computer_science).

If the only thing you need your collection for is to check if an element is present in there - use Set. Your code will be cleaner and more understandable to others.

If you need to store some data for your elements - use Map.

***/