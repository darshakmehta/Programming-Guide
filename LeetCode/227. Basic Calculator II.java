class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        
        for (int i = 0, num = 0, op = '+'; i < s.length(); i++) {   // op is last operator
            char c = s.charAt(i);
            if (Character.isDigit(c))
                num = num * 10 + (c - '0');
            if ("+-*/".indexOf(c) >= 0 || i == s.length() - 1) {    // must be 'if' or i=len-1 won't reach here
                if ("*/".indexOf(op) >= 0)                          // subtract top before mul/div
                    result -= stack.peek();
                switch (op) {
                    case '+': stack.push(num); break;
                    case '-': stack.push(-num); break;
                    case '*': stack.push(stack.pop() * num); break; // only non-negative int, impossible '2*-1'
                    case '/': stack.push(stack.pop() / num); break;
                }
                num = 0;
                op = c;
                result += stack.peek();
            } /* else whitespace */
        }
        return result;
    }
}

//Without Stack

class Solution {
    public int calculate(String s) {
        int res = 0;
        char sign = '+';
        for (int i = 0, num = 0, pre = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (int)(c - '0');
            }
            if ("+-*/".indexOf(c) >= 0 || i == s.length() - 1) {
                if (sign == '+') {
                    pre = num;
                } else if (sign == '-') {
                    pre = -num;
                } else if (sign == '*') {
                    res -= pre;
                    pre *= num;
                } else {
                    res -= pre;
                    pre /= num;
                }
                sign = c;
                num = 0;
                res += pre;
            }
        }
        
        return res;
    }
}