class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        String[] original = new String[words.length];
        
        for(int i = 0; i < words.length; i++)
            original[i] = words[i];
        
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
               int pos1 = 0;
               int pos2 = 0;
               for (int i = 0; i < Math.min(o1.length(), o2.length()) && pos1 == pos2; i++) {
                  pos1 = order.indexOf(o1.charAt(i));
                  pos2 = order.indexOf(o2.charAt(i));
               }

               if (pos1 == pos2 && o1.length() != o2.length()) {
                   return o1.length() - o2.length();
               }

               return pos1  - pos2  ;

            } 
        });
        
        for(int i = 0; i < original.length; i++) {
            if(!words[i].equals(original[i])) {
                return false;
            }
        }
        
        return true;
    }
    
}