class Solution {
    List<String> result = new ArrayList<String>(); // to avoid passing in recursive stack
    
    public List<String> addOperators(String num, int N) {
        if ( num == null || num.length() == 0 ) 
            return result;
        backtrack( new StringBuilder(), num, N, 0, 0, 0 );
        return result;
    }
    public void backtrack(StringBuilder sb, String num, int N, int index, long eval, long multiply) {
        if ( index == num.length() ) {
            if ( N == eval )
                result.add( sb.toString() );
            return;
        }
        for ( int i = index; i < num.length(); i++ ) {
            if( i != index && num.charAt(index) == '0' ) break; // avoid leading zero
            long current = Long.parseLong( num.substring( index, i + 1 ) ); //Long to avoid overflow
            int len = sb.length(); // rem length to backtrack
            if( index == 0 ) {
                backtrack(sb.append(current), num, N, i + 1, current, current);
                sb.setLength(len);
            }
            else {
                backtrack( sb.append( "+" + current ), num, N, i + 1, eval + current , current );
                sb.setLength(len);
                backtrack( sb.append( "-" + current ), num, N, i + 1, eval - current, -current );
                sb.setLength(len);
                backtrack( sb.append( "*" + current ), num, N, i + 1, 
                            eval - multiply + multiply * current, multiply * current ); // (1 + 2 + 3) - 3 + (3 * 4)
                sb.setLength(len);
            }
        }
    }
}