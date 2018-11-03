boolean isLucky(int n) {
    StringBuilder sb = new StringBuilder("" + n);
    String s1 = sb.substring(0, sb.length()/2);
    String s2 = sb.substring(sb.length() /2, sb.length());
    int sum1 = 0, sum2 = 0;
    for(char c : s1.toCharArray()) {
        sum1 += ((int)(c - '0'));
    }
    for(char c : s2.toCharArray()) {
        sum2 += ((int)(c - '0'));
    }
    return sum1 == sum2;
    
}
