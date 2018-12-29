class Solution {
    public String toGoatLatin(String S) {
        
        String[] arr = S.split(" ");
        StringBuilder result = new StringBuilder();
        StringBuilder appendA = new StringBuilder("a");
        
        for( int i = 0; i < arr.length; i++ ) {
            char ch = Character.toLowerCase(arr[i].charAt(0));
            if( ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ) {
                result.append(arr[i]);
            } else {
                result.append(arr[i].substring(1) + arr[i].charAt(0));
            }
            result.append("ma" + appendA + " ");
            appendA.append("a");
        }
        return result.toString().trim();
    }
}