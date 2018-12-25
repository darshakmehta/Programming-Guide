class Solution {
    public String toLowerCase(String str) {
        return str.toLowerCase();
    }
}

class Solution {
    public String toLowerCase(String str) {
        
        StringBuilder sb = new StringBuilder();
        
        for(char c : str.toCharArray()) {
            if(((int) c) <= 91 && ((int) c) >= 65 ) {
                sb.append((char) (c + 32));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

class Solution { //Better Style of writing
    public String toLowerCase(String str) {
        
        char[] result = str.toCharArray(); // No need of StringBuilder
        
        for(int i = 0; i < result.length; i++) {
            if(result[i] <= 'Z' && result[i] >= 'A') {
                result[i] += 32;
            }
        }
        return String.valueOf(result);
    }
}