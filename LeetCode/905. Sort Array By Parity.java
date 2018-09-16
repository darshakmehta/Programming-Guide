class Solution {
    public int[] sortArrayByParity(int[] A) {
        LinkedList<Integer> queue = new LinkedList<Integer>();
            
        for(int i = 0; i < A.length; i++) {
            if(A[i] % 2 == 0) {
                queue.addFirst(A[i]);
            } else {
                queue.addLast(A[i]);
            }
        }
        
        for(int i = 0; i < A.length; i++) {
            A[i] = queue.get(i);
        }
        return A;
    }
}