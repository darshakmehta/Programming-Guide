public class RandomizedSet {
    ArrayList<Integer> nums;
    Map<Integer, Integer> hmap;
    java.util.Random rand = new java.util.Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<Integer>();
        hmap = new HashMap<Integer, Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain = hmap.containsKey(val);
        if (contain) return false;
        hmap.put(val, nums.size());
        nums.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean contain = hmap.containsKey(val);
        if (!contain ) return false;
        int loc = hmap.get(val);
        if (loc < nums.size() - 1 ) { // not the last one than swap the last one with this val
            int lastone = nums.get(nums.size() - 1 );
            nums.set( loc , lastone );
            hmap.put(lastone, loc);
        }
        hmap.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get( rand.nextInt(nums.size()) );
    }
}

/*** Follow Up Question ==> Duplicate number is allowed ***/

class RandomizedSet {

    List<Integer> nums;
    Map<Integer, Set<Integer>> hmap;
    java.util.Random rand = new java.util.Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<Integer>();
        hmap = new HashMap<Integer, Set<Integer>>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain = hmap.containsKey(val);
        if(!contain) hmap.put(val, new HashSet<Integer>());
        hmap.get(val).add(nums.size());
        nums.add(val);
        return !contain;
        
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean contain = hmap.containsKey(val);
        if(!contain) return false;
        int loc = hmap.get(val).iterator().next();
        hmap.get(val).remove(loc);
        if(loc < nums.size() - 1) {
            int lastone = nums.get(nums.size() - 1);
            nums.set(loc, lastone);
            hmap.get(lastone).remove(nums.size() - 1);
            hmap.get(lastone).add(loc);
        }
        
        nums.remove(nums.size() - 1);
        if(hmap.get(val).isEmpty()) hmap.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */