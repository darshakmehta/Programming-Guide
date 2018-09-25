class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String []morseDict = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<String>();
        
        for(String s : words) {
            char ch[] = s.toCharArray();
            StringBuffer sb = new StringBuffer();
            for(char c : ch) {
                int x = c - 'a';
                sb.append(morseDict[x]);
            }
            set.add(sb.toString());
        }
        
        return set.size();
    }
}