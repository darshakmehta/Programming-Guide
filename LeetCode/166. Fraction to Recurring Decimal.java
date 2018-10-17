public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        
        StringBuilder res = new StringBuilder();
        // "+" or "-"
        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        
        long num = Math.abs((long)numerator); //handle overflow
        long den = Math.abs((long)denominator); //handle overflow
        
        // integral part
        res.append(num / den);
        num = num % den;
        if (num == 0) return res.toString();
        
        // fractional part
        res.append(".");
        HashMap<Long, Integer> hmap = new HashMap<Long, Integer>();
        hmap.put(num, res.length());
        
        while (num != 0) {
            hmap.put(num, res.length());
            num *= 10;
            res.append(num / den);
            num %= den;
            Integer remainderIndex = hmap.get(num);
            if (remainderIndex != null) {
                res.insert(remainderIndex, "(");
                res.append(")");
                break;
            }
        }
        return res.toString();
    }
}

/***

References: https://leetcode.com/problems/fraction-to-recurring-decimal/discuss/51106/My-clean-Java-solution

***/