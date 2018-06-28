class Solution {
    public boolean isAnagram(String s, String t) {
        int countAlpha[] = new int[27];
        boolean flag = true;
        for(int i = 0; i < s.length(); i++) {
            int a = s.charAt(i);
            countAlpha[a - 96]++ ;
        }
        for(int i = 0; i < t.length(); i++) {
            int a = t.charAt(i);
            if(countAlpha[a - 96] > 0) {
                countAlpha[a - 96]--;
            } else {
                flag = false;
                break;
            }
        }
        if(flag)
        for(int i = 1; i < 27; i++) {
            if(countAlpha[i] > 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}