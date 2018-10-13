class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        
        int k = 1;
        for(int i = 1; i <= numRows; i++) {
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
     return list;   
    }
}