class Solution {
    
    
    List<String> list = new ArrayList<String>();
    public String largestTimeFromDigits(int[] A) {
        String result = "";
        String s = "";
        for(int a : A)
            s += a;
        permutation("", s); 
        Collections.sort(list);
        
        int hoursLargest = -1;
        int minsLargest = -1;
        for(String str : list) {
            int x = Integer.parseInt(str.substring(0, 2));
            
            if(x < 24) {
                if(x >= hoursLargest) {
                     int y = Integer.parseInt(str.substring(2, 4));
                     if(y < 60) {
                            hoursLargest = x;
                            minsLargest = y;
                            result = "";
                            if(hoursLargest <= 9) {
                                if(hoursLargest != 0) 
                                    result += "0" + x + ":";
                                else
                                    result += "" + "00" + ":";
                            } else {
                                result += x + ":";
                            }
                            if(minsLargest <= 9) {
                                if(minsLargest != 0)
                                    result += "" + "0" + y;
                                else
                                    result += "" + "00";
                                    
                            } else {
                                result += y;
                            }
                     }
                }
            }
        }  
        return result;
    }
    public void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) list.add(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }
}