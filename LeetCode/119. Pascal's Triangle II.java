class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        
        int k = 1;
        for(int i = 1; i <= rowIndex + 1; i++) {
            List<Integer> innerList = new ArrayList<Integer>();
            for(int j = 1; j <= i; j++) {
                if(j == 1 || i == j) {
                    innerList.add(1);
                } else {
                    innerList.add(list.get(i - 2).get(j - 1) + list.get(i - 2).get(j - 2));
                }
            }
            list.add(innerList);
        }
        return list.get(rowIndex);   
    }
}

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prev = new ArrayList<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i <= rowIndex + 1; i++) {
            list = new ArrayList<Integer>();
            for(int j = 1; j <= i; j++) {
                if(j == 1 || i == j) {
                    list.add(1);
                } else {
                    list.add(prev.get(j - 1) + prev.get(j - 2));
                }
            }
            prev = list;
        }
        return list;   
    }
}

/***

TODO: O(k) space
 
**/