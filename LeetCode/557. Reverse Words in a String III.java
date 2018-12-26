class Solution {
    public String reverseWords(String s) {
        
        StringBuilder result = new StringBuilder();   
        
        String[] arr = s.split(" ");
        
        for( String a : arr) {
            result.append(new StringBuilder(a).reverse() +  " ");
        }
        
        //result.setLength(result.length() - 1);
        return result.toString().trim();
    }
}