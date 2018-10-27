/* Sort descending order of all characters in a number */
class Solution {
    public String largestNumber(int[] nums) {
        List<Character> list = new ArrayList<Character>();
        
        for(int i : nums) {
            if(i < 10) 
                list.add((char)('0' + i));
            else {
                while(i != 0) {
                    list.add((char)(i % 10 + '0'));
                    i = i / 10;
                }
            }
        }
        
        Collections.sort(list, Collections.reverseOrder());
        StringBuffer sb = new StringBuffer("");
        for(char c : list) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}