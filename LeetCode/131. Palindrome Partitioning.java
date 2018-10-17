class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        backtrack(result, new ArrayList<String>(), s, 0);
        return result;
    }
    public void backtrack(List<List<String>> result, List<String> tempList, String s, int start) {
        if(start == s.length()) {
            result.add(new ArrayList<String>(tempList));
        } else {
            for(int i = start; i < s.length(); i++) {
                //System.out.println("Start: " + start + " i: " + i);
                if(isPalindrome(s, start, i)) {
                    //System.out.println("Adding: " + s.substring(start, i + 1));
                    tempList.add(s.substring(start, i + 1));
                    backtrack(result, tempList, s, i + 1);
                    //System.out.println("Removing: " + tempList.get(tempList.size() - 1));
                    tempList.remove(tempList.size() - 1);
                }
            }    
        }
        
    }
    
    public boolean isPalindrome(String s, int low, int high) {
        while(low < high)
          if(s.charAt(low++) != s.charAt(high--)) return false;
       return true;
    }
}