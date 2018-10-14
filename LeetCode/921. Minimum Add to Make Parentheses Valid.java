class Solution {
    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<Character>();
        int count = 0;
        char ch[] = S.toCharArray();
        for(char c : ch) {
            if(c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if(c == ')' && !stack.isEmpty()) {
                    if(stack.peek() != '(') {
                        count++;
                    } else {
                        stack.pop();
                    }
                } else if(c == '}' && !stack.isEmpty()) {
                    if(stack.peek() != '{') {
                        count++;
                    } else {
                        stack.pop();
                    }
                } else if(c == ']' && !stack.isEmpty()) {
                    if(stack.peek() != '[') {
                        count++;
                    } else {
                        stack.pop();
                    }
                } else {
                    count++;
                }
            }
        }
        if(!stack.isEmpty())
            return count + stack.size();
        return count;
    }
}

//Required Solution
class Solution {
    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<Character>();
        int count = 0;
        char ch[] = S.toCharArray();
        for(char c : ch) {
            if(c == '(') {
                stack.push(c);
            } else {
                if(c == ')' && !stack.isEmpty()) {
                    if(stack.peek() != '(') {
                        count++;
                    } else {
                        stack.pop();
                    }
                } else {
                    count++;
                }
            }
        }
        if(!stack.isEmpty())
            return count + stack.size();
        return count;
    }
}