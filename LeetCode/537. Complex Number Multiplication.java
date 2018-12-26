class Solution {
    public String complexNumberMultiply(String a, String b) {
        
        /* ( A + Bi ) * ( C + Di ) = ( A * C − B * D ) + ( A * D + B * C ) * i */
        
        String result = "";
        
        String[] arrA = a.split("\\+");
        
        
        int A = Integer.parseInt(arrA[0]);
        int B = ( Integer.parseInt(arrA[1].split("i")[0]) );
        
        String[] arrB = b.split("\\+");
        
        int C = Integer.parseInt(arrB[0]);
        int D = ( Integer.parseInt(arrB[1].split("i")[0]) );
        
        int part1 = (A * C - B * D);
        int part2 = (A * D + B * C);
        
        result = part1 + "+" + part2 + "i";
        
        
        
        return result;
    }
}