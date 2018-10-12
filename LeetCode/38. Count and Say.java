class Solution {
    
    public int[] countAndSay(int j, StringBuffer sb, char c) {
        
         int count = 0;
         int lastj = j;
         if(j < sb.length()) {
            while(j < sb.length() && sb.charAt(j++) == c) {
                count++;
                lastj = j;
            }
         }
        
        return new int[]{count, lastj};
    }
    public String countAndSay(int n) {
        StringBuffer sb = new StringBuffer("1");
        StringBuffer result = new StringBuffer();
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < sb.length(); ) {
                //System.out.println("i: " + i + " j: " + j + " c: " + sb.charAt(j));
                int arr[] = countAndSay(j, sb, sb.charAt(j));
                //System.out.println(" c: " + sb.charAt(j) + " count: " + arr[0] + " lastj: " + arr[1]);
                result.append(arr[0]);
                result.append(sb.charAt(j));
                j = arr[1];
            }
            sb = new StringBuffer(result.toString());
            result = new StringBuffer("");
        }
        return sb.toString();
    }
}