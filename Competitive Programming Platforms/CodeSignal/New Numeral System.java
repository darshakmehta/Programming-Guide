String[] newNumeralSystem(char number) {
    int low = 0;
    int high = number - 'A';
    
    String[] result = new String[(high / 2) + 1];
    int i = 0;
    while(low <= high) {
        String sb1 = "" + ((char)('A' + low));
        String sb2 = "" + ((char)('A' + high));
        result[i++] = (sb1 + " + " + sb2);
        low++;
        high--;
    }
    
    return result;
}
/***

Fails for most of cases 
TODO: Consider DP

**/