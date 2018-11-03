String decodeString(String s) {
    Stack<Integer> intStack = new Stack<Integer>();
    Stack<StringBuilder> strStack = new Stack<StringBuilder>();
    StringBuilder sb = new StringBuilder("");
    int k = 0;
    for(char ch : s.toCharArray()) {
        if(Character.isDigit(ch)) {
            k = k * 10 + (ch - '0');
        } else if(ch == '[') {
            intStack.push(k);
            strStack.push(sb);
            sb = new StringBuilder();
            k = 0;
        } else if(ch == ']') {
            StringBuilder temp = sb;
            sb = strStack.pop();
            for(k = intStack.pop(); k > 0; k--) sb.append(temp);
        } else {
            sb.append(ch);
        }
    }
    return sb.toString();
    
    
}
