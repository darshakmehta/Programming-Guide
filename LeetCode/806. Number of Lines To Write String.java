class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        char ch[] = S.toCharArray();
        
        int line = 1;
        int currentWidth = 0;
        for(char c : ch) {
            if((currentWidth + widths[c - 'a']) > 100) {
                line++;
                currentWidth = widths[c - 'a'];
            } else {
                currentWidth += widths[c - 'a'];
            }
            //System.out.println(c + " " + line + " " + currentWidth);
        }
        
        return new int[]{line, currentWidth};
    }
}