/**
 * Problem Link: 242. https://leetcode.com/problems/valid-anagram/
 */

// Using Arrays Sort
class Solution {
    public boolean isAnagram(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);

        if (Arrays.equals(s1, s2)) {
            return true;
        }
        return false;
    }
}

// Faster Approach - No sorting
class Solution {
    public boolean isAnagram(String s, String t) { // Space: O(256) i.e. constant space and Time: O(maxlen(s, t))
        int[] countChar = new int[256]; // 256 - To handle unicode characters; if asked for lower english characters use size 26 array

        // Different length strings cannot be anagram
        if (s.length() != t.length()) {
            return false;
        }

        for (char c: s.toCharArray()) {
            countChar[c]++; // +1 count for every character
        }

        for (char c: t.toCharArray()) {
            countChar[c]--; // -1 count for every character
            if (countChar[c] < 0) {
                return false;
            }
        }

        return true;
    }
}