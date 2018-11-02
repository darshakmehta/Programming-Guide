class Solution {
    public String decodeString(String s) {
        Stack<Integer> intStack = new Stack<Integer>();
        Stack<StringBuilder> strStack = new Stack<StringBuilder>();
        StringBuilder sb = new StringBuilder();
        int k = 0;
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                k = k * 10 + c - '0';
            } else if(c == '[') {
                intStack.push(k);
                strStack.push(sb);
                sb = new StringBuilder();
                k = 0;
            } else if(c == ']') {
                StringBuilder temp = sb;
                sb = strStack.pop();
                for(k = intStack.pop(); k > 0; k--)
                    sb.append(temp);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}