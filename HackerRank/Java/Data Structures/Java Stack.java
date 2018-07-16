import java.util.*;
class Solution{
    
    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input=sc.next();
            Stack<Character> stack = new Stack<Character>();
            for(int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if(c == '{' || c == '[' || c == '(') {
                    stack.push(c);
                } else {
                    if(!stack.isEmpty()) {
                        if(c == '}') {
                        if(stack.peek() != '{')
                            break;
                        else
                            stack.pop();
                        } else if(c == ']') {
                            if(stack.peek() != '[') 
                                break;
                            else 
                                stack.pop();
                        } else if(c == ')') {
                            if(stack.peek() != '(')
                                break;
                            else
                                stack.pop();
                        }
                    } else {
                        stack.push(c);
                        break;
                    }
                }
            }
            System.out.println(stack.isEmpty());
        }
        
    }
}



