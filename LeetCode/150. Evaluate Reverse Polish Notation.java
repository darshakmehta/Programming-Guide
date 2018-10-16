class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<String>();
        
        for(String s : tokens) {
            if(s.matches("^[\\+\\-\\/\\*]$")) {
                int n1 = Integer.parseInt(stack.pop());
                int n2 = Integer.parseInt(stack.pop());
                switch(s) {
                    case "+":
                        stack.push(String.valueOf(n2 + n1));
                        break;
                    case "-":
                        stack.push(String.valueOf(n2 - n1));
                        break;
                    case "*":
                        stack.push(String.valueOf(n2 * n1));
                        break;
                    case "/":
                        stack.push(String.valueOf(n2 / n1));
                        break;
                }
            } else {
                stack.push(s);
            }
        }
        return Integer.parseInt(stack.peek());
    }
}

/***

TODO: Traverse right to left.

***/