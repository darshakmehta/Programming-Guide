/**
 * Problem Link: 347. https://leetcode.com/problems/top-k-frequent-elements/
 */

// Using MaxHeap

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Queue<Map.Entry<Integer, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        // Add every key, frequency to hashmap
        for (int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // Add all entries to maxHeap
        for (Map.Entry<Integer,Integer> entry: map.entrySet()){
            maxHeap.add(entry);
        }

        int index = 0;
        while (index < k){
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            result[index++] = entry.getKey();
        }
        return result;
    }
}

// Using MinHeap

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Queue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>((a, b) -> (a.getValue() - b.getValue()));
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        // Add every key, frequency to hashmap
        for (int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // Add k entries to minHeap
        for (Map.Entry<Integer,Integer> entry: map.entrySet()){
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int index = 0;
        while (index < k){
            Map.Entry<Integer, Integer> entry = minHeap.poll();
            result[index++] = entry.getKey();
        }
        return result;
    }
}
