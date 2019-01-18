class Solution {
    List<String> result = new ArrayList<String>(); // to avoid passing in recursive stack
    public List<String> addOperators(String num, int target) {
        if ( num == null || num.length() == 0 ) 
            return result;
        backtrack( new StringBuilder(), num, target, 0, 0, 0 );
        return result;
    }
    public void backtrack(StringBuilder sb, String num, int target, int pos, long eval, long multiply) {
        if ( pos == num.length() ) {
            if ( target == eval )
                result.add( sb.toString() );
            return;
        }
        for ( int i = pos; i < num.length(); i++ ) {
            if( i != pos && num.charAt(pos) == '0' ) break; // avoid leading zero
            long current = Long.parseLong( num.substring( pos, i + 1 ) ); //Long to avoid overflow
            int len = sb.length();
            if( pos == 0 ) {
                backtrack(sb.append(current), num, target, i + 1, current, current);
                sb.setLength(len);
            }
            else {
                backtrack( sb.append("+").append(current), num, target, i + 1, eval + current , current );
                sb.setLength(len);
                backtrack( sb.append("-").append(current), num, target, i + 1, eval - current, -current );
                sb.setLength(len);
                backtrack( sb.append("*").append(current), num, target, i + 1, 
                            eval - multiply + multiply * current, multiply * current ); // (1 + 2 + 3) - 3 + (3 * 4)
                sb.setLength(len);
                
            }
        }
    }
}