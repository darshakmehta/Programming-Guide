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

/* Not using List */

class Solution {
    public boolean hasAlternatingBits(int n) {
        StringBuilder sb = new StringBuilder();
        
        while (n != 0) {
            sb.append(n % 2);
            n = n / 2;
        }
        
        for ( int i = 1; i < sb.length(); i++ ) {
            if(sb.charAt(i) == sb.charAt(i - 1)) {
                return false;
            }
        }
        
        return true;
    }
}

/* No extra space */

class Solution {
    public boolean hasAlternatingBits(int n) {
        
        int n1 = 0, n2 = 0;
        boolean flag = false;
        while (n != 0) {
            n1 = n % 2;
            n = n / 2;
            if(flag && n1 == n2) {
                 return false;
            }
            if(n == 0) break;
            n2 = n % 2;
            n = n / 2;
            if(n1 == n2) return false;
            flag = true;
        }
        
        return true;
    }
}