    /*
     * Complete the function below.
     */
    static String encodeString(String inputString) {
        // Write your code here.
        char prevLetter = 'a';
        char prevNumber = 0;
        boolean firstLetter = false, firstNumber = false;
        StringBuilder sb = new StringBuilder("");
        for(char c : inputString.toCharArray()) {
            
            if(Character.isLetter(c) && firstLetter) {
                char tempc = Character.toLowerCase(c);
                int x = prevLetter - 'a';
                int y = tempc - 'a';
                if(y + x >= 26) {
                    int a = 26 - y;
                    int b = x - a;
                    char ch = (char)('a' + b);
                    if(Character.isUpperCase(c))
                        sb.append(Character.toUpperCase(ch));
                    else
                        sb.append(ch);
                    prevLetter = Character.toLowerCase(ch);
                } else {
                    int temp = x + y;
                    char ch = (char)('a' + temp);
                    if(Character.isUpperCase(c))
                        sb.append(Character.toUpperCase(ch));
                    else
                        sb.append(ch);
                    prevLetter = Character.toLowerCase(ch);
                }
                
            } else if(Character.isDigit(c) && firstNumber) {
                int x = 9 - ((int) (prevNumber - '0'));
                int y = ((int) (c - '0'));
                if((x + y) > 9) {
                    int a = 10 - y;
                    int b = x - a;
                    char ch = (char)('0' + b);
                    sb.append(ch);
                    prevNumber = ch;
                } else {
                    int temp = x + y;
                    char ch = (char)('0' + temp);
                    sb.append(ch);
                    prevNumber = ch;
                }
                
            } else if(!Character.isLetterOrDigit(c)) {
                sb.append(c);
            } else {
                sb.append(c);
                if(Character.isDigit(c)) {
                    firstNumber = true;
                    prevNumber = Character.toLowerCase(c);
                } else {
                    firstLetter = true;
                    prevLetter = Character.toLowerCase(c);
                }
            }
        }
        return sb.toString();
    }

