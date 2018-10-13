class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        char ch[] = s.toCharArray();
        for(char c : ch) {
            if(c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if(c == ')' && !stack.isEmpty()) {
                    if(stack.peek() != '(') {
                        return false;
                    } else {
                        stack.pop();
                    }
                } else if(c == '}' && !stack.isEmpty()) {
                    if(stack.peek() != '{') {
                        return false;
                    } else {
                        stack.pop();
                    }
                } else if(c == ']' && !stack.isEmpty()) {
                    if(stack.peek() != '[') {
                        return false;
                    } else {
                        stack.pop();
                    }
                } else {
                    return false;
                }
            }
        }
        if(!stack.isEmpty())
            return false;
        return true;
        
    }
}