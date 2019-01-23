import java.math.*;
class Solution {
    public String addBinary(String a, String b) {
        BigInteger number = new BigInteger(a, 2).add(new BigInteger(b, 2));
        return number.toString(2);
    }
}

/**

TODO: Arithmetically 

**/