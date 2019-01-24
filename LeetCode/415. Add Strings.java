class Solution {
    public String addStrings(String num1, String num2) {
        
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder result = new StringBuilder();
        int carry = 0;
        while( i >= 0 && j >= 0 ) {
            int x = (num1.charAt(i) - '0') + (num2.charAt(j) - '0') + carry;
            if(x >= 10) {
                result.append(x % 10);
            } else {
                result.append(x);
            }
            carry = x / 10;
            i--;
            j--;
        }
        
        while(i >= 0) {
            int x = (num1.charAt(i) - '0') + carry;
            result.append(x % 10);
            carry = x / 10;
            i--;
        }
        
        while(j >= 0) {
            int x = (num2.charAt(j) - '0') + carry;
            result.append(x % 10);
            carry = x / 10;
            j--;
        }
        
        if(carry == 1) {
            result.append(carry);
        }
        return result.reverse().toString();
    }
}