class Solution {
    public int[] sortArrayByParityII(int[] A) {
        List<Integer> evenList = new ArrayList<Integer>();
        List<Integer> oddList = new ArrayList<Integer>();
            
        for(int i = 0; i < A.length; i++) {
            if(A[i] % 2 == 0) {
                evenList.add(A[i]);
            } else {
                oddList.add(A[i]);
            }
        }
        int even = 0; int odd = 0;
        for(int i = 0; i < A.length;) {
            if(even < evenList.size())
                A[i++] = evenList.get(even++);
            if(odd < oddList.size())
                A[i++] = oddList.get(odd++);
        }
        return A;
    }
}