class Solution {
    public int[] plusOne(int[] digits) {
        
        int x = digits.length - 1;
        if(digits[x] != 9) {
            digits[x]++;
            return digits;
        } else {
            int j = digits.length - 1;
            while(true) {
                digits[j--] = 0;
                if(j >= 0 && digits[j] != 9) {
                    digits[j]++;
                    return digits;
                }
                if(j <= 0) {
                    int temp[] = new int[digits.length + 1];
                    temp[0] = 1;
                    return temp;
                } 
            }
            
        }

    }
}