class Solution {
  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<Character>();

    char[] ch = s.toCharArray();
    for (char c : ch) {
      if (c == '{' || c == '[' || c == '(') {
        stack.push(c);
      } else {
        if (stack.isEmpty()) {
          return false;
        } else {
          if (c == ')' && stack.peek() == '(') {
            stack.pop();
          } else if (c == '}' && stack.peek() == '{') {
            stack.pop();
          } else if (c == ']' && stack.peek() == '[') {
            stack.pop();
          } else {
            return false;
          }
        }
      }
    }

    if (!stack.isEmpty())
      return false;
    return true;
  }
}
