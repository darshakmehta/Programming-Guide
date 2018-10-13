class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        int maxLength = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if(!stack.isEmpty()) {
                    int x = i - stack.peek();
                    maxLength = maxLength > x ? maxLength : x;
                } else {
                    stack.push(i);
                }
            }
        }
        return maxLength;
        
    }
}

/***

TODO:

1. Use DP
2. Without Extra Space

***/