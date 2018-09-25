class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i = left; i <= right; i++) {
            if(i <= 9) {
                list.add(i);
            } else {
                int x = i; //x =10
                boolean flag = true;
                boolean firstFlag = true;
                while(x != 0) {
                    int k = x % 10; 
                    if(k == 0 || firstFlag) {
                        if(k == 0) {
                            flag = false;
                            break;
                        }
                        firstFlag = false;
                    }
                    if(i % k != 0) {
                        flag = false;
                        break;
                    }
                    x = x / 10;
                }
                if(flag)
                    list.add(i);
            }
        }
        
       
        return list;
    }