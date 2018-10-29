class Solution {
    int count = 0;
    
    public void extendPalindrome(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }
    
    public int countSubstrings(String s) {
        if(s == null || s.length() == 0) return 0;    
        
        for(int i = 0; i < s.length(); i++) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i + 1);
        }
        return count;
    }
}

/* Print All Palindromic substrings */
class Solution {
    int count = 0;
    List<String> list = new ArrayList<String>(); //List containing palindromic substrings
    
    public void extendPalindrome(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) { //Expand Around center
            list.add(s.substring(left, right + 1));
            count++;
            left--;
            right++;
        }
    }
    
    public int countSubstrings(String s) {
        if(s == null || s.length() == 0) return 0;    
        
        for(int i = 0; i < s.length(); i++) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i + 1);
        }
        for(String str : list)
            System.out.println(str); //Print list of palindromic substrings
        return count;
    }
    /* To print unique substring, add them to HashSet */
}


class Solution {
    int count = 0;
    Map<String, Integer> hmap = new HashMap<String, Integer>(); //to find all the occurences or distinct occurences of substring
    
    public void extendPalindrome(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            int count = 1;
            if(hmap.containsKey(s.substring(left, right + 1))) {
                count = hmap.get(s.substring(left, right + 1)) + 1;
            }
            hmap.put(s.substring(left, right + 1), count);
            count++;
            left--;
            right++;
            
        }
    }
    
    public int countSubstrings(String s) {
        if(s == null || s.length() == 0) return 0;    
        
        for(int i = 0; i < s.length(); i++) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i + 1);
        }
        
        Set set = hmap.entrySet();
        Iterator iter = set.iterator();
        while(iter.hasNext()) {
            Map.Entry pair = (Map.Entry) iter.next();
            System.out.println(pair.getKey() + " " + pair.getValue());  
        }
        return count;
    }  
}


/***

DP solution

1. https://www.geeksforgeeks.org/count-palindrome-sub-strings-string/
2. https://leetcode.com/problems/palindromic-substrings/discuss/105749/Java-O(n2)-DP-solution/186029

***/