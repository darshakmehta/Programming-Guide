public class Solution { // Two Pointer Solution
	public int longestSubstring(String s, int k) {
		char[] str = s.toCharArray();
		int idx, max = 0;

		for(int h = 1; h <= 26; h++) {
		    int[] counts = new int[26];
			int i = 0, j = 0;
			int unique = 0, noLessThank = 0;

			while(j < str.length) {
				if(unique <= h) {
					idx = str[j] - 'a';
					if(counts[idx] == 0) unique++;
					counts[idx]++;
					if(counts[idx] == k) noLessThank++;
					j++;
				} else {
					idx = str[i] - 'a';
					if(counts[idx] == k) noLessThank--;
					counts[idx]--;
					if(counts[idx] == 0) unique--;
					i++;
				}
				if(unique == h && unique == noLessThank)
					max = Math.max(j - i, max);
			}
		}
		return max;
	}
}

public int longestSubstring(String s, int k) {
    int d = 0;
    
    for (int numUniqueTarget = 1; numUniqueTarget <= 26; numUniqueTarget++)
        d = Math.max(d, longestSubstringWithNUniqueChars(s, k, numUniqueTarget));
    
    return d;
}

private int longestSubstringWithNUniqueChars(String s, int k, int numUniqueTarget) {
    int[] map = new int[128];
    int numUnique = 0; // counter 1
    int numNoLessThanK = 0; // counter 2
    int begin = 0, end = 0;
    int d = 0;
    
    while (end < s.length()) {
        if (map[s.charAt(end)]++ == 0) numUnique++; // increment map[c] after this statement
        if (map[s.charAt(end++)] == k) numNoLessThanK++; // inc end after this statement
        
        while (numUnique > numUniqueTarget) {
            if (map[s.charAt(begin)]-- == k) numNoLessThanK--; // decrement map[c] after this statement
            if (map[s.charAt(begin++)] == 0) numUnique--; // inc begin after this statement
        }
        
        // if we found a string where the number of unique chars equals our target
        // and all those chars are repeated at least K times then update max
        if (numUnique == numUniqueTarget && numUnique == numNoLessThanK)
            d = Math.max(end - begin, d);
    }
    
    return d;
}

public class Solution {

    /**
     * Given a String s and an integer k, return the longest "valid" substring,
     * where a substring is valid iff every character in the substring occurs
     * at least k times.
     * 
     * @param s The given String
     * @param k The minimum number of times all substring characters must occur
     * @return The length of the longest valid substring
     */
    public int longestSubstring(String s, int k) {

        // Call divide and conquer helper method
        return div(s, 0, s.length(), k);
    }
    
    /**
     * Determines the length of the longest valid substring.
     * 
     * We achieve this by recursively splitting the given String on characters
     * who do not occur at least k times (since they cannot be part of the
     * longest valid substring).
     * 
     * Note that the substring of the current recursion is always equivalent
     * to s.substring(start, end).  For space reasons, we don't ever actually
     * create a new substring.
     * 
     * @param s The given String
     * @param start The beginning of the substring, inclusive
     * @param end The end of the substring, exclusive
     * @param k The minimum number of times all substring characters must occur
     * @return The length of the longest valid substring
     */
    private int div(String s, int start, int end, int k) {
        
        /**
         * Base Case 1 of 2:
         * 
         * If this substring is shorter than k, then no characters in it
         * can be repeated k times, therefore this substring and all
         * substrings that could be formed from it are invalid,
         * therefore return 0.
         */
        if (end - start < k) return 0;
        
        /**
         * Count the frequency of characters in this substring.
         * 
         * We are guaranteed from the problem statement that the given String
         * can only contain lowercase (English?) characters, so we use a
         * table of length 26 to store the character counts.
         */
        int[] a = new int[26];
        for (int i = start; i < end; i++) {
            a[s.charAt(i)-'a']++;
        }
        
        // For every character in the above frequency table
        for (int i = 0; i < a.length; i++){
            
            /**
             * If this character occurs at least once, but fewer than k times
             * in this substring, we know:
             * (1) this character cannot be part of the longest valid substring,
             * (2) the current substring is not valid.
             * 
             * Hence, we will "split" this substring on this character,
             * wherever it occurs, and check the substrings formed by that split
             */
            if (a[i] > 0 && a[i] < k) {
                
                /**
                 * Look for each occurrence of this character (i + 'a')
                 * in this substring.
                 */
                for (int j = start; j < end; j++) {
                    if (s.charAt(j) == i + 'a') {
                        
                        // "Split" into two substrings to solve recursively
                        int l = div(s, start, j, k);
                        int r = div(s, j + 1, end, k);
                        return Math.max(l, r);
                    }
                }
            }
        }
        
        /**
         * Base Case 2 of 2:
         * 
         * If every character in this substring occurs at least k times,
         * then this is a valid substring, so return this substring's length.
         */
        return end - start;
    }
}

public class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        char[] chars = new char[26];
        // record the frequency of each character
        for (int i = 0; i < s.length(); i += 1) chars[s.charAt(i) - 'a'] += 1;
        boolean flag = true;
        for (int i = 0; i < chars.length; i += 1) {
            if (chars[i] < k && chars[i] > 0) flag = false;
        }
        // return the length of string if this string is a valid string
        if (flag == true) return s.length();
        int result = 0;
        int start = 0, cur = 0;
        // otherwise we use all the infrequent elements as splits
        while (cur < s.length()) {
            if (chars[s.charAt(cur) - 'a'] < k) {
                result = Math.max(result, longestSubstring(s.substring(start, cur), k));
                start = cur + 1;
            }
            cur++;
        }
        result = Math.max(result, longestSubstring(s.substring(start), k));
        return result;
    }
}


/***

References: https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/discuss

***/