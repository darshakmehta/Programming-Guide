class Solution {
    public String reverseWords(String s) {
        String []splitString = s.split(" ");
        StringBuffer sb = new StringBuffer();
        
        for(String string : splitString) {
            StringBuilder sbb = new StringBuilder(string);
            sb.append(sbb.reverse());
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}