class Solution {
    public int findComplement(int num) {
        StringBuffer sb = new StringBuffer();
        
        
        while(num != 0) {
            sb.append(num % 2);
            num = num / 2;
        }
        char ch[] = sb.toString().toCharArray();
        for(int i = 0; i < ch.length; i++) {
            if(ch[i] == '0') {
                ch[i] = '1';
            } else {
                ch[i] = '0';
            }
        }
        int result = 0;
        for(int i = ch.length - 1; i >= 0; i--) {
            result += Math.pow(2, i) * (int) (ch[i] - '0');
        }
        
        return result;
        
    }
}