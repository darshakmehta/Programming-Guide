// Using Sorting - Inefficient and Incorrect

class Solution {
  public int countElements(int[] arr) {
    Arrays.sort(arr); // O(n^2) inefficent

    int count = 0;

    // Solution Looks good if there are no duplicates
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] + 1 == arr[i + 1]) {  // Since we will not catch duplicates it is incorrect Solution
        count++;
      }
    }

    return count;
  }
}

// Using Map - Time Efficient and Correct

class Solution {
  public int countElements(int[] arr) {
    Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();
    int count = 0;

    for (int i = 0; i < arr.length; i++) {
      hmap.put(arr[i], hmap.getOrDefault(arr[i], 0) + 1);
    }

    for (int i = 0; i < arr.length; i++) {
      if (hmap.containsKey(arr[i] + 1)) {
        count++;
        hmap.put(arr[i] + 1, hmap.getOrDefault(arr[i] + 1, 0) - 1);
      }
    }

    return count;
  }
}

/**
 * Edge Case
 * 1. [1, 1, 2, 2, 2] => 2
 * 2. [1, 1, 2, 2] => 2
 */
