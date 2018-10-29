/* DFS Recursive */
class Solution { 
    Map<Character, String> hmap = new HashMap<Character, String>();
    List<String> result = new ArrayList<String>(); // Do not have to send in every recursive stack call
    
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return result;
        
        /* Initialize your phone keys to a HashMap */
        hmap.put('2', "abc");hmap.put('3', "def");hmap.put('4', "ghi");hmap.put('5', "jkl");
        hmap.put('6', "mno");hmap.put('7', "pqrs");hmap.put('8', "tuv");hmap.put('9', "wxyz");
       
        backtrack(new StringBuffer(""), digits, 0);
        return result;
    }
    
    public void backtrack(StringBuffer sb, String digits, int pos) {
        if(pos >= digits.length()) return;
        
        String s = hmap.get(digits.charAt(pos));

        for(int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));

            if(sb.length() == digits.length()) {
                System.out.println(sb.toString()); //Print all the possible letter combinations
                result.add(sb.toString());
            }

            backtrack(sb, digits, pos + 1);
            sb.setLength(sb.length() - 1);
        }
    }
}

/** 

Illustration 

For digits = "234"

adg adh adi aeg aeh aei afg afh afi bdg bdh bdi beg beh bei bfg bfh bfi cdg cdh cdi ceg ceh cei cfg cfh cfi 

1. First it considers, first digit "2", backtracks for next digit, until last digit and forms first string by using first character of 2, 3, and 4. 
2. Now expands, all the combination of "23" + (different characters of 4)
Therefore, adg adh adi
3. Once explored all possible of last digit, backtrack to explore all possible combinations of (last - 1) digit. Thefore, aeg aeh aei
4. Now it repeats until all possible combinations of (last - last) i.e. 0th character by indexing (1st character of a string) "2" is explored in form of a** , b**, c**

**/


/***

TODO:
1. FIFO Queue | BFS Solution

***/