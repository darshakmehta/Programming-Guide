class Solution {
    public boolean hasAlternatingBits(int n) {
        List<Integer> list = new ArrayList<Integer>();
        
        while (n != 0) {
            list.add(n % 2);
            n = n / 2;
        }
        
        for ( int i = 1; i < list.size(); i++ ) {
            if(list.get(i) == list.get(i - 1)) {
                return false;
            }
        }
        
        return true;
    }
}