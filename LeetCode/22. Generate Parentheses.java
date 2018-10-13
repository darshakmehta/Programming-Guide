class Solution {
    
    List<String> list = new ArrayList<String>();
    
    public void backtrack(StringBuffer sb, int open, int close, int n) {
        if(sb.length() == n * 2) {
            list.add(sb.toString());
            return;
        }
        
        if(open < n) {
            backtrack(sb.append("("), open + 1, close, n);
            sb.setLength(sb.length() - 1);
        }
        if(close < open) {
            backtrack(sb.append(")"),open, close+1,n);
            sb.setLength(sb.length() - 1);
        }
        
    }
    public List<String> generateParenthesis(int n) {
        
        backtrack(new StringBuffer(""), 0, 0, n);
        return list;
    }
}