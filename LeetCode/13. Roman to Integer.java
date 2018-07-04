class Solution {

    public int romanToInt(String s) {
        
        char c[] = s.toCharArray();
        int count = 0;
        for(int i = 0; i < c.length; i++) {
            
            if((i + 1 != c.length) && c[i] =='I' && c[i+1] == 'V') {
                count+=4;
                i++;
            } else if((i + 1 != c.length) && c[i] =='I' && c[i+1] == 'X') {
                count+=9;
                i++;
            } else if((i + 1 != c.length) && c[i] =='X' && c[i+1] == 'L') {
                count+=40;
                i++;
            } else if((i + 1 != c.length) && c[i] =='X' && c[i+1] == 'C') {
                count+=90;
                i++;
            } else if((i + 1 != c.length) && c[i] =='C' && c[i+1] == 'D') {
                count+=400;
                i++;
            } else if((i + 1 != c.length) && c[i] =='C' && c[i+1] == 'M') {
                count+=900;
                i++;
            } else {
                    switch(c[i]) {
                    case 'I':
                        count+=1;
                        break;
                    case 'V':
                        count+=5;
                        break;
                    case 'X':
                        count+=10;
                        break;
                    case 'L':
                        count+=50;
                        break;
                    case 'C':
                        count+=100;
                        break;
                    case 'D':
                        count+=500;
                        break;
                    case 'M':
                        count+=1000;
                        break;
                }
            }
        }
        return count;
        
    }
}