    static boolean isAnagram(String a, String b) {
        // Complete the function
        StringBuilder sb1 = new StringBuilder(a.toLowerCase());
        StringBuilder sb2 = new StringBuilder(b.toLowerCase());
        int count = 0;
        boolean flag = false;
        if(sb1.length() != sb2.length()) {
            return flag;
        }
        for(int i = 0; i < sb1.length(); i++) {
            for(int j = 0; j < sb2.length(); j++) {
                if(sb1.charAt(i) == sb2.charAt(j)) {
                    flag = true;
                    sb2.deleteCharAt(j);
                    break;
                }
            }
            if(!flag)
                return false;
        }
        return sb2.toString().equals("");
        
    }