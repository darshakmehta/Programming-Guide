class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backtrack(result, new ArrayList<Integer>(), n, k, 1);
        return result;
        
    }
    public void backtrack(List<List<Integer>> result, ArrayList<Integer> tempList, int n, int k, int start){
        if(tempList.size()==k) 
            result.add(new ArrayList<>(tempList));
        else if(tempList.size() > k) return;
            
        for(int i = start; i <= n; i++){
            tempList.add(i);
            backtrack(result, tempList, n, k, i + 1);
            tempList.remove(tempList.size()-1);
        }
    }
}
