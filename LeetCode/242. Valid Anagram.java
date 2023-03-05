class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] countAlpha = new int[27];
        for (int i = 0; i < s.length(); i++) {
            countAlpha[s.charAt(i) - 96]++ ;
        }

        for (int i = 0; i < t.length(); i++) {
            countAlpha[t.charAt(i) - 96]--;
            if (countAlpha[t.charAt(i) - 96] < 0) {
                return false;
            }
        }

        return true;
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return String.valueOf(arr1).equals(String.valueOf(arr2));
    }
}

/**
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 * Answer: Use a hash table or an array of size 256.
 **/
