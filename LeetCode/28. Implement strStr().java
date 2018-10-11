class Solution {
    public int strStr(String haystack, String needle) {
        
        char a[] = haystack.toCharArray();
        char b[] = needle.toCharArray();
        boolean flag = false;
        int result = -1;
        if(a.length < b.length) {
            return result;
        } else if(a.length == 0 && b.length == 0) {
            return 0;
        }
        for(int i = 0; i < a.length; i++) {
                int k = i;
                result = k;
            for(int j = 0; j < b.length;j++) {
                if(k < a.length && a[k] == b[j]) {
                    k++;
                    flag = true;
                } else {
                    flag = false;
                    result = -1;
                    break;
                }
            }
            if(flag) {
                return result;
            } 
        }
        return result;
    }
}