/* Sort descending order of all characters in a number - Wrong Solution */
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

/* Correct Solution */

/***

In terms of Time and Space Complexity:
Let's assume:
the length of input array is n,
average length of Strings in s_num is k,
Then, compare 2 strings will take O(k).
Sorting will take O(nlgn)
Appending to StringBuilder takes O(n).
So total will be O(nklgnk) + O(n) = O(nklgnk).

Space is pretty straight forward: O(n).

***/

class Solution {
    private class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
           return order2.compareTo(order1);
        }
    }

    public String largestNumber(int[] nums) {
        // Get input integers as strings.
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }

        // Sort strings according to custom comparator.
        Arrays.sort(asStrs, new LargerNumberComparator());

        // If, after being sorted, the largest number is `0`, the entire number
        // is zero.
        if (asStrs[0].equals("0")) {
            return "0";
        }

        // Build largest number from sorted array.
        String largestNumberStr = new String();
        for (String numAsStr : asStrs) {
            largestNumberStr += numAsStr;
        }

        return largestNumberStr;
    }
}