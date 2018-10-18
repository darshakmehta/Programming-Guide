class Solution {
    Map<Character, String> hmap = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        hmap.put('2', "abc");hmap.put('3', "def");hmap.put('4', "ghi");hmap.put('5', "jkl");
        hmap.put('6', "mno");hmap.put('7', "pqrs");hmap.put('8', "tuv");hmap.put('9', "wxyz");
        if(digits.length() == 0) return result;
       
        backtrack(result, new StringBuffer(""), digits, 0);
        return result;
    }
    
    public void backtrack(List<String> result, StringBuffer sb, String digits, int pos) {
        if(pos >= digits.length()) return;
        
        String s = hmap.get(digits.charAt(pos));

        for(int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if(sb.length() == digits.length())
                result.add(sb.toString());
            backtrack(result, sb, digits, pos + 1);
            sb.setLength(sb.length() - 1);
        }
    }
}